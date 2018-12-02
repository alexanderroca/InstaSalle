package Tests.SelectionSort;

/**
 *Classe que defineix el mètode d'ordenació SelectionSort
 *
 * @author: Marc Cespedes
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

}
