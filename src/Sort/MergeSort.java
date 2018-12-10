package Sort;

import Estructures_Auxiliars.CriteriOrdenacio;
import GsonObjects.Post;
import Estructures_Auxiliars.Interes;
import GsonObjects.Usuari;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació MergeSort
 *
 * @author Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class MergeSort {

    /**
     * Funció que realitza la partició de l'array i crida a la funció per ordenar-lo.
     * @param a Array de Post
     * @param i : valor mínim de l'array
     * @param j : valor màx de l'array
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interes : Objecte Interessos
     * @return ArrayList de Post ordenat
     */
    public ArrayList<Post> ordenaMergeI(ArrayList<Post> a, int i, int j, double latitudO, double longitudO, int opcio,
                                        Hashtable<String, Usuari> hashtable, String username, Interes interes){
        int mig;

        if(i>=j)
            return a;

        if(i<j){
            mig = (i+j)/2;
            a = ordenaMergeI(a, i, mig, latitudO, longitudO, opcio, hashtable, username, interes);
            a = ordenaMergeI(a, mig+1,j, latitudO, longitudO, opcio, hashtable, username, interes);
            a = merge(a, i, mig, j, latitudO, longitudO, opcio, hashtable, username, interes);
        }
        return a;
    }

    /**
     * Funció que realitza la ordenació pel mètode MergeSort
     * @param a ArrayList de Post
     * @param i Valor mínim de l'array
     * @param mig Valor mig de l'array
     * @param j Valor màxim de l'array
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interes : Objecte Interessos
     * @return ArrayList de Post ordenat
     */
    public ArrayList<Post> merge(ArrayList<Post> a, int i, int mig, int j, double latitudO, double longitudO, int opcio,
                                 Hashtable<String, Usuari> hashtable, String username, Interes interes){
        ArrayList<Post> b = new ArrayList<>();
        int k1 = i, k2 = mig + 1, cursor = 0, kr;

        CriteriOrdenacio combinacioPrioritats = null;
        if (opcio == 3) {
            combinacioPrioritats = new CriteriOrdenacio();
        }

        while (k1 <= mig && k2 <= j){
            if(opcio == 1){
                if(a.get(k1).getPublished() <= a.get(k2).getPublished()){
                    b.add(a.get(k1));
                    k1++;
                    cursor++;
                }

                if(a.get(k1).getPublished() > a.get(k2).getPublished()){
                    b.add(a.get(k2));
                    k2++;
                    cursor++;
                }
            }else {
                if (opcio == 2) {
                    if ((Math.abs(a.get(k1).calculaDistancia(latitudO, longitudO, a.get(k1).getLocation()[0], a.get(k1).getLocation()[1]))) <= (Math.abs(a.get(k2).calculaDistancia(latitudO, longitudO, a.get(k2).getLocation()[0], a.get(k2).getLocation()[1])))) {
                        b.add(a.get(k1));
                        k1++;
                        cursor++;
                    }

                    if ((Math.abs(a.get(k1).calculaDistancia(latitudO, longitudO, a.get(k1).getLocation()[0], a.get(k1).getLocation()[1]))) > (Math.abs(a.get(k2).calculaDistancia(latitudO, longitudO, a.get(k2).getLocation()[0], a.get(k2).getLocation()[1])))) {
                        b.add(a.get(k2));
                        k2++;
                        cursor++;
                    }
                } else {
                    if (opcio == 3) {
                        if((combinacioPrioritats.criteriOrdenacio(a.get(k1), hashtable.get(username), interes)) <=
                                (combinacioPrioritats.criteriOrdenacio(a.get(k2), hashtable.get(username), interes))){
                            b.add(a.get(k1));
                            k1++;
                            cursor++;
                        }

                        if((combinacioPrioritats.criteriOrdenacio(a.get(k1), hashtable.get(username), interes)) >
                                (combinacioPrioritats.criteriOrdenacio(a.get(k2), hashtable.get(username), interes))){
                            b.add(a.get(k2));
                            k2++;
                            cursor++;
                        }
                    }
                }
            }
        }

        while(k1 <= mig){
            b.add(a.get(k1));
            k1++;
            cursor++;
        }

        while(k2 <= j){
            b.add(a.get(k2));
            k2++;
            cursor++;
        }

        cursor = 0;
        kr = i;

        while(kr <= j){
            a.set(kr, b.get(cursor));
            kr++;
            cursor++;
        }
        return a;
    }

}