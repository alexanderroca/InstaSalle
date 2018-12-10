package Sort;

import Estructures_Auxiliars.CriteriOrdenacio;
import Estructures_Auxiliars.Interes;
import GsonObjects.Post;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació SelectionSort
 *
 * @author Alexander Roca
 * @version  - 0.1
 */

public class SelectionSort {

    /**
     * Funció  que realitza la ordenació pel mètode SelectionSort
     * @param array : ArrayList de Post
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interes : Objecte Interes
     * @return ArrayList de Post orddenat
     */
    public ArrayList<Post> selectionSort(ArrayList<Post> array, double latitudO, double longitudO, int opcio,
                                         Hashtable<String, Usuari> hashtable, String username, Interes interes) {

        CriteriOrdenacio combinacioPrioritats = null;
        if (opcio == 3) {
            combinacioPrioritats = new CriteriOrdenacio();
        }   //if

        for (int i = 0; i < array.size(); i++) {

            int index = i;
            for (int j = i + 1; j < array.size(); j++) {

                if (opcio == 1) {
                    if (array.get(j).getPublished() > array.get(index).getPublished())
                        index = j;
                }   //if
                else {
                    if (opcio == 2) {
                        if (Math.abs(array.get(j).calculaDistancia(latitudO, longitudO, array.get(j).getLocation()[0], array.get(j).getLocation()[1]))
                                < Math.abs(array.get(index).calculaDistancia(latitudO, longitudO, array.get(index).getLocation()[0], array.get(index).getLocation()[1])))
                            index = j;
                    }   //if
                    else {
                        if (opcio == 3) {
                            if (combinacioPrioritats.criteriOrdenacio(array.get(j), hashtable.get(username), interes) <
                                    combinacioPrioritats.criteriOrdenacio(array.get(index), hashtable.get(username), interes))
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
}
