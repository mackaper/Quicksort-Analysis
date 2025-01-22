import java.io.IOException;

class QuickSort extends QuicksortBaseKattis implements IntSorter {

    public QuickSort() throws IOException {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); // number of elements to sort
        int[] v = new int[n];
        int i = 0;
        // read in problem array
        while (io.hasMoreTokens()) {
            v[i++] = io.getInt();
        }
        sort(v);
        // output sorted array as solution
        for (int k : v) {
            io.println(k);
        }
        io.close();
        System.exit(0);
    }

    public void sort(int[] v) {
		quickSort(v, 0, v.length-1);
    }
}