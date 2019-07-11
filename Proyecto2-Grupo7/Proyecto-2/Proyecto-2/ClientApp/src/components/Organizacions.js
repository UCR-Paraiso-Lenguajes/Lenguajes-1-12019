import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';
import { Organizacion } from './Organizacion';
import { Search } from './Search';
import { BtnCarrito } from './BtnCarrito';

export class Organizacions extends Component {
    displayName = Organizacions.descripcion

    constructor(props) {
        super(props);
        this.state = { organizacions: [], loading: true };

        fetch('api/organizacion')
            .then(response => response.json())
            .then(data => {
                this.setState({ organizacions: data, loading: false });
            });

    }


    render() {

        return (
            <Grid>
                <Row sm={4}>
                    <Search Tittle="buscar" />
                    <BtnCarrito />
                </Row>

                <h1>Descripcion de la empresa</h1>
                <Row>
                    {this.state.organizacions.map(organizacion =>

                        <Col sm={4}>
                            <Organizacion descripcion={organizacion.descripcion}/>
                        </Col>
                    )}
                </Row>
                <a href='./OrganizacionModificar'>Modificar</a>
            </Grid >
        );
    }
}

