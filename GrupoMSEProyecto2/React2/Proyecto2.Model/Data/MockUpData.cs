using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class MockUpData
    {
        private static List<Carrito> carritos = new List<Carrito>();
        public List<Carrito> Carritos
        {
            get { return carritos; }
        }
        private static List<Usuario> usuarios = new List<Usuario>();
        public List<Usuario> Usuarios
        {
            get { return usuarios; }
        }

        private OrdenDeCompra getOrdenDeCompra(int cantidadProductos)
        {
            List<ProductoCantidad> listaProductos = new List<ProductoCantidad>();
            ProductoCantidad productoCantidad;
            Producto producto;
            
            for (int i = 1; i < cantidadProductos; i++)
            {
                if (i % 2 == 0)
                {
                    producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11, "https://pictures.dealer.com/t/twowheelmotorsportguelphtc/0354/1447ce5c0fe8b9e07bb124be064018d2x.jpg?impolicy=resize&w=240");
                }
                else
                {
                    producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11, "https://www.ford.mx/content/dam/Ford/website-assets/latam/mx/nameplate/figo/2019/showroom/ford-figo-2019-auto-compacto-lateral-gris.png");
                }
                productoCantidad = new ProductoCantidad(producto, i);
                listaProductos.Add(productoCantidad);
            }
            return new OrdenDeCompra(listaProductos);

        }
        public void llenaMockCarritos()
        {
            
            PedidoPendiente pedidoPendiente;
            PedidoDespachado pedidoDespachado;
            PedidoEntregado pedidoEntregado;
            Usuario usuario;
            Carrito carrito;

            for (int i = 1; i <= 20; i++)
            {
                if (i % 2 == 0)
                {
                    pedidoPendiente = new PedidoPendiente(1, "helloWord"+i+"d@hotmail.com", "Perez Zeledon, San Jose, Costa Rica"+i, getOrdenDeCompra(i), DateTime.Now);
                    usuario = new Usuario(i,"Usuario "+i,"psw_"+i,"correoUsuario_"+i+"@gmail.com");
                    usuarios.Add(usuario);
                    carrito = new Carrito("carrito "+i,usuario, pedidoPendiente);
                    carritos.Add(carrito);
                }
                else if (i % 3 == 0)
                {
                    pedidoDespachado = new PedidoDespachado(2, "helloWorld"+i+"@hotmail.com", "Desamparados, San Jose, Costa Rica"+i, getOrdenDeCompra(i),
                DateTime.Now, getOrdenDeCompra(7).TotalCompra);
                    usuario = new Usuario(i, "Usuario " + i, "psw_" + i, "correoUsuario_" + i + "@hotmail.com");
                    usuarios.Add(usuario);
                    carrito = new Carrito("carrito " + i, usuario, pedidoDespachado);
                    carritos.Add(carrito);
                }
                else if (i % 5 == 0)
                {
                    pedidoEntregado = new PedidoEntregado(3, "helloWorld" + i + "@hotmail.com", "Barrio Mexico, San Jose, Costa Rica"+i, getOrdenDeCompra(i),
                DateTime.Now, getOrdenDeCompra(8).TotalCompra, getOrdenDeCompra(8).ProductosCantidad.Count);
                    usuario = new Usuario(i, "Usuario " + i, "psw_" + i, "correoUsuario_" + i + "@yahoo.com");
                    usuarios.Add(usuario);
                    carrito = new Carrito("carrito " + i, usuario, pedidoEntregado);
                    carritos.Add(carrito);
                }//Fin if
            }//Fin For

        }
        public List<Producto> llenaMockProductos(int cantidadProductos)
        {
            List<Producto> listaProductos = new List<Producto>();
            Producto producto;

            for (int i = 1; i < cantidadProductos; i++)
            {
                if (i % 2 == 0)
                {
                    producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11, "https://pictures.dealer.com/t/twowheelmotorsportguelphtc/0354/1447ce5c0fe8b9e07bb124be064018d2x.jpg?impolicy=resize&w=240");
                }
                else
                {
                    producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11, "https://www.ford.mx/content/dam/Ford/website-assets/latam/mx/nameplate/figo/2019/showroom/ford-figo-2019-auto-compacto-lateral-gris.png");
                }
                listaProductos.Add(producto);
                
            }
            return listaProductos;
        }
        public Object traeCarrito(string idCarrito)
        {
            foreach (Carrito carrito in carritos)
            {
                if (idCarrito.Equals(carrito.Id)) return carrito;
            }
            return false;
        }
        public bool actualizaCarrito(string idCarrito, Carrito carritoNuevo)
        {
            if (!carritoNuevo.Id.Equals(idCarrito)) carritoNuevo.Id = idCarrito;
            foreach (Carrito carrito in carritos)
            {
                if(carrito.Id == idCarrito)
                {
                    carritos.Remove(carrito);
                    carritos.Add(carritoNuevo);
                    return true;
                }
            }
            return false;
        }
        public void insertaCarrito(Carrito carritoNuevo)
        {
            carritos.Add(carritoNuevo);
        }
        public bool eliminaCarrito(string idCarrito)
        {
            foreach (Carrito carrito in carritos)
            {
                if (carrito.Id == idCarrito)
                {
                    carritos.Remove(carrito);
                    return true;
                }
            }
            return false;
        }
        public void guardaUsuario(Usuario usuarioAGuardar)
        {
            usuarios.Add(usuarioAGuardar);
        }
        public List<Carrito> traeListaCarritos()
        {
            return carritos;
        }

        public MockUpData()
        {
            llenaMockCarritos();
        }

    }
}
