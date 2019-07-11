

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

                        <Col>

                            <form class="form-horizontal">

                            <div class="form-group">
                            <label id="emailUser" ><b>Correo</b></label>
                            <input type="text" placeholder="Ingrese su cuenta de correo electronico" required />
                            </div>

                            <div class="form-group">
                            <label ><b>Contraseña</b></label>
                            <input id="password" type="password" placeholder="Ingrese su contraseña" required />
                            </div>

                            <button type="submit" onClick={this.handleClick}>Login</button>
                            <a href='./register'>Registrarse</a>
                            </form >
                           </Col>
                    </Row>
                </Grid>
            </div>

        );
    }
        handleClick() {
            var userMail = document.getElementById("emailUser");
            var password = document.getElementById("password");

            fetch('api/logearComprador', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    EmailPrincipal: userMail,
                    Password: password
                })
            }

            )
            window.location.reload();

        }
    }

