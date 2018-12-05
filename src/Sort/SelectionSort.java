package Sort;

import GsonObjects.Post;

/**
 *Classe que defineix el mètode d'ordenació SelectionSort
 *
 * @author: Alexander Roca
 * @version  - 0.1
 */

public class SelectionSort {

    public int[] selectionSort(int[] array){

        for(int i = 0; i < array.length - 1; i++){

            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if(array[j] < array[index])
                    index = j;

                int aux = array[index];
                array[index] = array[i];
                array[i] = aux;
            }   //for
        }   //for

        return array;
    }


    /**
     * Funcio que ordena els posts segons la seva data de publicacio
     * @param array : array de Post
     * @return array de Post ordenat segons la seva data de publicacio
     */
    public Post[] selectionSortPosts(Post[] array){
        for(int i = 0; i < array.length - 1; i++){

            int index = i;
            for (int j = i + 1; j < array.length; j++){

                if(array[j].getPublished() > array[index].getPublished())
                    index = j;

                Post aux = array[i];
                array[i] = array[index];
                array[index] = aux;
            }   //for
        }   //for

        return array;
    }
}
