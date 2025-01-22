public class QuicksortRandomPivotInsertion extends QuicksortBase implements IntSorter{
    InsertionSort insertion;
    public void sort(int[] array) {
        insertion = new InsertionSort();
        if(array.length>1)
        {
            qsort(array, 0, array.length-1);
            insertion.sort(array);
        }
    }
    public void qsort(int[] array, int low, int high) {
        if(low >= high || low<0)
        {
            return;
        }
        else if((high-low) <= 50)
        {
            return;
        }
        else
        {
            int p = rpartition(array, low, high);
            qsort(array, low, p);
            qsort(array, p+1, high);
        }
    }
}
    
  