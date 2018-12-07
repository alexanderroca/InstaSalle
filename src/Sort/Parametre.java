package Sort;

/**
 *Classe auxiliar que defineix els camps necessaris per efectuar el mètode d'ordenació Quicksort
 *
 * @author: Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Parametre {
    private int[] a;
    private int i;
    private int j;

    public Parametre(int[] a) {
        this.a = a;
        i = 0;
        j = a.length - 1;
    }

    public int[] getA() {
        return a;
    }

    public int getAPos(int pos){
        return a[pos];
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void setI(int s) {
        this.i = i;
    }

    public void setJ(int t) {
        this.j = j;
    }

    public void setAPos(int pos, int num){
        this.a[pos] = num;
    }
}
