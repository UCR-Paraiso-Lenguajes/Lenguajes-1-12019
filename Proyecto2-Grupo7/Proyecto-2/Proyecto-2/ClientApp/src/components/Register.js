


import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class Register extends Component {
    displayName = Register.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Grid>
                    
                    <Row>
                        <form >
                            <label ><b>Nombre de Usuario</b></label>
                            <input type="text" placeholder="Enter Username" required />

                            <label for="psw"><b>Email</b></label>
                            <input type="text" placeholder="Enter Email" required />

                            <label for="psw"><b>Contraseña</b></label>
                            <input type="password" placeholder="Enter Password" required />

                            <button type="submit">Registrarse</button>
                        </form >
                    </Row>
                </Grid>
            </div>
        );
    }
}
