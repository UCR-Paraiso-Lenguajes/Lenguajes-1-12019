import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';
import { Impuesto } from './Impuesto';
import { Search } from './Search';
import { BtnCarrito } from './BtnCarrito';

export class Impuestos extends Component {
    displayName = Impuestos.descripcion

    constructor(props) {
        super(props);
        this.state = { impuestos: [], loading: true };

        fetch('api/impuesto')
            .then(response => response.json())
            .then(data => {
                this.setState({ impuestos: data, loading: false });
            });

    }

    render() {

        return (
            <Grid>
                <Row sm={4}>
                    <Search Tittle="buscar" />
                    <BtnCarrito />
                </Row>

                <h1>Impuesto Actual</h1>
                <Row>
                    {this.state.impuestos.map(impuesto =>

                        <Col sm={4}>
                            <Impuesto valor={impuesto.valor}/>
                        </Col>
                    )}
                </Row>
                <a href='./ImpuestoModificar'>Modificar</a>
            </Grid >
        );
    }

}

