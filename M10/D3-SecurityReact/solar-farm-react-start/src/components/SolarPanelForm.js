import { useEffect, useState, useContext } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom';
import AuthContext from '../AuthContext';

const SOLAR_PANEL_DEFAULT = {
    section: "",
    row: 0,
    column: 0,
    yearInstalled: 0,
    material: "POLY_SI",
    tracking: false
}

function SolarPanelForm() {
    const [solarPanel, setSolarPanel] = useState(SOLAR_PANEL_DEFAULT);
    const [errors, setErrors] = useState([]);
    const history = useHistory();
    const { id } = useParams();    
    // const params = useParams();
    // const id = params.id;

    const auth = useContext(AuthContext);

    useEffect(()=>{
        if(id){
            fetch(`http://localhost:8080/api/solarpanel/${id}`)
                .then(response => {
                    if(response.status === 200){
                        return response.json()
                    }else{
                        return Promise.reject(`Unexpected status code: ${response.status}`)
                    }                    
                })
                .then(data=> setSolarPanel(data))
                .catch(console.log)
        }
    },[id])

    const handleChange = (event) => {
        const newSolarPanel = { ...solarPanel };

        if (event.target.type === "checkbox") {
            newSolarPanel[event.target.name] = event.target.checked;
        } else {
            newSolarPanel[event.target.name] = event.target.value;
        }

        setSolarPanel(newSolarPanel);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        if (!id) {
            addSolarPanel();
        } else {
            updateSolarPanel();
        }
    }

    const addSolarPanel = () => {
        const init = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${auth.user.token}`
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
                    history.push("/solarpanels")
                } else {
                    setErrors(data);
                }
            })
            .catch(console.log);
    }

    const updateSolarPanel = () => {
        solarPanel.id = id;

        const init = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${auth.user.token}`
            },
            body: JSON.stringify(solarPanel)
        }

        fetch(`http://localhost:8080/api/solarpanel/${id}`, init)
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
                    history.push("/solarpanels")
                } else {
                    setErrors(data);
                }
            })
            .catch(console.log);
    }

    return (        
        <form onSubmit={handleSubmit}>
            <h2 className="mb-4">{id ? "Update Solar Panel" : "Add Solar Panel"}</h2>
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
                    <i className="bi bi-file-earmark-check"></i> {id ? "Update Solar Panel" : "Add Solar Panel"}
                </button>
                <Link className="btn btn-warning" to="/solarpanels">
                    <i className="bi bi-stoplights"></i> Cancel
                </Link>
            </div>
        </form>
    )
}

export default SolarPanelForm;