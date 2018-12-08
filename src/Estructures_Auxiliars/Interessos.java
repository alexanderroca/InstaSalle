package Estructures_Auxiliars;

public class Interessos {
    private final String[] CATEGORIES = {"landscape", "food", "sports", "style", "animals", "tv_shows", "fitness", "science_tech",
            "music", "travel", "architecture"};
    private int[] num = new int[CATEGORIES.length];


    Interessos() {

        for(int i = 0; i < CATEGORIES.length; i++){
            num[i] = 0;
        }   //for
    }

    String[] getCATEGORIES() {
        return CATEGORIES;
    }

    int[] getNum() {
        return num;
    }

    void setNum(int num, int pos) {
        this.num[pos] = num;
    }
}
