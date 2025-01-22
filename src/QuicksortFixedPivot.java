public class QuicksortFixedPivot extends QuicksortBase implements IntSorter{
    public void sort(int[] array) {
       
        if(array.length>1)
        {
            qsort(array, 0, array.length-1); 
        }
    }
    public void qsort(int[] array, int low, int high) {
        if(low >= high || low<0)
        {
            return;
        }
        
        else
        {
            int p = partition(array, low, high);
            qsort(array, low, p);
            qsort(array, p+1, high);
        }
    }
}