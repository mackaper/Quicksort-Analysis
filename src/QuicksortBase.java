import java.util.Random;

public class QuicksortBase{
    int i;
    int j;
    int pivot;

	public int partition(int[] array, int low, int high) {
        pivot = array[(high-low)/2 + low];
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
    public int rpartition(int[] array, int first, int last) {
        Random rand = new Random();
        int pivot = rand.nextInt(last-first) + first;
        swap(array, pivot, first);
        return partition(array, first, last);
    }
    public int[] partitionMiddle(int[] array, int first, int last, int pivot) {
	    int low = first;
	    int mid = first;
	    int high = last;


	    while (mid <= high) {

	        int x = array[mid];
	        if (x < pivot) 
            {
	            array[mid] = array[low];
	            array[low] = x;
	            low++;
	            mid++;
	        } 
            else if (x == pivot) 
            {
	            mid++;
	        } 
            else // x>pivot 
            {
	            array[mid] = array[high];
	            array[high] = x;
	            high--;
	        }
	        
	    }
	    return new int[]{low-1,high+1};
	}
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 4, 5};
        QuicksortBase b = new QuicksortBase();
        int i = b.partition(a, 0, a.length-1);
        System.out.println(i);
    }
    
    public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp; 
	}
    public void randomPivot(int[] array, int first, int last)
	{
        Random rand = new Random();
        int pivot = rand.nextInt(last-first) + first;
        swap(array, pivot, first);
	}

    //FÖR KATTIS;
    //ALLA METODER UNDER HÄR ÄR FÖR KATTIS
    public void quickSort(int[] array, int low, int high)
    {
        if(low >= high || low<0)
        {
            return;
        }
        
        int p = hoarePartition(array, low, high);
        quickSort(array, low, p);
        quickSort(array, p+1, high);
    }
    public void insertionSort(int[] array){
        for(int i =1; i <array.length; i++) 
        {
            int a = i;
            while(a>0 && array[a-1] > array[a])
            {
                int temp = array[a];
                array[a] = array[a-1];
                array[a-1] = temp;
                a--;
            }
        }
    }
    public void insertionQuickSort(int [] array, int low, int high){
        if(low >= high || low<0)
        {
            return;
        }

        if ((high-low) <= 1)
        {
            insertionSort(array);
        }
        int p = partition(array, low, high);
        insertionQuickSort(array, low, p);
        insertionQuickSort(array, p+1, high);
    }
    public int hoarePartition(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;

        while (true)
        {
            do {
                i++;
            } while (a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i >= j) {
                return j;
            }
            swap(a, i, j);
        }
    }
    public int median(int[] array, int first, int last){
        int mid = first + (last-first)/2;
        int a = array[first];
        int b = array[mid];
        int c = array[last];
        int median = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
        int pivot = median;

        return pivot;
    }
}