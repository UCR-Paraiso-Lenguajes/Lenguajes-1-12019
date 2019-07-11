
import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class ImpuestoModificar extends Component {
    displayName = ImpuestoModificar.name

    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    render() {
        return (
            <div>
                <Grid>

                    <Row>
                        <div class="form-group">
                            <label for="usr">Nuevo Impuesto:</label>
                            <input id="imp" type="number" step="any" class="form-control"></input>
                        </div>
                    </Row>

                    <Row>
                        <Button variant="primary" onClick={this.handleClick}>Actualizar</Button>
                    </Row>
                </Grid>
            </div>
        );
    }
            
    handleClick() {
        var valor = document.getElementById("imp").value;
        console.log(valor);
        fetch('api/actualizarImpuesto', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                Valor: valor,
                LastUpdate: null
            })
        }

        )
        window.location.reload();

    }

}
