package cr.ac.ucr.examenAmpli.domain;

public class Pelicula {

    private int id;
    private String nombre;
    private String genero;
    private String imagen;
    private String video;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Pelicula() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Pelicula(int id, String nombre, String genero, String imagen, String video, String description) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.imagen = imagen;
        this.video = video;
        this.description = description;
    }
}
