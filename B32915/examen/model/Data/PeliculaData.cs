using model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace model.Data
{
    public class PeliculaData
    {
        public List<Pelicula> listaPeliculas = new List<Pelicula>();

        public PeliculaData()
        {
            this.listaPeliculas = LlenarListaPeliculas();
        }

        public IEnumerable<Pelicula> ObtenerListaPeliculas()
        {
            return listaPeliculas;
        }

        public Pelicula ObtenerPeliculaPorId(int id)
        {
            Pelicula newPeli = null;
            bool encontrado = false;

            foreach (Pelicula peli in listaPeliculas)
            {

                if (peli.Id == id && encontrado == false)
                {
                    newPeli = peli;
                    encontrado = true;
                }
            }

            if (newPeli != null)
            {
                return newPeli;
            }
            else
            {
                throw new Exception("Pelicula no encontrada");
            }
        }

        public void InsertarPelicula(Pelicula pelicula)
        {
            this.listaPeliculas.Add(pelicula);
        }

        public void EditarPelicula(Pelicula pelicula, int id)
        {
            Pelicula borrarPeli = ObtenerPeliculaPorId(id);
            this.listaPeliculas.Remove(borrarPeli);
            this.listaPeliculas.Add(pelicula);
        }

        public void EliminarPelicula(int id)
        {
            Pelicula borrarPeli = ObtenerPeliculaPorId(id);
            if (borrarPeli != null)
            {
                this.listaPeliculas.Remove(borrarPeli);
            }
        }
        public List<Pelicula> LlenarListaPeliculas()
        {
            listaPeliculas.Add(new Pelicula(1, "Harry Potter 1", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(2, "Harry Potter 2", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(3, "Harry Potter 3", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(4, "Harry Potter 4", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(5, "Harry Potter 5", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(6, "Harry Potter 6", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(7, "Harry Potter 7 Parte 1", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(8, "Harry Potter 7 Parte 2", "https://vignette.wikia.nocookie.net/harrypotter/images/3/36/Harry-potter-films.png"));
            listaPeliculas.Add(new Pelicula(9, "El señor de los anillos 1", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(10, "El señor de los anillos 2", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(11, "El señor de los anillos 3", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(12, "El Hobbit 1", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(13, "El Hobbit 2", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(14, "El Hobbit 3", "https://vignette.wikia.nocookie.net/lotr/images/8/87/Ringstrilogyposter.jpg"));
            listaPeliculas.Add(new Pelicula(15, "Rapidos y Furiosos 1", "https://2.bp.blogspot.com/-ZyPN-CSyV10/W4Xfi8-8BhI/AAAAAAAAAB8/FNNl9riQLesnGx3pqQBjoojjldh72DlpQCLcBGAs/s320/rapidos-y-furioso-blu-ray-todas-las-8-peliculas-preventa-D_NQ_NP_881821-MPE26937845901_032018-F.jpg"));
            listaPeliculas.Add(new Pelicula(16, "Rapidos y Furiosos 2", "https://2.bp.blogspot.com/-ZyPN-CSyV10/W4Xfi8-8BhI/AAAAAAAAAB8/FNNl9riQLesnGx3pqQBjoojjldh72DlpQCLcBGAs/s320/rapidos-y-furioso-blu-ray-todas-las-8-peliculas-preventa-D_NQ_NP_881821-MPE26937845901_032018-F.jpg"));
            listaPeliculas.Add(new Pelicula(17, "Rapidos y Furiosos 3", "https://2.bp.blogspot.com/-ZyPN-CSyV10/W4Xfi8-8BhI/AAAAAAAAAB8/FNNl9riQLesnGx3pqQBjoojjldh72DlpQCLcBGAs/s320/rapidos-y-furioso-blu-ray-todas-las-8-peliculas-preventa-D_NQ_NP_881821-MPE26937845901_032018-F.jpg"));
            listaPeliculas.Add(new Pelicula(18, "Rapidos y Furiosos 4", "https://2.bp.blogspot.com/-ZyPN-CSyV10/W4Xfi8-8BhI/AAAAAAAAAB8/FNNl9riQLesnGx3pqQBjoojjldh72DlpQCLcBGAs/s320/rapidos-y-furioso-blu-ray-todas-las-8-peliculas-preventa-D_NQ_NP_881821-MPE26937845901_032018-F.jpg"));
            listaPeliculas.Add(new Pelicula(19, "Rapidos y Furiosos 5", "https://2.bp.blogspot.com/-ZyPN-CSyV10/W4Xfi8-8BhI/AAAAAAAAAB8/FNNl9riQLesnGx3pqQBjoojjldh72DlpQCLcBGAs/s320/rapidos-y-furioso-blu-ray-todas-las-8-peliculas-preventa-D_NQ_NP_881821-MPE26937845901_032018-F.jpg"));
            listaPeliculas.Add(new Pelicula(20, "La guerra de las galaxias ep 1", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(21, "La guerra de las galaxias ep 2", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(22, "La guerra de las galaxias ep 3", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(23, "La guerra de las galaxias ep 4", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(24, "La guerra de las galaxias ep 5", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(25, "La guerra de las galaxias ep 6", "https://mondrian.mashable.com/uploads%252Fstory%252Fthumbnail%252F75090%252F8500a9b7-b1a5-4645-a022-211cfbc9c670.jpg%252F950x534.jpg"));
            listaPeliculas.Add(new Pelicula(26, "El planeta de los Simios 1", "https://www.foxmovies.com/s3/dev-temp/en-US/__59da8eff36ecc-medium.jpg"));
            listaPeliculas.Add(new Pelicula(27, "El planeta de los Simios 2", "https://www.foxmovies.com/s3/dev-temp/en-US/__59da8eff36ecc-medium.jpg"));
            listaPeliculas.Add(new Pelicula(28, "El planeta de los Simios 3", "https://www.foxmovies.com/s3/dev-temp/en-US/__59da8eff36ecc-medium.jpg"));
            listaPeliculas.Add(new Pelicula(29, "Shrek 1", "http://beta.ems.ladbiblegroup.com/s3/content/57e81af75b0a7e94d92d3a61df3174af.png"));
            listaPeliculas.Add(new Pelicula(30, "Shrek 2", "http://beta.ems.ladbiblegroup.com/s3/content/57e81af75b0a7e94d92d3a61df3174af.png"));
            listaPeliculas.Add(new Pelicula(31, "Shrek 3", "http://beta.ems.ladbiblegroup.com/s3/content/57e81af75b0a7e94d92d3a61df3174af.png"));
            listaPeliculas.Add(new Pelicula(32, "Shrek 4", "http://beta.ems.ladbiblegroup.com/s3/content/57e81af75b0a7e94d92d3a61df3174af.png"));
            listaPeliculas.Add(new Pelicula(33, "El hombre araña 1", "https://www.space.ca/wp-content/uploads/2017/07/Sony2.jpg"));
            listaPeliculas.Add(new Pelicula(34, "El hombre araña 2", "https://www.space.ca/wp-content/uploads/2017/07/Sony2.jpg"));
            listaPeliculas.Add(new Pelicula(35, "El hombre araña 3", "https://www.space.ca/wp-content/uploads/2017/07/Sony2.jpg"));
            listaPeliculas.Add(new Pelicula(36, "Iron Man 1", "https://secure-media1.hotstarext.com/r1/thumbs/PCTV/38/1660000038/PCTV-1660000038-hcdl.jpg"));
            listaPeliculas.Add(new Pelicula(37, "Iron Man 2", "https://secure-media1.hotstarext.com/r1/thumbs/PCTV/38/1660000038/PCTV-1660000038-hcdl.jpg"));
            listaPeliculas.Add(new Pelicula(38, "Iron Man 3", "https://secure-media1.hotstarext.com/r1/thumbs/PCTV/38/1660000038/PCTV-1660000038-hcdl.jpg"));
            listaPeliculas.Add(new Pelicula(39, "Avengers 1", "https://specials-images.forbesimg.com/imageserve/5cc0c243a7ea436c70f3ba2f/960x0.jpg"));
            listaPeliculas.Add(new Pelicula(40, "Avengers 2", "https://specials-images.forbesimg.com/imageserve/5cc0c243a7ea436c70f3ba2f/960x0.jpg"));
            listaPeliculas.Add(new Pelicula(41, "Avengers 3", "https://specials-images.forbesimg.com/imageserve/5cc0c243a7ea436c70f3ba2f/960x0.jpg"));
            listaPeliculas.Add(new Pelicula(42, "Toy Story 1", "https://i.ebayimg.com/images/g/dY4AAOSwf4BcrMiZ/s-l640.png"));
            listaPeliculas.Add(new Pelicula(43, "Toy Story 2", "https://i.ebayimg.com/images/g/dY4AAOSwf4BcrMiZ/s-l640.png"));
            listaPeliculas.Add(new Pelicula(44, "Toy Story 3", "https://i.ebayimg.com/images/g/dY4AAOSwf4BcrMiZ/s-l640.png"));
            listaPeliculas.Add(new Pelicula(45, "Toy Story 4", "https://i.ebayimg.com/images/g/dY4AAOSwf4BcrMiZ/s-l640.png"));
            listaPeliculas.Add(new Pelicula(46, "SAW I", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(47, "SAW II", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(48, "SAW III", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(49, "SAW IV", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(50, "SAW V", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(51, "SAW VI", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(52, "SAW VII", "https://images-na.ssl-images-amazon.com/images/I/61f0lHlGADL._SX342_.jpg"));
            listaPeliculas.Add(new Pelicula(53, "Stark Trek I", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(54, "Stark Trek II", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(55, "Stark Trek III", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(56, "Stark Trek IV", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(57, "Stark Trek V", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(58, "Stark Trek VI", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(59, "Stark Trek VII", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));
            listaPeliculas.Add(new Pelicula(60, "Stark Trek VIII", "https://www.startvseriescast.com/wp-content/uploads/2018/08/New-Star-Trek-Movies-in-Order-star-trek-series-order-1.jpg"));     

            return listaPeliculas;
        }

     }
}
