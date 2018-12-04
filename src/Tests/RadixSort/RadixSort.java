package Tests.RadixSort;

import GsonObjects.Post;

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

    public Post[] radixSortPost(Post[] posts){

        long max = getMaxPost(posts);

        for(int i = 1; max / i > 0; i *= 10){
            posts = sortPosts(i, posts);
        }   //for

        return posts;
    }

    public int[] sort(int pes, int[] array){
        int[] aux = new int[array.length];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for(int i = 0; i < array.length; i++){
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

    public Post[] sortPosts(int pes, Post[] array){
        Post[] aux = new Post[array.length];
        int[] count = new int[10];

        //conto les vegades que es repeteix el nombre del pes
        for(int i = 0; i < array.length; i++){
            count[(int) ((array[i].getPublished() / pes) % 10)]++;
        }   //for

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }   //for

        for(int i = array.length - 1; i >= 0; i--){
            aux[count[(int) ((array[i].getPublished() / pes) % 10)] - 1] = array[i];
            count[(int) ((array[i].getPublished() / pes) % 10)]--;
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
