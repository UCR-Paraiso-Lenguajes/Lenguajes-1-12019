using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Business
{
    public class MockUpBusiness
    {
        private MockUpData mockUpData;

        public MockUpBusiness()
        {
            mockUpData = new MockUpData();
        }
        /*
         public Object traeCarrito(string idCarrito)
         public bool actualizaCarrito(string idCarrito, Carrito carritoNuevo)
         public void insertaCarrito(Carrito carritoNuevo)
         public bool eliminaCarrito(string idCarrito)
         public void guardaUsuario(Usuario usuarioAGuardar)
         public List<Carrito> traeListaCarritos()
         */
        public Object traeCarrito(string idCarrito)
        {
            return mockUpData.traeCarrito(idCarrito);
        }
        public bool actualizaCarrito(string idCarrito, Carrito carritoNuevo)
        {
            return mockUpData.actualizaCarrito(idCarrito, carritoNuevo);
        }
        public void insertaCarrito(Carrito carritoNuevo)
        {
            mockUpData.insertaCarrito(carritoNuevo);
        }
        public bool eliminaCarrito(string idCarrito)
        {
            return mockUpData.eliminaCarrito(idCarrito);
        }
        public void guardaUsuario(Usuario usuarioAGuardar)
        {
            mockUpData.guardaUsuario(usuarioAGuardar);
        }
        public List<Carrito> traeListaCarritos()
        {
            return mockUpData.traeListaCarritos();
        }
    }
}
