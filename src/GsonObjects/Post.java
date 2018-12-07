package GsonObjects;

/**
 *Classe que defineix els camps d'un post que va realitzar un Usuari
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Post {
    public static final double RADI_TERRA = 6371;

    private int id;
    private long published;
    private double[] location;
    private String category;
    private String[] liked_by;
    private String[] commented_by;

    public int getId() {
        return id;
    }

    public long getPublished() {
        return published;
    }

    public double[] getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String[] getLiked_by() {
        return liked_by;
    }

    public String[] getCommented_by() {
        return commented_by;
    }

    /**
     * Funcio que realitza la formual de Haversine
     * @param latitudO : double que indica la latitude inicial
     * @param longitudO : double que indica la longitud inicial
     * @param latitudF : double que indica la latitud final
     * @param longitudF : double que indica la longitud final
     * @return double que indica la distancia
     */
    public double calculaDistancia(double latitudO, double longitudO, double latitudF, double longitudF){
        double dLatitud = Math.toRadians(latitudF - latitudO);
        double dLongitud = Math.toRadians(longitudF - longitudO);

        latitudO = Math.toRadians(latitudO);
        latitudF = Math.toRadians(latitudF);

        double var1 = Math.pow(Math.sin(dLatitud / 2), 2) + Math.pow(Math.sin(dLongitud / 2), 2) *
                Math.cos(latitudO) * Math.cos(latitudF);
        double var2 = 2 * Math.asin(Math.sqrt(var1));

        return RADI_TERRA * var2;    //distancia
    }

    public int calculaLikesPost(Post post){
        int likes = 0;

        for(int i = 0; i < post.getLiked_by().length; i++){
            likes++;
        }   //for

        return likes;
    }
}
