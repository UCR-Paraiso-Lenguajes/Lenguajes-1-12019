using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Business
{
    public class UsuarioBusiness
    {

        UsuarioData usuarioData = new UsuarioData();



        public Usuario BuscarPorId(int id)
        {
          return usuarioData.UsuarioPorId(id);
        }


        public void Activar(int id)
        {
            usuarioData.activarUsuario(id);
        }

        public void InsertarUsuario(Usuario usuario)
        {
            usuarioData.InsertarUsuario(usuario);
        }

        public List<Usuario> GetAllUsuarios()
        {
            return usuarioData.GetAllUsuarios();
        }
    }

}
