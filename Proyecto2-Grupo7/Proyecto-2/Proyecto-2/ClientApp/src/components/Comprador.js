import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';
import { Product } from './Product';
import { Search } from './Search';
import { BtnCarrito } from './BtnCarrito';



export class Products extends Component {
  displayName = Products.name

  constructor(props) {
    super(props);
      this.state = { products: [], loading: true };

      fetch('api/productos')
          .then(response => response.json())
          .then(data => {
              this.setState({ products: data, loading: false });
          });
  
  }


  render() {
 

    return (
        <Grid>
            <Row sm={4}>
                <Search Tittle="buscar" />
                <BtnCarrito />
            </Row>
            <Row>
            {this.state.products.map(product =>
               
                    <Col sm={4}>
                        <Product title={product.nombre} image={product.url_image} description={product.descripcion} cantidadDisponible={product.cantidadDisponible} id={product.id} impuesto={product.impuesto} />
                    </Col>
                )}
                </Row>
          
              </Grid >
    );
  }
}
