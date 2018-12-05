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

    /**
     *
     * @param array
     * @param latitudO
     * @param longitudO
     * @return
     */
    public Post[] selectionSortProximity(Post[] array, double latitudO, double longitudO){
        for(int i = 0; i < array.length - 1; i++){

            int index = i;
            for (int j = i + 1; j < array.length; j++){

                if(Math.abs(array[j].calculaDistancia(latitudO, longitudO, array[j].getLocation()[0], array[j].getLocation()[1]))
                        < Math.abs(array[index].calculaDistancia(latitudO, longitudO, array[index].getLocation()[0], array[index].getLocation()[1])))
                    index = j;

                Post aux = array[i];
                array[i] = array[index];
                array[index] = aux;
            }   //for
        }   //for

        for(int i = 0; i < array.length; i++){
            System.out.println(Math.abs(array[i].calculaDistancia(latitudO, longitudO, array[i].getLocation()[0], array[i].getLocation()[1])));
        }   //for

        return array;
    }
}
