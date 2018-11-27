package Sort;

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
        int[] b = null;
        int k1 = i, k2 = mig + 1, cursor = 1, kr;

        while((k1 <= mig) && (k2<=j)){
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

         while(k1 <= mig){
             b[cursor] = a[k2];
             k1++;
             cursor++;
         }

         cursor = 1;
         kr = 1;

         while(kr <= j){
             a[kr] = b[cursor];
             kr++;
             cursor++;
         }
        return a;
     }
}
