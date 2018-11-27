package Sort;

public class Parametre {
    private int[] a;
    private int i;
    private int j;

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
