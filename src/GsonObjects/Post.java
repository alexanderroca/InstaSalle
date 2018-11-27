package GsonObjects;

/**
 *Classe que defineix els camps d'un post que va realitzar un Usuari
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Post {
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
}
