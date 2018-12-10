package Estructures_Auxiliars;

import GsonObjects.Post;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació MergeSort
 *
 * @author Alexander Roca
 * @version 27/11/2018 - 0.1
 */

public class TaulaHash {
    private Hashtable<String, Usuari> hashtable;

    public Hashtable<String, Usuari> getHashtable() {
        return hashtable;
    }

    /**
     *Constructor que migra les dades d'un ArrayList d'usuaris a una taula de hash
     *
     * @param usuaris: ArrayList d'usuaris
     */
    public TaulaHash(Usuari[] usuaris) {
        hashtable = new Hashtable<>();

        //hashtable = new Hashtable(usuaris.length);
        for (Usuari usuari : usuaris) {
            hashtable.put(usuari.getUsername(), usuari);
        }   //for

    }

    /**
     *Funcio que extreu tots els Post de la taula de hash
     * @param taulaHash : HashMap que conté tots els Usuaris
     * @return ArrayList de Post : conté tots els posts
     */
    public ArrayList<Post> extractPosts(TaulaHash taulaHash){
        ArrayList<Post> posts = new ArrayList<>();

        for(Usuari value : taulaHash.hashtable.values()){

            for(int j = 0; j < value.getPosts().size(); j++){
                posts.add(taulaHash.hashtable.get(value.getUsername()).getPosts().get(j));
            }   //for

        }   //for

        return posts;
    }

    /**
     * Funcio que extreu tots els Posts dels contactes de l'usuari
     * @param hashtable : HashTable que conté totes les dades
     * @param username : nom d'usuari
     * @return ArrayList de Post : tots els posts que ha intervingut l'usuari
     */
    public ArrayList<Post> extractPostsFromUser(Hashtable<String, Usuari> hashtable, String username) throws NullPointerException{
        ArrayList<Post> interestingPosts = new ArrayList<>();

        for (int i = 0; i < hashtable.get(username).getConnections().size(); i++) {

            String aux = hashtable.get(username).getConnections().get(i).getUsername();
            interestingPosts.addAll(hashtable.get(aux).getPosts());
        }   //for


        return interestingPosts;
    }

    /**
     * Funcio que contabilitza els interessos del usuari
     * @param hashtable : HashTable que conte totes les dades
     * @param username : nom d'usuari
     * @return Interes : objecte que indica la quantitat de tipus de posts que ha visitat
     */
    public Interes extractInteres(Hashtable<String, Usuari> hashtable, String username){
        Interes interes = new Interes();

        for(int i = 0; i < hashtable.get(username).getConnections().size(); i++){

            for(int j = 0;
                j < hashtable.get(hashtable.get(username).getConnections().get(i).getUsername()).getPosts().size();
                j++){

                for(int k = 0; k < interes.getCATEGORIES().length; k++){

                    if(hashtable.get(hashtable.get(username).getConnections()
                            .get(i).getUsername()).getPosts().get(j).getCategory().equals(interes.getCATEGORIES()[k])){

                        interes.setNum(interes.getNum()[k] + 1, k);
                    }   //if
                }   //for

            }   //for
        }   //for

        return interes;
    }

}
