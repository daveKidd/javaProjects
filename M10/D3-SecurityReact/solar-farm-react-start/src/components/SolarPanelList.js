import { useEffect, useState, useContext } from 'react';
import { Link } from 'react-router-dom';
import AuthContext from '../AuthContext';

function SolarPanelList() {
    const [solarPanels, setSolarPanels] = useState([]);

    const auth = useContext(AuthContext);

    useEffect(() => {
        fetch("http://localhost:8080/api/solarpanel")
            .then(response => response.json())
            .then(data => setSolarPanels(data))
            .catch(console.log)
    }, [])

    const handleDeletePanel = (solarPanelId) => {
        const solarPanel = solarPanels.find(solarPanel => solarPanel.id === solarPanelId);

        if (window.confirm(`Delete Panel # ${solarPanel.id} ?`)) {
            const init = {
                method: "DELETE",
                headers:{
                    "Authorization": `Bearer ${auth.user.token}`
                }
            }

            fetch(`http://localhost:8080/api/solarpanel/${solarPanelId}`, init)
                .then(response => {
                    if (response.status === 204) {
                        const newSolarPanels = solarPanels.filter(solarPanel => solarPanel.id !== solarPanelId)
                        setSolarPanels(newSolarPanels);
                    }
                    else {
                        return Promise.reject.apply(`Unexpected status code: ${response.status}`)
                    }
                })
                .catch(console.log);
        }
    }



    return (
        <>
            <Link className="btn btn-primary my-4" to="/solarpanels/add">
                <i className="bi bi-plus-circle"></i> Add Solar Panel
            </Link>
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
                                    <Link className="btn btn-primary btn-sm mr-2" to={`/solarpanels/edit/${panel.id}`}>
                                        <i className="bi bi-pencil-square"></i> Edit
                                    </Link>
                                    {auth.user && auth.user.hasRole("ROLE_ADMIN") && (
                                        <button className="btn btn-danger btn-sm" onClick={() => handleDeletePanel(panel.id)}>
                                            <i className="bi bi-trash"></i> Delete
                                        </button>
                                    )}
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    )
}

export default SolarPanelList;