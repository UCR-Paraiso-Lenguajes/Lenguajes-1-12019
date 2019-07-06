import React, { Component } from 'react';
import { Departamento } from './Departamento';
import { Col, Grid, Row } from 'react-bootstrap';

export class Departamentos extends Component {
    displayName = Departamentos.name
    constructor(props) {
        super(props);
        this.state = { departamentos: [], loading: true };

        fetch('api/departamentos')
            .then(response => response.json())
            .then(data => {
                this.setState({ departamentos: data, loading: false });
            });

    }


    render() {


        return (
            <div className="container">

            <Grid>
               
                {this.state.departamentos.map(departamento =>
                        <Col sm={4}>
                            <Departamento id={departamento.id} nombre={departamento.nombre} />
                        </Col>
                        
                )}
                </Grid >
                </div>
        );
    }
}
