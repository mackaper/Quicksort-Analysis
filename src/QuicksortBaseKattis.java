import java.lang.reflect.Array;
import java.util.Random;

public class QuicksortBaseKattis{
    int i;
    int j;
    int pivot;    
    public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp; 
	}
    public void quickSort(int[] array, int low, int high)
    {
        if(low >= high || low<0)
        {
            return;
        }
        randomPivot(array, low, high);
        int p = hoarePartition(array, low, high);
        
        quickSort(array, low, p);
        quickSort(array, p+1, high);
    }
    public void randomPivot(int[] array, int first, int last)
	{
        Random rand = new Random();
        int pivot = rand.nextInt(last-first) + first;
        swap(array, last, pivot);
	}
    
    public int hoarePartition(int[] array, int low, int high)
    {
        pivot = array[low];
        i = low - 1;
        j = high + 1;

        while (true)
        {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) {
                return j;
            }
            swap(array, i, j);
        }
    }
}