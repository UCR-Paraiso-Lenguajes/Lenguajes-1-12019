


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

                        <div class="row">
                            <div class="col-sm-6">

                        <form >

                            <div class="form-group">
                            <label ><b>Nombre de Usuario</b></label>
                            <input id="userName" type="text" placeholder="Ingrese su nombre de usuario" required />
                            </div>


                                <div class="form-group">
                            <label for="psw"><b>Correo Electronico</b></label>
                            <input id="email" type="text" placeholder="Correo Electronico" required />
                                </div>

                                    <div class="form-group">
                            <label for="psw"><b>Contraseña</b></label>
                            <input id="passOne" type="password" placeholder="Contraseña" required />
                                    </div>

                                        <div class="form-group">
                            <label for="psw"><b>Verificación Contraseña</b></label>
                            <input id="passTwo" type="password" placeholder="Ingresar Contraseña" required />
                                            </div>

                            <button type="submit" onClick={this.handleClick}>Registrarse</button>
                                </form >
                            </div>
                        </div>
                    </Row>
                </Grid>
            </div>
        );
    }
    handleClick() {
        var userName = document.getElementById("userName").value;
        var userMail = document.getElementById("email").value;
        var password = document.getElementById("passOne").value;
        
        fetch('api/crearComprador', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                UserName: userName,
                EmailPrincipal: userMail,
                Password: password
            })
        }

        )
        window.location.reload();

    }
}
