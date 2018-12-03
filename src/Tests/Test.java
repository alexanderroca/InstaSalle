package Tests;

import Tests.Quicksort.Parametre;
import Tests.Quicksort.QuickSort;
import Tests.RadixSort.RadixSort;
import Tests.SelectionSort.SelectionSort;

/**
 *Test del programa InstaSalle
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){
        int[] test = {3,5,7,8,1,10,100};

        SelectionSort selectionSort = new SelectionSort();
        RadixSort radixSort = new RadixSort();

        test = selectionSort.selectionSort(test);

        //test = radixSort.radixSort(test);

        //TODO: debug QuickSort - Marc Cespedes
        /*
        Parametre parametre = new Parametre(test);

        QuickSort quickSort = new QuickSort();
         test = quickSort.QuicksortI(parametre);
        */
         for(int i = 0; i < test.length; i++){
             System.out.println(test[i] + " ");
         }  //int
    }
}
