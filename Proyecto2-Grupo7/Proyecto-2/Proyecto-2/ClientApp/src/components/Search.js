import React, { Component } from 'react';
import { Col, Grid, Row } from 'react-bootstrap';

export class Search extends Component {
  displayName = Search.name

  constructor(props) {
    super(props);

  
  }


  render() {
 

    return (
        <div>
           
            <Col sm={3}> <input type="text" class="form-control" /></Col>  

                

        </div >
            
           
    );
  }
}
