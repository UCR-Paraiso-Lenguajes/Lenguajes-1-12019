using MailKit.Net.Smtp;
using MimeKit;
using MimeKit.Utils;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace ProyectoDosGrupoCinco.Business
{
    public class OrdenDeCompraBusiness
    {


        public void resumenCompra(string correoEnviar, string cuerpoMensaje)
        {


            var message = new MimeMessage();
            message.From.Add(new MailboxAddress("Resumen de compra", correoEnviar));
            message.To.Add(new MailboxAddress("cliente", correoEnviar));
            message.Subject = "Resumen de compra";

            var bodyBuilder = new BodyBuilder();
            var bodyBuilder2 = new BodyBuilder();


            var image = bodyBuilder.LinkedResources.Add(@"../ProyectoDosGrupoCinco/logoProyectoDos.png");
            image.ContentId = MimeUtils.GenerateMessageId();


            bodyBuilder.HtmlBody = string.Format(@"<div style=""{0}""><center><img src=""cid:{1}""></center></div> <br><div style =""{2}"" ><strong><h1>A continuación podrás ver el resumen de tú compra</h1></strong>{3}</div>", "background-color:cadetblue; width:900px;heigth:100px", image.ContentId, "color:#229954", cuerpoMensaje);



            message.Body = bodyBuilder.ToMessageBody();


            using (var client = new SmtpClient())

            {
                client.Connect("smtp.gmail.com", 587, false);
                client.Authenticate("chatproyectouno@gmail.com", "2019AEC.");
                client.Send(message);
                client.Disconnect(true);
            }
        }



      
    }
}
