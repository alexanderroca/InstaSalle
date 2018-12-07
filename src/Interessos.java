public class Interessos {
    private String[] category;
    private int[] num;


    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int num, int pos) {
        this.num[pos] = num;
    }
}
