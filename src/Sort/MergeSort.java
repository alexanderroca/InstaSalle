package Sort;

/**
 *Classe que defineix el mètode d'ordenació MergeSort
 *
 * @author: Marc Cespedes
 * @version 15/11/2018 - 0.1
 */

public class MergeSort {

     public int[] ordenaMergeI(int[] a, int i, int j){
         int mig;

         if(i>=j)
            return a;

         if(i<j){
             mig = (i+j)/2;
             a = ordenaMergeI(a, i, mig);
             a = ordenaMergeI(a, mig+1,j);
             a = merge(a, i, mig, j);
         }
         return a;
     }

     public int[] merge(int[] a, int i, int mig, int j){
        int[] b = new int[a.length];
        int k1 = i, k2 = mig + 1, cursor = 0, kr;

        while (k1 <= mig && k2 <= j){

            if(a[k1] <= a[k2]){
                b[cursor] = a[k1];
                k1++;
                cursor++;
            }

            if(a[k1] > a[k2]){
                b[cursor] = a[k2];
                k2++;
                cursor++;
            }
        }

        while(k1 <= mig){
            b[cursor] = a[k1];
            k1++;
            cursor++;
        }

         while(k2 <= j){
             b[cursor] = a[k2];
             k2++;
             cursor++;
         }

         cursor = 0;
         kr = i;

         while(kr <= j){
             a[kr] = b[cursor];
             kr++;
             cursor++;
         }
        return a;
     }
}
