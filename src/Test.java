import Estructures_Auxiliars.Interes;
import Estructures_Auxiliars.TracteJSON;
import Estructures_Auxiliars.TaulaHash;
import GsonObjects.Post;
import GsonObjects.Usuari;
import Sort.MergeSort;
import Sort.Parametre;
import Sort.QuickSort;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *Test del programa InstaSalle
 *
 * @author Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){

        TracteJSON tracteJSON = new TracteJSON();
        Usuari[] usuaris = tracteJSON.readJSON("jsons/m_dataset.json");

        TaulaHash taulaHash = new TaulaHash(usuaris);
        Interes interes = taulaHash.extractInteres(taulaHash.getHashtable(), "user0");

        ArrayList<Post> posts = taulaHash.extractPosts(taulaHash);

        //RadixSort radixSort = new RadixSort();

        //SelectionSort selectionSort = new SelectionSort();

        //MergeSort mergeSort = new MergeSort();

        Timestamp tmp = new Timestamp(posts.get(0).getPublished());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicial= null;
        try {
            fechaInicial = dateFormat.parse(tmp.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date fechaFinal= null;
        try {
            fechaFinal = dateFormat.parse("2016-03-22");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);

        System.out.println(dias);

        /*Parametre parametre = new Parametre(posts);
        QuickSort quickSort = new QuickSort();

        posts = quickSort.QuicksortI(parametre, 0, 0,3, taulaHash.getHashtable(), "user0",
                interes);

        for(int i = 0; i < posts.size(); i++){
            System.out.println(posts.get(i).getVincle());
        }*/

    }
}
