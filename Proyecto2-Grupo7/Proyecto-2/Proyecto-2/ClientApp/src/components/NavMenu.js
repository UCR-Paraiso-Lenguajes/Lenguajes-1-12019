import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Glyphicon, Nav, Navbar, NavItem } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import './NavMenu.css';

export class NavMenu extends Component {
  displayName = NavMenu.name

  render() {
    return (
      <Navbar inverse fixedTop fluid collapseOnSelect>
        <Navbar.Header>
          <Navbar.Brand>
            <Link to={'/'}>reac3</Link>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
          <Nav>
            <LinkContainer to={'/'} exact>
              <NavItem>
                <Glyphicon glyph='home' /> Productos
              </NavItem>
            </LinkContainer>
                    <LinkContainer to={'/shoppingcart'} exact>
                    <NavItem>
                            <Glyphicon glyph='shopping-cart' /> Carrito de Compras
              </NavItem>
                    </LinkContainer>
                    <LinkContainer to={'/organizacions'} exact>
                        <NavItem>
                            <Glyphicon glyph='globe' /> Organizacion
              </NavItem>
                    </LinkContainer>
                    <LinkContainer to={'/impuestos'} exact>
                        <NavItem>
                            <Glyphicon glyph='euro' /> Impuesto
              </NavItem>
                    </LinkContainer>
                    <LinkContainer to={'/nuevoProducto'} exact>
                        <NavItem>
                            <Glyphicon glyph='euro' /> Nuevo Producto
              </NavItem>
                    </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}
