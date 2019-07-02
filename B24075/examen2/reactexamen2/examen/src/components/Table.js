import React, { Component } from 'react';
import { getDivisions } from '../apiRequests';

export default class Table extends Component {

  constructor(props) {
    super(props);
    this.state = {
      items: []
    };
  }

  async loadItems() {
    let data = await getDivisions();
    this.setState({
      items: data.divisions
    })
  }

  async componentDidMount() {
    // Cuando el componente esta listo para renderizarse obtiene la lista de departamentos desde del api
    await this.loadItems();
  }

  renderItems() {
    return (
      this.state.items.map((item) =>
        <tr key={item.id} className={item.marcado? 'marked' : ''}>
          <td>{item.id}</td>
          <td>{item.nombre}</td>
          <td>{item.jefatura}</td>
        </tr>
      )
    )
  }

  render() {
    return (
      <table className='table'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Jefatura</th>
          </tr>
        </thead>
        <tbody>
          {this.renderItems()}
        </tbody>
      </table>
    )
  }
}