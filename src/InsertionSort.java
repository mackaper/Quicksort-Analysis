public class InsertionSort implements IntSorter{
    @Override
    public void sort(int[] array) {
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
    
    public void sort3(int[] array, int first, int last) {
        for(int i =first+1; i <last; i++) 
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
}

/*public class InsertionSort implements IntSorter{
    @Override
    public void sort(int[] array) {
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
    
    public void sort3(int[] array, int first, int last) {
        for(int i =first; i <last; i++) 
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
}
*/