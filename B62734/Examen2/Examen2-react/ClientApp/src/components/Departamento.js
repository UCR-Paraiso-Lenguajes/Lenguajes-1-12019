import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';

export class Departamento extends Component {
    displayName = Departamento.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="container">
               
                    
                    <Row>
                        <h1>{this.props.id}</h1>
                    </Row>
                    <Row>
                        <h1>{this.props.nombre}</h1>
                    </Row>
                    
                    
            </div>
        );
    }
}
