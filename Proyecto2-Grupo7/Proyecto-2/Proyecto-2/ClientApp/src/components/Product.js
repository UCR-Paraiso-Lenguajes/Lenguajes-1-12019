import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class Product extends Component {
    displayName = Product.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Grid>
                    <Row>
                        <img src="https://www.ford.mx/content/dam/Ford/website-assets/latam/mx/nameplate/figo/2019/showroom/ford-figo-2019-auto-compacto-lateral-gris.png" />
                    </Row>
                    <Row>
                        <h1>{this.props.title}</h1>
                    </Row>
                    <Row>
                        <p>
                            Conoce Ford Figo 2019 y descubre todo lo <br />
                            que puedes hacer con este gran Auto Compacto

                        </p>
                    </Row>
                    <Row>
                        <Button variant="primary">Agregar</Button>
                    </Row>
                </Grid>
            </div>
        );
    }
}
