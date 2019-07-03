import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';
import '../index.css';

export class BtnCarrito extends Component {
    displayName = BtnCarrito.name

  constructor(props) {
    super(props);

  
  }


  render() {
 

    return (
      
             
        <div>
            <Col sm={2}><button class="glyphicon glyphicon-shopping-cart"></button></Col>    
            <a href='./login'><span class="glyphicon glyphicon-user"></span></a>
              </div >

    );
  }
}
