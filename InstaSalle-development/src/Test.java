import Estructures_Auxiliars.LlegeixJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.Parametre;
import Sort.QuickSort;

import java.io.PipedOutputStream;
import java.util.ArrayList;

/**
 *Test del programa InstaSalle
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){

        LlegeixJSON llegeixJSON = new LlegeixJSON();
        QuickSort quickSort = new QuickSort();
        Usuari[] usuaris = llegeixJSON.readJSON("jsons/m_dataset.json");

        TaulaHash taulaHash = new TaulaHash(usuaris);

        ArrayList<Post> posts = taulaHash.extractPosts(taulaHash);
        Parametre parametre = new Parametre(posts);
        posts = quickSort.QuicksortI(parametre);

        for(int i = posts.size()-1 ; i > 0; i--){
            System.out.println(posts.get(i).getPublished());
        }


    }
}
