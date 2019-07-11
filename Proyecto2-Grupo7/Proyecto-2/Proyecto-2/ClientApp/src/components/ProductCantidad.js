import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class ProductCantidad extends Component {
    displayName = ProductCantidad.name

    constructor(props) {
        super(props);
    }
   
    render() {
        return (
            <div>
                <Grid>
                    <Row>
                        <h1>{this.props.title}</h1>
                    </Row>
                    <Row>
                        <p>
                            {this.props.cantidad}
                        </p>
                    </Row>
                  
                </Grid>
            </div>
        );
    }
   

}
