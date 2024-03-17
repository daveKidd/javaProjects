import React, { useState, useContext } from 'react';
import { Link, useHistory } from 'react-router-dom';
import AuthContext from '../AuthContext';
import Errors from './Errors';

export default function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState([]);

    const auth = useContext(AuthContext);

    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();

        const authAttempt = {
            username,
            password
        };

        const init = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(authAttempt)
        };

        fetch('http://localhost:8080/api/authenticate', init)
            .then(response => {
                if (response.status === 200) {
                    return response.json(); // this will be the token: jwt_token: 2039ja;slkdfj;la
                } else if (response.status === 403) {
                    return null;
                } else {
                    return Promise.reject(`Unexpected status code: ${response.status}`);
                }
            })
            .then(data => {
                if (data) {
                    // {
                    //   "jwt_token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjYWxvcmllLXRyYWNrZXIiLCJzdWIiOiJzbWFzaGRldjUiLCJhdXRob3JpdGllcyI6IlJPTEVfVVNFUiIsImV4cCI6MTYwNTIzNDczNH0.nwWJtPYhD1WlZA9mGo4n5U0UQ3rEW_kulilO2dEg7jo"
                    // }
                    auth.login(data.jwt_token);
                    history.push('/');
                } else {
                    // we have error messages
                    setErrors(['login failed ):']);
                }
            })
            .catch(console.log);
    };

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    return (
        <>
            <h2>Login</h2>
            <br />
            <Errors errors={errors} />
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="username">Username:</label>
                    <input id="username" type="text" className="form-control col-sm-5"
                        onChange={handleUsernameChange} value={username} />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password:</label>
                    <input id="password" type="password" className="form-control col-sm-5"
                        onChange={(event) => setPassword(event.target.value)} value={password} />
                </div>
                <div>
                    <button type="submit" className="btn btn-primary mb-3">Login</button>
                    <br />
                    <Link to="/register">I don't have an account</Link>
                </div>
            </form>
        </>
    );
}