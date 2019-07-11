
import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class OrganizacionModificar extends Component {
    displayName = OrganizacionModificar.name

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
                            <label for="comment">Comment:</label>
                            <textarea class="form-control" rows="5" id="comment"></textarea>
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
        var descripcion = document.getElementById("comment").value;
        console.log(descripcion);
        fetch('api/actualizarOrganizacion', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                Descripion: descripcion,
                LastUpdate: null
            })
        }

        )
        window.location.reload();

    }

}
