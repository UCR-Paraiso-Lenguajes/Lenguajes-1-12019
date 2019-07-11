using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Business
{
    public class PedidoBusiness
    {
        PedidosData pedidosData = new PedidosData();
        public List<PedidoPendiente> CargarPedidos(int indice)//que tengan cantidad
        {

            List<PedidoPendiente> pedidoPendientes = pedidosData.ListPedidoPendiente();
            List<PedidoPendiente> pedidoPendientesTemp = new List<PedidoPendiente>();

            int empezar = 0;
            int terminar = indice * 50;

            if (indice == 0)
            {
                terminar = 50;
            }

            for (int i = 0; i < indice; i++)
            {

                empezar += 50 * i;
            }
            if (empezar != 0)
            {
                empezar += 1;
            }
            for (int i = empezar; i <= terminar; i++)
            {

                if (i >= pedidoPendientes.Count)
                {

                    break;

                }
                else
                {
                    pedidoPendientesTemp.Add(pedidoPendientes[i]);
                }




            }

            pedidoPendientes = pedidoPendientesTemp;

            return pedidoPendientes;
        }
    }
}
