

import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class ShoppingCart extends Component {
    displayName = ShoppingCart.name

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
             
                        <div class="container">
                            <button id="btncomprar" class="btn btn-primary">Realizar compra</button>

                        </div>
                        <div id="listado" class="row">
                        <table class="egt">

                            <tr>

                                <td>Celda 1</td>

                                <td>Celda 2</td>

                                <td>Celda 3</td>

                            </tr>

                            <tr>

                                <td>Celda 4</td>

                                <td>Celda 5</td>

                                <td>Celda 6</td>

                            </tr>

                        </table>

                      
                        </div>
                        </div>
             
           
        );
    }
}
