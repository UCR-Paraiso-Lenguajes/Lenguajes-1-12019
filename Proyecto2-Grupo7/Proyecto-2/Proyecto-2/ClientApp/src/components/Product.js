import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';
import Cookies from "universal-cookie";

export class Product extends Component {
    displayName = Product.name

    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }
   
    render() {
        return (
            <div>
                <Grid>
                    <Row>
                        <img src={this.props.image} />
                    </Row>
                    <Row>
                        <h1>{this.props.title}</h1>
                    </Row>
                    <Row>
                        <p>
                            {this.props.description}

                        </p>
                    </Row>
                    <Row>
                        <p>
                            {this.props.cantidadDisponible}

                        </p>
                    </Row>
                    <Row>
                        <Button variant="primary" onClick={this.handleClick}>Agregar</Button>
                    </Row>
                </Grid>
            </div>
        );
    }
    handleClick() {
        var image = this.props.image;
        var title = this.props.title;
        var description = this.props.description;
        var cantidadDisponible = this.props.cantidadDisponible - 1;
        var id = this.props.id;
        var impuesto = this.props.impuesto;
        fetch('api/actualizarProducto', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                url_image: image,
                id: id,
                impuesto: impuesto,
                nombre: title,
                descripcion: description,
                cantidadDisponible: cantidadDisponible
            })
        }

        )

        window.location.reload(); 
        const cookies = new Cookies();
        cookies.set('carritoId', 1);
    }

}
