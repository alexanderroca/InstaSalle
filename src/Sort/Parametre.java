package Sort;

import GsonObjects.Post;
import javafx.geometry.Pos;

import java.util.ArrayList;

/**
 *Classe auxiliar que defineix els camps necessaris per efectuar el mètode d'ordenació Quicksort
 *
 * @author Marc Cespedes
 * @version 15/11/2018 - 0.1
 */


public class Parametre {
    private ArrayList<Post> posts;
    private int i;
    private int j;

    /**
     * Constructor que assgina l'array de post que rep i marca inici i final de l'array
     * @param posts ArrayList de Post
     */
    public Parametre(ArrayList<Post> posts) {
        this.posts = posts;
        i = 0;
        j = posts.size() - 1;
    }

    public ArrayList<Post> getA() {
        return posts;
    }

    public Post getAPos(int pos){
        return posts.get(pos);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setA(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setI(int s) {
        this.i = s;
    }

    public void setJ(int t) {
        this.j = t;
    }

    public void setAPos(int pos, Post post){
        this.posts.set(pos, post);
    }
}
