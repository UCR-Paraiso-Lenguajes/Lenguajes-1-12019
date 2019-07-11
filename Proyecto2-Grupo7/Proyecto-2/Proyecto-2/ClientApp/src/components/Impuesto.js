import React, { Component } from 'react';
import { Col, Grid, Row, Button } from 'react-bootstrap';

export class Impuesto extends Component
{
    displayName = Impuesto.valor

    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    render() {
        return (
            < div >
                < Grid >


                    < Row >
                        < p >
                            { this.props.valor}

                        </ p >
                    </ Row >

                  </ Grid >
     
                 </ div >
        );
    }
    handleClick() {
        var descripcion = this.props.descripcion;

        fetch('api/actualizarImpuesto', {
        method: 'PUT',
            headers:
            {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
            descripion: descripcion
            })
        }

        )
        window.location.reload();

    }

}