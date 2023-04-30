package pe.converde;

public class Artefacto {

    private String nom_artefacto;
    private int imagen;
    private String urlImagen;
    private double potencia;
    private String recomendacion;

    public Artefacto(String nom_artefacto, int imagen, double potencia, String recomendacion) {
        this.nom_artefacto = nom_artefacto;
        this.imagen = imagen;
        this.potencia = potencia;
        this.recomendacion = recomendacion;
    }

    public Artefacto(String nom_artefacto, String urlImagen, double potencia, String recomendacion) {
        this.nom_artefacto = nom_artefacto;
        this.urlImagen = urlImagen;
        this.potencia = potencia;
        this.recomendacion = recomendacion;
    }

    public String getNom_artefacto() {
        return nom_artefacto;
    }

    public void setNom_artefacto(String nom_artefacto) {
        this.nom_artefacto = nom_artefacto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}
