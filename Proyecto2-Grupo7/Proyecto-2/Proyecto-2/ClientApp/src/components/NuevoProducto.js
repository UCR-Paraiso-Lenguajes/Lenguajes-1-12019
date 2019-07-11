import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class NuevoProducto extends Component {
    displayName = NuevoProducto.name

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

                                <label ><b>Nuevo Producto</b></label>

                                <form >

                                    <div class="form-group">
                                        <label ><b>Nombre del Producto</b></label>
                                        <input id="nombreProducto" type="text" placeholder="Nombre del articulo" required />
                                    </div>


                                    <div class="form-group">
                                        <label for="psw"><b>URL de la imagen</b></label>
                                        <input id="url" type="text" placeholder="URL de la imagen" required />
                                    </div>

                                    <div class="form-group">
                                        <label for="psw"><b>Descripcion</b></label>
                                        <input id="descripcion" type="text" placeholder="Descripcion" required />
                                    </div>

                                    <div class="form-group">
                                        <label for="psw"><b>Cantidad disponible</b></label>
                                        <input id="unidades" type="number" step="any" placeholder="Unidades" required />
                                    </div>

                                    <button type="submit" onClick={this.handleClick}>Insertar</button>
                                </form >
                            </div>
                        </div>
                    </Row>
                </Grid>
            </div>
        );
    }
    handleClick() {
        var name = document.getElementById("nombreProducto").value;
        var url = document.getElementById("url").value;
        var descripcion = document.getElementById("descripcion").value;
        var unidades = document.getElementById("unidades").value;
        var imp = 13;
        fetch('api/insertarProducto', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                Impuesto: imp,
                Nombre: name,
                URL_image: url,
                Descripcion: descripcion,
                CantidadDisponible: unidades
            })
        }

        )
        window.location.reload();

    }
}
