package Tests.RadixSort;

import GsonObjects.Post;

import java.io.IOException;

/**
 *Classe que defineix el mètode d'ordenació RadixSort
 *
 * @author: Alexander Roca
 * @version  - 0.1
 */

public class RadixSort {

    public int[] radixSort(int[] array){

        int max = getMax(array);

        for(int i = 1; max / i > 0; i *= 10){
            array = sort(i, array);
        }   //for

        return array;
    }

    /**
     * Funcio que realitza l'ordenacio per RadixSort
     * @param posts : array de Post
     * @return array Posts : array de Posts ordenat
     */
    public Post[] radixSortPost(Post[] posts){

        long max = getMaxPost(posts);

        for(long i = 1; max / i > 0; i *= 10){
            posts = sortPosts(i, posts);
        }   //for

        return posts;
    }

    /**
     *
     * @param pes
     * @param array
     * @return
     */
    public int[] sort(int pes, int[] array){
        int[] aux = new int[array.length];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for(int i = 0; i < array.length - 1; i++){
            count[(array[i] / pes) % 10]++;
        }   //for

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }   //for

        for(int i = array.length - 1; i >= 0; i--){
            aux[count[(array[i] / pes) % 10] - 1] = array[i];
            count[(array[i] / pes) % 10]--;
        }   //for

        for(int i = 0; i < array.length; i++){
            array[i] = aux[i];
        }   //for

        return array;
    }

    /**
     * Funcio que ordena array de Posts segons el pes
     * @param pes : pes (unitats, desenes, centenes, etc.)
     * @param array : array de Posts
     * @return array de Posts : array de Posts ordenats segons el seu pes
     */
    public Post[] sortPosts(long pes, Post[] array){
        Post[] aux = new Post[array.length];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for(int i = 0; i < array.length; i++){
            count[Math.toIntExact((array[i].getPublished() / pes) % 10)]++;
        }   //for

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }   //for

        for (int i = array.length - 1; i >= 0; i--) {
            aux[count[Math.toIntExact((array[i].getPublished() / pes) % 10)] - 1] = array[i];
            count[Math.toIntExact((array[i].getPublished() / pes) % 10)]--;
        }   //for

        for(int i = 0; i < array.length; i++){
            array[i] = aux[i];
        }   //for

        return array;
    }

    /**
     * Funcio que extreu el nombre maxim d'un array
     * @param array : array que conte numeros
     * @return int : numero maxim de l'array inicial
     */
    public int getMax(int[] array){
        int max = array[0];

        for(int i = 1; i < array.length; i++){

            if(max < array[i]){
                max = array[i];
            }   //if
        }   //for

        return max;
    }

    /**
     * Funcio que extreu la publicacio maxima de Posts
     * @param posts : array de Post
     * @return long : nombre maxim
     */
    public long getMaxPost(Post[] posts){
        long max = posts[0].getPublished();

        for(int i = 1; i < posts.length - 1; i++){

            if(max < posts[i].getPublished()){
                max = posts[i].getPublished();
            }   //if
        }   //for

        return max;
    }
}
