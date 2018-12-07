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
    private final String[] CATEGORIES = {"landscape", "food", "sports", "style", "animals", "tv_shows", "fitness", "science_tech",
            "music", "travel", "architecture"};
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

    public ArrayList<Post> extractPostsFromUser(Hashtable<String, Usuari> hashtable, String username){
        ArrayList<Post> interestingPosts = new ArrayList<>();

        Interessos interessos = new Interessos();

        interessos.setCategory(CATEGORIES);

        for(int i = 0; i < hashtable.get(username).getConnections().size(); i++){
            int visits, likes, comments;
            visits = hashtable.get(username).getConnections().get(i).getVisits();
            likes = hashtable.get(username).getConnections().get(i).getLikes();
            comments = hashtable.get(username).getConnections().get(i).getComments();

            for(int j = 0;
                j < hashtable.get(hashtable.get(username).getConnections().get(i).getUsername()).getPosts().size();
                j++){

                for(int k = 0; k < interessos.getCategory().length; k++){

                    if(hashtable.get(hashtable.get(username).getConnections()
                            .get(i).getUsername()).getPosts().get(j).getCategory().equals(interessos.getCategory()[k])){

                        interessos.setNum(interessos.getNum()[k]++, k);
                    }   //if
                }   //for

            }   //for
        }   //for

        return interestingPosts;
    }
}
