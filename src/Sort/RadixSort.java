package Sort;

import Estructures_Auxiliars.CriteriOrdenacio;
import Estructures_Auxiliars.Interessos;
import GsonObjects.Post;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació RadixSort
 *
 * @author: Alexander Roca
 * @version  - 0.1
 */

public class RadixSort {

    /**
     * Funcio que realitza la ordenació pel mètode RadixSort
     * @param posts : ArrayList de Post
     * @param opcio : indica la funcionalitat indicada en el menú que indica les funcionalitats
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interessos : Objecte Interessos
     * @return ArrayList de Post ordenat
     */
    public ArrayList<Post> radixSort(ArrayList<Post> posts, int opcio, double latitudO, double longitudO,
                                     Hashtable<String, Usuari> hashtable, String username, Interessos interessos){

        CriteriOrdenacio combinacioPrioritats = null;
        if(opcio == 3){
            combinacioPrioritats = new CriteriOrdenacio();
        }   //if

        double max = getMax(posts, opcio, latitudO, longitudO, hashtable, username, interessos, combinacioPrioritats);

        for(double i = 1; max / i > 0; i *= 10){
            posts = sort(i, posts, opcio, latitudO, longitudO, hashtable, username, interessos,
                    combinacioPrioritats);
        }   //for

        return posts;
    }

    /**
     * Funcio que realitza el procés d'ordenacio pel mètode RadixSort
     * @param pes : indica la magnitud ha realitzar (unitats, desenes, centenes, etc.)
     * @param array : ArrayList de Post
     * @param opcio : indica la funcionalitat seleccionada en el menú de funcionalitats
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interessos : Objecte Interessos
     * @param combinacioPrioritats : Objecte CriteriOrdenacio en cas de realitzar la funcionalitat 3
     * @return ArrayList de Post
     */
    private ArrayList<Post> sort(double pes, ArrayList<Post> array, int opcio, double latitudO, double longitudO,
                                 Hashtable<String, Usuari> hashtable, String username, Interessos interessos,
                                 CriteriOrdenacio combinacioPrioritats){
        Post[] aux = new Post[array.size()];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for (Post anArray : array) {
            if (opcio == 1)
                count[(int) (anArray.getPublished() / pes % 10)]++;
            else {
                if (opcio == 2) {
                    count[(int) (Math.abs(anArray.calculaDistancia(latitudO, longitudO,
                            anArray.getLocation()[0], anArray.getLocation()[1])) / pes % 10)]++;
                }   //if
                else{
                    if(opcio == 3){
                        count[(int) (combinacioPrioritats.criteriOrdenacio(anArray,
                                hashtable.get(username), interessos) / pes % 10)]++;
                    }   //if
                }   //else
            }   //else
        }   //for

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }   //for

        for (int i = array.size() - 1; i >= 0; i--) {
            if(opcio == 1) {
                aux[count[(int) ((array.get(i).getPublished() / pes) % 10)] - 1] = array.get(i);
                count[(int) ((array.get(i).getPublished() / pes) % 10)]--;
            }   //if
            else{
                if(opcio == 2){
                    aux[count[(int) (Math.abs(array.get(i).calculaDistancia(latitudO, longitudO,
                            array.get(i).getLocation()[0], array.get(i).getLocation()[1]) / pes) % 10)] - 1] = array.get(i);
                    count[(int) (Math.abs(array.get(i).calculaDistancia(latitudO, longitudO,
                            array.get(i).getLocation()[0], array.get(i).getLocation()[1]) / pes) % 10)]--;
                }   //if
                else{
                    if(opcio == 3){
                        aux[count[(int) ((combinacioPrioritats.criteriOrdenacio(array.get(i),
                                hashtable.get(username), interessos) / pes) % 10)] - 1] = array.get(i);
                        count[(int) ((combinacioPrioritats.criteriOrdenacio(array.get(i),
                                hashtable.get(username), interessos) / pes) % 10)]--;
                    }   //if
                }   //else
            }   //else
        }   //for

        for(int i = 0; i < array.size(); i++){
            array.set(i, aux[i]);
        }   //for

        return array;
    }

    /**
     * Funcio que busca el màxim valor del ArrayList de Post
     * @param posts : ArrayList de Post
     * @param opcio : indica la funcionalitat seleccionada en el menú de funcionalitats
     * @param latitudO : latitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param longitudO : longitud que ha inserit l'usuari si s'ha seleccionat la funcionalitat 2
     * @param hashtable : Taula de Hash que conté els Usuaris, té com a key el nom d'Usuari
     * @param username : String que indica el nom d'usuari a buscar si s'ha seleccionat la funcionalitat 3
     * @param interessos : Objecte Interessos
     * @param combinacioPrioritats : Objecte CriteriOrdenacio en cas de realitzar la funcionalitat 3
     * @return double que indica el valor màxim
     */
    private double getMax(ArrayList<Post> posts, int opcio, double latitudO, double longitudO,
                          Hashtable<String, Usuari> hashtable, String username, Interessos interessos,
                          CriteriOrdenacio combinacioPrioritats){

        double max = 0;

        if(opcio == 1)
            max = posts.get(0).getPublished();
        else{
            if(opcio == 2){
                max = Math.abs(posts.get(0).calculaDistancia(latitudO, longitudO,
                        posts.get(0).getLocation()[0], posts.get(0).getLocation()[1]));
            }   //if
            else{
                if(opcio == 3){
                    max = combinacioPrioritats.criteriOrdenacio(posts.get(0), hashtable.get(username), interessos);
                }   //if
            }   //else
        }   //else

        for(int i = 1; i < posts.size() - 1; i++){
            if(opcio == 1) {
                if (max < posts.get(i).getPublished()) {
                    max = posts.get(i).getPublished();
                }   //if
            }   //if
            else{
                if(opcio == 2){
                    if(Math.abs(posts.get(i).calculaDistancia(latitudO, longitudO,
                            posts.get(i).getLocation()[0], posts.get(i).getLocation()[1])) > max)
                        max = Math.abs(posts.get(i).calculaDistancia(latitudO, longitudO,
                                posts.get(i).getLocation()[0], posts.get(i).getLocation()[1]));
                }   //if
                else{
                    if(opcio == 3){
                        if(combinacioPrioritats.criteriOrdenacio(posts.get(i), hashtable.get(username), interessos)
                            > max){
                            max = combinacioPrioritats.criteriOrdenacio(posts.get(i), hashtable.get(username), interessos);
                        }   //if
                    }   //if
                }   //else
            }   //else
        }   //for

        return max;
    }

}
