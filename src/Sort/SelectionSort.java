package Sort;

import Estructures_Auxiliars.Interessos;
import GsonObjects.Post;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació SelectionSort
 *
 * @author: Alexander Roca
 * @version  - 0.1
 */

public class SelectionSort {

    /**
     * Funcio que ordena els posts segons la seva data de publicacio
     * @param array : array de Post
     * @return array de Post ordenat segons la seva data de publicacio
     */
    public ArrayList<Post> selectionSortPosts(ArrayList<Post> array){
        for(int i = 0; i < array.size(); i++){

            int index = i;
            for (int j = i + 1; j < array.size(); j++){

                if(array.get(j).getPublished() > array.get(index).getPublished())
                    index = j;

                Post aux = array.get(i);
                array.set(i, array.get(index));
                array.set(index, aux);
            }   //for
        }   //for

        return array;
    }

    /**
     *
     * @param array
     * @param latitudO
     * @param longitudO
     * @return
     */
    public ArrayList<Post> selectionSortProximity(ArrayList<Post> array, double latitudO, double longitudO){
        for(int i = 0; i < array.size() - 1; i++){

            int index = i;
            for (int j = i + 1; j < array.size(); j++){

                if(Math.abs(array.get(j).calculaDistancia(latitudO, longitudO, array.get(j).getLocation()[0], array.get(j).getLocation()[1]))
                        < Math.abs(array.get(j).calculaDistancia(latitudO, longitudO, array.get(index).getLocation()[0], array.get(index).getLocation()[1])))
                    index = j;

                Post aux = array.get(i);
                array.set(i, array.get(index));
                array.set(index, aux);
            }   //for
        }   //for

        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i).getCategory());
        }   //for

        return array;
    }

    public ArrayList<Post> selectionSortUsuaris(Hashtable<String, Usuari> hashtable, String username, Interessos interessos){
        ArrayList<Post> array = new ArrayList<>();

        for(int i = 0; i < array.size(); i++){

            int index = i;
            for (int j = i + 1; j < array.size(); j++){

          //      if()
                    index = j;

                Post aux = array.get(i);
                array.set(i, array.get(index));
                array.set(index, aux);
            }   //for
        }   //for

        return array;
    }
}
