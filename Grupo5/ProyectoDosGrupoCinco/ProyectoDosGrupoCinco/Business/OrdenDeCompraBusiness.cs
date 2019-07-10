using MailKit.Net.Smtp;
using MimeKit;
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
            message.To.Add(new MailboxAddress("cliente",correoEnviar));
            message.Subject = "Resumen de compra";

            var bodyBuilder = new BodyBuilder();

        // bodyBuilder.HtmlBody = cuerpoMensaje+"<br>" + "<b> This is some html text</b>";
       
            string htmlFilePath = "C:/Users/alfonso/Documents/GitHub/Lenguajes-1-12019/Grupo5/ProyectoDosGrupoCinco/ProyectoDosGrupoCinco/msg.html";
            bodyBuilder.HtmlBody = File.ReadAllText(htmlFilePath);

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
