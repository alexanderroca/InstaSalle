import Estructures_Auxiliars.Interessos;
import Estructures_Auxiliars.LlegeixJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.RadixSort;
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
        Interessos interessos = taulaHash.extractInteressos(taulaHash.getHashtable(), "user0");

        ArrayList<Post> posts = taulaHash.extractPosts(taulaHash);

        RadixSort radixSort = new RadixSort();
        posts = radixSort.radixSort(posts, 3, 0, 0,
                taulaHash.getHashtable(), "user0", interessos);

        for(int i = 0; i < posts.size(); i++){
            System.out.println(posts.get(i).getVincle());
        }

        System.out.println("Fi");
    }
}
