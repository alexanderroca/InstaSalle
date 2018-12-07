package Sort;

import GsonObjects.Post;
import java.util.ArrayList;
/**
 *Classe auxiliar que defineix els camps necessaris per efectuar el mètode d'ordenació Quicksort
 *
 * @author: Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Parametre {
    private ArrayList<Post> a;
    private int i;
    private int j;

    public Parametre(ArrayList<Post> a) {
        this.a = a;
        i = 0;
        j = a.size() - 1;
    }

    public ArrayList<Post> getA() {
        return a;
    }

    public long getAPos(int pos){
        return a.get(pos).getPublished();
    }

    public Post getAPosPOST(int pos){
        return a.get(pos);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setA(ArrayList<Post> a) {
        this.a = a;
    }

    public void setI(int s) {
        this.i = s;
    }

    public void setJ(int t) {
        this.j = t;
    }

    public void setAPos(int pos, Post num){
        this.a.set(pos, num);
    }
}
