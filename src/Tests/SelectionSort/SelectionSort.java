package Tests.SelectionSort;

import GsonObjects.Post;

import java.sql.Timestamp;
import java.text.DateFormat;
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
        for(int i = 0; i < array.length - 2; i++){

            Timestamp tmp1 = new Timestamp(array[i].getPublished());
            int index = i;
            for (int j = index + 1; j < array.length - 1; j++){

                Timestamp tmp2 = new Timestamp(array[j].getPublished());
                if(tmp1.before(tmp2))
                    index = j;

                Post aux = array[index];
                array[index] = array[i];
                array[i] = aux;
            }   //for
        }   //for

        return array;
    }
}
