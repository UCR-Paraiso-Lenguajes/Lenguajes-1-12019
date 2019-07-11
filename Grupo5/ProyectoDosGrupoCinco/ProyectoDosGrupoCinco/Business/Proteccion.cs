using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Business
{
    public static class Proteccion
    {
        /// Esta función encripta la contraseña
        public static string Encrypt(this string password)
        {
            string result = string.Empty;
            byte[] encryted = System.Text.Encoding.Unicode.GetBytes(password);
            result = Convert.ToBase64String(encryted);
            return result;
        }

        /// Esta función desencripta la contraseña
      /*  public static string Decrypt(this string password)
        {
            string result = string.Empty;
            byte[] decryted = Convert.FromBase64String(password);
            result = System.Text.Encoding.Unicode.GetString(decryted);
            return result;
        }*/

    }
}
