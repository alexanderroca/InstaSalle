package Sort;

import Estructures_Auxiliars.CriteriOrdenacio;
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
     * @return ArrayList<Post> : posts ordenat segons la seva data de publicacio
     */
    public ArrayList<Post> selectionSort(ArrayList<Post> array, double latitudO, double longitudO, int opcio,
                                         Hashtable<String, Usuari> hashtable, String username, Interessos interessos){

        CriteriOrdenacio combinacioPrioritats = null;
        if(opcio == 3){
            combinacioPrioritats = new CriteriOrdenacio();
        }   //if

        for(int i = 0; i < array.size(); i++){

            int index = i;
            for (int j = i + 1; j < array.size(); j++){

                if(opcio == 1) {
                    if (array.get(j).getPublished() > array.get(index).getPublished())
                        index = j;
                }   //if
                else{
                    if(opcio == 2){
                        if(Math.abs(array.get(j).calculaDistancia(latitudO, longitudO, array.get(j).getLocation()[0], array.get(j).getLocation()[1]))
                                < Math.abs(array.get(j).calculaDistancia(latitudO, longitudO, array.get(index).getLocation()[0], array.get(index).getLocation()[1])))
                            index = j;
                    }   //if
                    else{
                        if(opcio == 3){
                            if(combinacioPrioritats.criteriOrdenacio(array.get(i), hashtable.get(username), interessos) <
                                    combinacioPrioritats.criteriOrdenacio(array.get(j), hashtable.get(username), interessos))
                                index = j;
                        }   //if
                    }   //else
                }   //else

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

        return array;
    }

    /**
     *
     * @param hashtable
     * @param username
     * @param interessos
     * @param posts
     * @return
     */
    public ArrayList<Post> selectionSortUsuaris(Hashtable<String, Usuari> hashtable, String username, Interessos interessos,
        ArrayList<Post> posts){

        CriteriOrdenacio combinacioPrioritats = new CriteriOrdenacio();

        for(int i = 0; i < posts.size(); i++){

            int index = i;
            for (int j = i + 1; j < posts.size(); j++){

                if(combinacioPrioritats.criteriOrdenacio(posts.get(i), hashtable.get(username), interessos) <
                        combinacioPrioritats.criteriOrdenacio(posts.get(j), hashtable.get(username), interessos))
                    index = j;

                Post aux = posts.get(i);
                posts.set(i, posts.get(index));
                posts.set(index, aux);
            }   //for
        }   //for

        return posts;
    }
}
