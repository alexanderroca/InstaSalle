import GsonObjects.Post;
import GsonObjects.Usuari;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *Classe que defineix el mètode d'ordenació MergeSort
 *
 * @author: Alexander Roca
 * @version 27/11/2018 - 0.1
 */

public class TaulaHash {
    private Hashtable<String, Usuari> hashtable;

    /**
     *Constructor que migra les dades d'un ArrayList d'usuaris a una taula de hash
     *
     * @param usuaris: ArrayList d'usuaris
     * @return taula de hash on la KEY serà el nom del usuari(String) i el VALUE serà Usuari
     */
    public TaulaHash(Usuari[] usuaris) {
        hashtable = new Hashtable<>();

        //hashtable = new Hashtable(usuaris.length);
        for(int i = 0; i < usuaris.length; i++){
            hashtable.put(usuaris[i].getUsername(), usuaris[i]);
        }   //for

        System.out.println("Informació inserida a una Taula de Hash");
    }

    /**
     *Funcio que extreu tots els Post de la taula de hash
     * @param taulaHash : HashMap que conté tots els Usuaris
     * @return array de Post
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
}
