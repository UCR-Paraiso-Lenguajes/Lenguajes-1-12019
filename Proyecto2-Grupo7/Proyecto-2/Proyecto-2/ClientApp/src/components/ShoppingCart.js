

import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';
import { ProductCantidad } from './ProductCantidad';
import Cookies from "universal-cookie";

export class ShoppingCart extends Component {
    displayName = ShoppingCart.name

    constructor(props) {
        super(props);
        this.state = { products: [], loading: true };
        const cookies = new Cookies();
        var carritoId = cookies.get('carritoId');

        fetch('api/getProductosCarrito/' + carritoId)
   
            .then(response => response.json())
            .then(data => {
                this.setState({ products: data, loading: false });
            });
    }

    render() {
        return (
            <Grid>
                <script
                    src="/path/to/js.cookie.js"
                   
                ></script>
                        <div class="container">
                            <button id="btncomprar" class="btn btn-primary">Realizar compra</button>

                        </div>
                        <div id="listado" class="row">
                        <table class="egt">

                        <Row>
                          
                            {this.state.products.map(product =>

                                <Col sm={4}>
                                    <ProductCantidad title={product.producto.nombre} cantidad={product.cantidad}/>
                                </Col>
                            )}
                        </Row>

                        </table>

                      
                        </div>
                        </Grid>
             
           
        );
    }
}
