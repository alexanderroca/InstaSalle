package Tests.SelectionSort;

import GsonObjects.Post;

import java.util.Date;

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
            for (int j = index + 1; j < array.length; j++){
                if(array[j] < array[index])
                    index = j;

                int aux = array[index];
                array[index] = array[i];
                array[i] = aux;
            }   //for
        }   //for

        return array;
    }

    public Post[] selectionSortPosts(Post[] array){
        for(int i = 0; i < array.length - 1; i++){

            Date data1 = new Date(array[i].getPublished());
            int index = i;
            for (int j = index + 1; j < array.length; j++){

                Date data2 = new Date(array[j].getPublished());
                if(data1.getTime() > data2.getTime())
                    index = j;

                Post aux = array[index];
                array[index] = array[i];
                array[i] = aux;
            }   //for
        }   //for

        return array;
    }
}
