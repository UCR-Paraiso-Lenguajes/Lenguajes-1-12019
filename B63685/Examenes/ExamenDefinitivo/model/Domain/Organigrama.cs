using System;
using System.Collections.Generic;
using System.Text;

namespace model.Domain
{
    public class Organigrama
    {

        private string nombreOrganizacion;
        public string NombreOrganizacion
        {
            get
            {
                return nombreOrganizacion;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido.");
               
                if (string.IsNullOrWhiteSpace(value)) throw new Exception("No puede ingresar solo espacios");
                  nombreOrganizacion = value;
            }
        }

        private int idOrganigrama;
        public int IdOrganigrama
        {
            get
            {
                return idOrganigrama;
            }
            set
            {
                if (value <= 0) throw new Exception("El numero debe ser positivo");

                idOrganigrama = value;
            }
        }

        public Organigrama()
        {
           
                    }

        public Organigrama(int id, string nombre)
        {
            this.IdOrganigrama = id;
            this.NombreOrganizacion = nombre;
            
        }

       
        public void DepartamentosAgregar(Departamentos departamentos)
        {
            Departamentos.Add(departamentos);

        }

        public List<Departamentos> Departamentos
        {
            get
            {
                return Departamentos;
            }
            set
            {

            }
        }




    }


}
