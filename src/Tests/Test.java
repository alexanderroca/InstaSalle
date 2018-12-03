package Tests;


import Tests.RadixSort.RadixSort;
import Tests.SelectionSort.SelectionSort;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *Test del programa InstaSalle
 *
 * @author: Alexander Roca, Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class Test {
    public static void main(String[] args){
        int[] test = {3,5,7,8,1,10,100};

        Date itemDate = new Date(21420729);
        Calendar cal = Calendar.getInstance();
        cal.setTime(itemDate);

        Date itemDate2 = new Date(21420729);
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(itemDate2);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);

        if(itemDate.getTime() < itemDate2.getTime()){
            System.out.println(cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
            System.out.println(cal2.get(Calendar.DATE) + "-" + cal2.get(Calendar.MONTH) + "-" + cal2.get(Calendar.YEAR));
        }   //if
        else{
            System.out.println(cal2.get(Calendar.DATE) + "-" + cal2.get(Calendar.MONTH) + "-" + cal2.get(Calendar.YEAR));
            System.out.println(cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
        }

        //SelectionSort selectionSort = new SelectionSort();
        //RadixSort radixSort = new RadixSort();

        //test = selectionSort.selectionSort(test);

        //test = radixSort.radixSort(test);

        //TODO: debug QuickSort - Marc Cespedes
        /*
        Parametre parametre = new Parametre(test);

        QuickSort quickSort = new QuickSort();
         test = quickSort.QuicksortI(parametre);

         for(int i = 0; i < test.length; i++){
             System.out.println(test[i] + " ");
         }  //int
         */
    }
}
