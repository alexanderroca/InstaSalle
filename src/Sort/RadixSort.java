package Sort;

import GsonObjects.Post;

import java.util.ArrayList;

/**
 *Classe que defineix el mètode d'ordenació RadixSort
 *
 * @author: Alexander Roca
 * @version  - 0.1
 */

public class RadixSort {

    /**
     * Funcio que realitza l'ordenacio per RadixSort
     * @param posts : array de Post
     * @return array Posts : array de Posts ordenat
     */
    public ArrayList<Post> radixSortPost(ArrayList<Post> posts){

        long max = getMaxPost(posts);

        for(long i = 1; max / i > 0; i *= 10){
            posts = sortPosts(i, posts);
        }   //for

        return posts;
    }

    /**
     * Funcio que ordena array de Posts segons el pes
     * @param pes : pes (unitats, desenes, centenes, etc.)
     * @param array : array de Posts
     * @return array de Posts : array de Posts ordenats segons el seu pes
     */
    public ArrayList<Post> sortPosts(long pes, ArrayList<Post> array){
        Post[] aux = new Post[array.size()];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for(int i = 0; i < array.size(); i++){
            count[Math.toIntExact((array.get(i).getPublished() / pes) % 10)]++;
        }   //for

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }   //for

        for (int i = array.size() - 1; i >= 0; i--) {
            aux[count[Math.toIntExact((array.get(i).getPublished() / pes) % 10)] - 1] = array.get(i);
            count[Math.toIntExact((array.get(i).getPublished() / pes) % 10)]--;
        }   //for

        for(int i = 0; i < array.size(); i++){
            array.set(i, aux[i]);
        }   //for

        return array;
    }

    /**
     * Funcio que extreu la publicacio maxima de Posts
     * @param posts : array de Post
     * @return long : nombre maxim
     */
    public long getMaxPost(ArrayList<Post> posts){
        long max = posts.get(0).getPublished();

        for(int i = 1; i < posts.size() - 1; i++){

            if(max < posts.get(i).getPublished()){
                max = posts.get(i).getPublished();
            }   //if
        }   //for

        return max;
    }
}
