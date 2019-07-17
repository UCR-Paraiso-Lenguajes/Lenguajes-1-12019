using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen3B56860.Pages
{
    public class MockPeliculas
    {



        public IEnumerable<Pelicula> GetAllPeliculas()
        {
            List<Pelicula> pelis = new List<Pelicula>();

            //bloque 1
            pelis.Add(new Pelicula(1, "https://www.bases123.com.ar/posters/9144_poster2.jpg", "Avengers Endgame"));
            pelis.Add(new Pelicula(2, "https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/justice_league_whv_keyart.jpg", "Justice League"));
            pelis.Add(new Pelicula(3, "https://i.pinimg.com/originals/6e/b6/40/6eb64092f099271697e3af60149d4c48.jpg", "Tenacious D"));
            pelis.Add(new Pelicula(4, "https://upload.wikimedia.org/wikipedia/en/thumb/3/31/The_SpongeBob_SquarePants_Movie_poster.jpg/220px-The_SpongeBob_SquarePants_Movie_poster.jpg", "SpongeBob Movie"));
            pelis.Add(new Pelicula(5, "https://upload.wikimedia.org/wikipedia/en/4/4d/Avengers_Infinity_War_poster.jpg", "Avengers Infinity War"));
            pelis.Add(new Pelicula(6, "https://www.outrightgeekery.com/wp-content/uploads/2019/01/DBZ-Broly-Logo.jpeg", "Dragon Ball Z Broly"));

            //bloque 2
            pelis.Add(new Pelicula(7, "https://musicart.xboxlive.com/7/d7911c00-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080", "Naruto The Last"));
            pelis.Add(new Pelicula(8, "https://upload.wikimedia.org/wikipedia/en/c/c7/Doctor_Strange_poster.jpg", "Dr Strange"));
            pelis.Add(new Pelicula(9, "https://m.media-amazon.com/images/M/MV5BYTlkYmM2NjAtMDkyZi00M2JiLThjZmItMjUzZDhiMDg2NGJmXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg", "Marley and me"));
            pelis.Add(new Pelicula(10, "https://wallpapercave.com/wp/AilPH4q.jpg", "Star Wars Episode 1"));
            pelis.Add(new Pelicula(11, "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/6494472f-fec7-438d-b6fb-5c5122ed065e/d9jkoci-0f4b7040-7769-4b75-b547-8437d2db559b.png/v1/fill/w_1131,h_707,q_70,strp/star_wars_2_wallpaper_by_ejlightning007arts_d9jkoci-pre.jpg", "Star Wars Episode 2"));
            pelis.Add(new Pelicula(12, "https://wallpapercave.com/wp/wp3054761.jpg", "Star Wars Episode 3"));

            //bloque 3
            pelis.Add(new Pelicula(13, "https://images-na.ssl-images-amazon.com/images/I/51YP9uqBcML.jpg", "Pirates of the caribbean the curse of the black pearl "));
            pelis.Add(new Pelicula(14, "https://i.pinimg.com/originals/d6/bf/fb/d6bffb52ac5519c46cd95c3e083e829d.jpg", "Pirates of the caribbean Dead man's chest"));
            pelis.Add(new Pelicula(15, "https://i.pinimg.com/originals/5e/83/42/5e8342d2cfa8e8fb21e3f36529e8d490.jpg", "Pirates of the caribbean At world's end"));
            pelis.Add(new Pelicula(16, "https://m.media-amazon.com/images/M/MV5BMjE5MjkwODI3Nl5BMl5BanBnXkFtZTcwNjcwMDk4NA@@._V1_.jpg", "Pirates of the caribbean On stranger tides"));
            pelis.Add(new Pelicula(17, "https://i.pinimg.com/originals/8c/b8/65/8cb8655b160a889478c6be0d22e03ef4.jpg", "Pirates of the caribbean Dead men tell no tales"));
            pelis.Add(new Pelicula(18, "https://images-na.ssl-images-amazon.com/images/I/51feXTBzenL.jpg", "Star Wars A New Hope"));


            //bloque 4
            pelis.Add(new Pelicula(19, "https://images-na.ssl-images-amazon.com/images/I/91qmrdkBViL._SY550_.jpg", "Deadpool"));
            pelis.Add(new Pelicula(20, "https://images-na.ssl-images-amazon.com/images/I/91KnqW%2BHkEL._SY679_.jpg", "Deadpool 2"));
            pelis.Add(new Pelicula(21, "https://i.ebayimg.com/images/g/qfoAAOSwhE9bhI4N/s-l300.jpg", "X-Men Origins Wolverine"));
            pelis.Add(new Pelicula(22, "https://m.media-amazon.com/images/M/MV5BNzg1MDQxMTQ2OF5BMl5BanBnXkFtZTcwMTk3MjAzOQ@@._V1_.jpg", "Wolverine Inmortal"));
            pelis.Add(new Pelicula(23, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCyCPATaxs93hVjvZGJBv5HFMrLwkXlmFJ6-MlZsCHiPY59Axy", "Logan"));
            pelis.Add(new Pelicula(24, "https://images-na.ssl-images-amazon.com/images/I/71W0PHrQpEL._SY606_.jpg", "Captain America The First Avenger"));


            //bloque 5
            pelis.Add(new Pelicula(25, "https://images-na.ssl-images-amazon.com/images/I/91OxromzoSL._SY445_.jpg", "Captain America The Winter Soldier"));
            pelis.Add(new Pelicula(26, "https://images-na.ssl-images-amazon.com/images/I/71VwAGJmXrL._SY606_.jpg", "Captain America Civil War"));
            pelis.Add(new Pelicula(27, "https://images-na.ssl-images-amazon.com/images/I/51PFQg5Or2L._SL500_AC_SS350_.jpg", "Captain Marvel"));
            pelis.Add(new Pelicula(28, "https://images-na.ssl-images-amazon.com/images/I/51zQB3DjpdL.jpg", "Black Panther"));
            pelis.Add(new Pelicula(29, "https://images-na.ssl-images-amazon.com/images/I/710bfuwiwiL._SY606_.jpg", "Iron Man"));
            pelis.Add(new Pelicula(30, "https://images-na.ssl-images-amazon.com/images/I/71VZVXPhmKL._SL1106_.jpg", "Iron Man 2"));


            //bloque 6
            pelis.Add(new Pelicula(31, "https://images-na.ssl-images-amazon.com/images/I/51WoeTa7ZHL.jpg", "Iron Man 3"));
            pelis.Add(new Pelicula(32, "https://images-na.ssl-images-amazon.com/images/I/61TUX3ObSLL.jpg", "The amazing Spiderman"));
            pelis.Add(new Pelicula(33, "https://images-na.ssl-images-amazon.com/images/I/71TzlB8GmXL._SY679_.jpg", "Spiderman Homecoming"));
            pelis.Add(new Pelicula(34, "https://d13ezvd6yrslxm.cloudfront.net/wp/wp-content/images/spider-man-far-from-home-posters-2.jpeg", "Spiderman Far From Home"));
            pelis.Add(new Pelicula(35, "https://m.media-amazon.com/images/M/MV5BMzY2ODk4NmUtOTVmNi00ZTdkLTlmOWYtMmE2OWVhNTU2OTVkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", "Spiderman 2"));
            pelis.Add(new Pelicula(36, "https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg", "Spiderman 3"));

            //bloque 7
            pelis.Add(new Pelicula(37, "https://images-na.ssl-images-amazon.com/images/I/418zjk8EnnL.jpg", "Spiderman"));
            pelis.Add(new Pelicula(38, "https://images-na.ssl-images-amazon.com/images/I/614rium%2BzxL._SY606_.jpg", "Annabelle"));
            pelis.Add(new Pelicula(39, "https://m.media-amazon.com/images/M/MV5BMjA1MzIwMjMxNF5BMl5BanBnXkFtZTgwMDQ3NTc2MjI@._V1_.jpg", "Annabelle Creation"));
            pelis.Add(new Pelicula(40, "https://m.media-amazon.com/images/M/MV5BYmI4NDNiMmQtZTFkYi00ZDVmLThlYTAtMWJlMjU1M2I2ZmViXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UX182_CR0,0,182,268_AL_.jpg", "Annabelle Comes Home"));
            pelis.Add(new Pelicula(41, "https://images-na.ssl-images-amazon.com/images/I/81NwnEjW27L._SY679_.jpg", "The conjuring"));
            pelis.Add(new Pelicula(42, "https://m.media-amazon.com/images/M/MV5BZjU5OWVlN2EtODNlYy00MjhhLWI0MDUtMTA3MmQ5MGMwYTZmXkEyXkFqcGdeQXVyNjE5MTM4MzY@._V1_.jpg", "The conjuring 2"));

            //bloque 8
            pelis.Add(new Pelicula(43, "https://i.pinimg.com/originals/df/91/bd/df91bd907022853ebca305e1627cdf7e.jpg", "The conjuring 3"));
            pelis.Add(new Pelicula(44, "https://m.media-amazon.com/images/M/MV5BMjM3NzQ5NDcxOF5BMl5BanBnXkFtZTgwNzM4MTQ5NTM@._V1_.jpg", "The Nun"));
            pelis.Add(new Pelicula(45, "https://images-na.ssl-images-amazon.com/images/I/51K8r9COEQL.jpg", "Toy Story"));
            pelis.Add(new Pelicula(46, "https://images-na.ssl-images-amazon.com/images/I/41FL4nHfPOL.jpg", "Toy Story 2"));
            pelis.Add(new Pelicula(47, "https://images-na.ssl-images-amazon.com/images/I/519fFTj6QnL.jpg", "Toy Story 3"));
            pelis.Add(new Pelicula(48, "https://m.media-amazon.com/images/M/MV5BMTYzMDM4NzkxOV5BMl5BanBnXkFtZTgwNzM1Mzg2NzM@._V1_.jpg", "Toy Story 4"));

            //bloque 9
            pelis.Add(new Pelicula(49, "https://i5.walmartimages.com/asr/14b6c953-c4b4-4c55-b61b-f094e345b75b_1.ec0270981480f4dadcfe16ad3ae8515c.jpeg?odnHeight=450&odnWidth=450&odnBg=FFFFFF", "The lion king"));
            pelis.Add(new Pelicula(50, "https://images-na.ssl-images-amazon.com/images/I/51T5sJngQLL.jpg", "Guardians Of The Galaxy"));
            pelis.Add(new Pelicula(51, "https://images-na.ssl-images-amazon.com/images/I/A11Agdd1EQL._SY679_.jpg", "Guardians Of The Galaxy vol 2"));
            pelis.Add(new Pelicula(52, "https://images-na.ssl-images-amazon.com/images/I/715Ev79hKEL._SY679_.jpg", "Jurassic World"));
            pelis.Add(new Pelicula(53, "https://images-na.ssl-images-amazon.com/images/I/81FZFvGhSVL._SY679_.jpg", "coco"));
            pelis.Add(new Pelicula(54, "https://upload.wikimedia.org/wikipedia/en/thumb/8/85/ManofSteelFinalPoster.jpg/220px-ManofSteelFinalPoster.jpg", "Man Of Steel"));

            //bloque 10
            pelis.Add(new Pelicula(55, "https://images-na.ssl-images-amazon.com/images/I/91N-BVleKnL._SY606_.jpg", "Batman vs Superman"));
            pelis.Add(new Pelicula(56, "https://images-na.ssl-images-amazon.com/images/I/618Gl3XfcdL.jpg", "Suicide Squad"));
            pelis.Add(new Pelicula(57, "https://m.media-amazon.com/images/M/MV5BMTU5Njg4NzUwM15BMl5BanBnXkFtZTgwMDcyMDU0MjE@._V1_UY268_CR12,0,182,268_AL_.jpg", "Cristiano Ronaldo the world at his feet"));
            pelis.Add(new Pelicula(58, "https://images-na.ssl-images-amazon.com/images/I/71kod5t-q9L._SY679_.jpg", "The Incredibles")); ;
            pelis.Add(new Pelicula(59, "https://d2e111jq13me73.cloudfront.net/sites/default/files/styles/product_image_aspect_switcher_170w/public/product-images/csm-movie/incredibles-2-poster0.jpg?itok=LivdDu4Y", "The incredibles 2"));
            pelis.Add(new Pelicula(60, "https://images-na.ssl-images-amazon.com/images/I/71xvPKq5FgL._SY450_.jpg", "Bohemian Rhapsody"));


            return pelis;
        }


    }
}