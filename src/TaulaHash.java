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
    public static final double RADI_TERRA = 6371;

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
    public Post[] extractPosts(TaulaHash taulaHash){
        Post[] posts = new Post[taulaHash.hashtable.size()];
        
        for(int i = 0; i < taulaHash.hashtable.size(); i++){
            String key = "user" + i;

            for(int j = 0; j < hashtable.get(key).getPosts().size(); j++){
                posts[i] = taulaHash.hashtable.get(key).getPosts().get(j);
            }   //for

        }   //for

        return posts;
    }

    /**
     * Funcio que realitza la formual de Haversine
     * @param latitudO : double que indica la latitude inicial
     * @param longitudO : double que indica la longitud inicial
     * @param latitudF : double que indica la latitud final
     * @param longitudF : double que indica la longitud final
     * @return double que indica la distancia
     */
    public double calculaDistancia(double latitudO, double longitudO, double latitudF, double longitudF){
        double dLatitud = Math.toRadians(latitudF - latitudO);
        double dLongitud = Math.toRadians(longitudF - longitudO);

        latitudO = Math.toRadians(latitudO);
        latitudF = Math.toRadians(latitudF);

        double var1 = Math.pow(Math.sin(dLatitud / 2), 2) + Math.pow(Math.sin(dLongitud / 2), 2) *
                    Math.cos(latitudO) * Math.cos(latitudF);
        double var2 = 2 * Math.asin(Math.sqrt(var1));

        return RADI_TERRA * var2;    //distancia
    }
}
