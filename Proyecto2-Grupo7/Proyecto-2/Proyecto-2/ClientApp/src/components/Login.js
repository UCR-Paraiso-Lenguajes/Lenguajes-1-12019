

import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';



export class Login extends Component {
    displayName = Login.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Grid>
                    
                    <Row>
                        <form >
                                <label id="nombreUsuario" ><b>Nombre de Usuario</b></label>
                                <input type="text" placeholder="Enter Username"  required/>

                                    <label ><b>Contraseña</b></label>
                                    <input type="password" placeholder="Enter Password"  required/>

                                     <button type="submit">Login</button>                               
                            <a href='./register'>Registrarse</a>
                            </form >
                    </Row>
                </Grid>
            </div>
        );
    }
}
