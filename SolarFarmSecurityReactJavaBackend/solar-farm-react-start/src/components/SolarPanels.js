import { useEffect, useState } from 'react';

const SOLAR_PANEL_DEFAULT = {
    section: "",
    row: 0,
    column: 0,
    yearInstalled: 0,
    material: "POLY_SI",
    tracking: false
}

function SolarPanels() {
    const [solarPanels, setSolarPanels] = useState([]);
    const [solarPanel, setSolarPanel] = useState(SOLAR_PANEL_DEFAULT);
    const [editSolarPanelId, setEditSolarPanelId] = useState(0);
    const [currentView, setCurrentView] = useState("List");
    const [errors, setErrors] = useState([]);


    useEffect(() => {
        fetch("http://localhost:8080/api/solarpanel")
            .then(response => response.json())
            .then(data => setSolarPanels(data))
            .catch(console.log)
    }, [])

    const handleChange = (event) => {
        const newSolarPanel = { ...solarPanel };

        if (event.target.type === "checkbox") {
            newSolarPanel[event.target.name] = event.target.checked;
        } else {
            newSolarPanel[event.target.name] = event.target.value;
        }

        setSolarPanel(newSolarPanel);
    }

    const handleEditPanel = (solarPanelId) => {
        setEditSolarPanelId(solarPanelId)
        const solarPanel = solarPanels.find(solarPanel => solarPanel.id === solarPanelId);
        const editSolarPanel = { ...solarPanel };
        setSolarPanel(editSolarPanel);
        setCurrentView("Edit")
    }

    const handleDeletePanel = (solarPanelId) => {
        const solarPanel = solarPanels.find(solarPanel => solarPanel.id === solarPanelId);

        if (window.confirm(`Delete Panel # ${solarPanel.id} ?`)) {
            const init = {
                method: "DELETE"
            }

            fetch(`http://localhost:8080/api/solarpanel/${solarPanelId}`, init)
                .then(response => {
                    if (response.status === 204) {
                        const newSolarPanels = solarPanels.filter(solarPanel => solarPanel.id !== solarPanelId)
                        setSolarPanels(newSolarPanels);
                        resetState();
                    }
                    else {
                        return Promise.reject.apply(`Unexpected status code: ${response.status}`)
                    }
                })
                .catch(console.log);
        }
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        if (editSolarPanelId === 0) {
            addSolarPanel();
        } else {
            updateSolarPanel();
        }
    }

    const addSolarPanel = () => {
        const init = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(solarPanel)
        }

        fetch(`http://localhost:8080/api/solarpanel`, init)
            .then(response => {
                if (response.status === 201 || response.status === 400) {
                    return response.json()
                }
                else {
                    return Promise.reject.apply(`Unexpected status code: ${response.status}`)
                }
            })
            .then(data => {
                if (data.id) {
                    const newSolarPanels = [...solarPanels, data];
                    setSolarPanels(newSolarPanels);
                    resetState();
                } else {
                    setErrors(data);
                }
            })
            .catch(console.log);
    }

    const updateSolarPanel = () => {
        solarPanel.id = editSolarPanelId;

        const init = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(solarPanel)
        }

        fetch(`http://localhost:8080/api/solarpanel/${editSolarPanelId}`, init)
            .then(response => {
                if (response.status === 204) {
                    return null
                }
                else if(response.status === 400){
                    return response.json()
                } 
                else{
                    return Promise.reject.apply(`Unexpected status code: ${response.status}`)
                }
            })
            .then(data => {
                if (!data) {
                    const newSolarPanels = [...solarPanels];
                    const indexToUpdate = newSolarPanels.findIndex(panel => panel.id === editSolarPanelId);
                    newSolarPanels[indexToUpdate] = solarPanel;
                    setSolarPanels(newSolarPanels);
                    resetState();
                } else {
                    setErrors(data);
                }
            })
            .catch(console.log);
    }


    const resetState = () => {
        setSolarPanel(SOLAR_PANEL_DEFAULT);
        setEditSolarPanelId(0);
        setCurrentView("List");
        setErrors([]);
    }

    return (
        <>
            <h2>Solar Panels</h2>

            {(currentView === "Add" || currentView === "Edit") && (
                <form onSubmit={handleSubmit}>
                    {errors.length > 0 && (
                        <div className="alert alert-danger">
                            <p>The following errors were found:</p>
                            <ul>
                                {errors.map(error => (
                                    <li key={error}>{error}</li>
                                ))}
                            </ul>
                        </div>
                    )}
                    <div className="form-group">
                        <label htmlFor="section">Section:</label>
                        <input id="section" name="section" type="text" className="form-control"
                            value={solarPanel.section} onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="row">Row:</label>
                        <input id="row" name="row" type="number" className="form-control"
                            value={solarPanel.row} onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="column">Column:</label>
                        <input id="column" name="column" type="number" className="form-control"
                            value={solarPanel.column} onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="yearInstalled">Year Installed:</label>
                        <input id="yearInstalled" name="yearInstalled" type="number" className="form-control"
                            value={solarPanel.yearInstalled} onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="material">Material:</label>
                        <select id="material" name="material" className="form-control"
                            value={solarPanel.material} onChange={handleChange}>
                            <option>POLY_SI</option>
                            <option>MONO_SI</option>
                            <option>A_SI</option>
                            <option>CD_TE</option>
                            <option>CIGS</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <input id="tracking" name="tracking" type="checkbox" className="mr-2"
                            checked={solarPanel.tracking} onChange={handleChange} />
                        <label htmlFor="tracking">Is Tracking?</label>
                    </div>
                    <div className="mt-4">
                        <button className="btn btn-success mr-2" type="submit">
                            <i className="bi bi-file-earmark-check"></i> {editSolarPanelId > 0 ? "Update Solar Panel" : "Add Solar Panel"}
                        </button>
                        <button className="btn btn-warning" type="button" onClick={resetState}>
                            <i className="bi bi-stoplights"></i> Cancel
                        </button>
                    </div>
                </form>
            )}

            {currentView === "List" && (
                <>
                    <button className="btn btn-primary my-4" onClick={() => setCurrentView("Add")}>
                        <i className="bi bi-plus-circle"></i> Add Solar Panel
                    </button>
                    <table className="table table-striped table-hover table-sm">
                        <thead className="thead-dark">
                            <tr>
                                <th>Section</th>
                                <th>Row-Column</th>
                                <th>Year Installed</th>
                                <th>Material</th>
                                <th>Is Tracking?</th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                            {solarPanels.map(panel => (
                                <tr key={panel.id}>
                                    <td>{panel.section}</td>
                                    <td>{panel.row}-{panel.column}</td>
                                    <td>{panel.yearInstalled}</td>
                                    <td>{panel.material}</td>
                                    <td>{panel.tracking ? 'Yes' : 'No'}</td>
                                    <td>
                                        <div className="float-right mr-2">
                                            <button className="btn btn-primary btn-sm mr-2" onClick={() => handleEditPanel(panel.id)}>
                                                <i className="bi bi-pencil-square"></i> Edit
                                            </button>
                                            <button className="btn btn-danger btn-sm" onClick={() => handleDeletePanel(panel.id)}>
                                                <i className="bi bi-trash"></i> Delete
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </>
            )}
        </>
    )
}

export default SolarPanels;