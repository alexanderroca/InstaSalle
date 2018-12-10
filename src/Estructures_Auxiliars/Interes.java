package Estructures_Auxiliars;

/**
 * Classe que defineix les categories que hi ha en el programa i quantifica els gustos d'un Usuari
 *
 * @author Alexander Roca
 * @version 14/12/2018 - 0.1
 */

public class Interes {
    private final String[] CATEGORIES = {"landscape", "food", "sports", "style", "animals", "tv_shows", "fitness", "science_tech",
            "music", "travel", "architecture"};
    private int[] num = new int[CATEGORIES.length];


    Interes() {

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
