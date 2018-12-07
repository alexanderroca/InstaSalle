package Estructures_Auxiliars;

public class Interessos {
    private final String[] CATEGORIES = {"landscape", "food", "sports", "style", "animals", "tv_shows", "fitness", "science_tech",
            "music", "travel", "architecture"};
    private int[] num = new int[CATEGORIES.length];


    public Interessos() {

        for(int i = 0; i < CATEGORIES.length; i++){
            num[i] = 0;
        }   //for
    }

    public String[] getCATEGORIES() {
        return CATEGORIES;
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int num, int pos) {
        this.num[pos] = num;
    }
}
