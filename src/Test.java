import Estructures_Auxiliars.Interessos;
import Estructures_Auxiliars.LlegeixJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.SelectionSort;

import java.util.ArrayList;
import java.util.Date;

/**
 *Test del programa InstaSalle
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){

        LlegeixJSON llegeixJSON = new LlegeixJSON();
        Usuari[] usuaris = llegeixJSON.readJSON("jsons/m_dataset.json");

        TaulaHash taulaHash = new TaulaHash(usuaris);


            ArrayList<Post> posts = taulaHash.extractPostsFromUser(taulaHash.getHashtable(), "user0");
            Interessos interessos = taulaHash.extractInteressos(taulaHash.getHashtable(), "user0");

            SelectionSort selectionSort = new SelectionSort();
            posts = selectionSort.selectionSortUsuaris(taulaHash.getHashtable(), "user0", interessos, posts);
            System.out.println("Fi");
    }
}
