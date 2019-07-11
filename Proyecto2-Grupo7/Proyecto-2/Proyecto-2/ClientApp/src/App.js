import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import { Home } from './components/Home';
import { FetchData } from './components/FetchData';
import { Counter } from './components/Counter';
import { Products } from './components/Products';
import { Organizacions } from './components/Organizacions';
import { OrganizacionModificar } from './components/OrganizacionModificar';
import { ImpuestoModificar } from './components/ImpuestoModificar';
import { NuevoProducto } from './components/NuevoProducto';
import { Impuestos } from './components/Impuestos';
import { Login } from './components/Login';
import { Register } from './components/Register';
import { ShoppingCart } from './components/ShoppingCart';


export default class App extends Component {
    displayName = App.name

    render() {
        return (
            <Layout>
                <Route exact path='/' component={Products} />
                <Route exact path='/login' component={Login} />
                <Route exact path='/register' component={Register} />
                <Route exact path='/organizacions' component={Organizacions} />
                <Route exact path='/organizacionModificar' component={OrganizacionModificar} />
                <Route exact path='/impuestoModificar' component={ImpuestoModificar} />
                <Route exact path='/impuestos' component={Impuestos} />
                <Route exact path='/nuevoProducto' component={NuevoProducto} />
                <Route exact path='/shoppingcart' component={ShoppingCart} />
                <Route path='/counter' component={Counter} />
                <Route path='/fetchdata' component={FetchData} />
            </Layout>
        );
    }
}
