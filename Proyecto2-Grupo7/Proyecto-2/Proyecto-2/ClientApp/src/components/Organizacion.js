import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class Organizacion extends Component {
    displayName = Organizacion.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Grid>
                        <Row>
                            <h1>{this.props.descripcion}</h1>
                        </Row>
                </Grid>
            </div>
        );
    }

}

