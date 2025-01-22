import java.util.Arrays;

/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson
 * @version 2011-02-07
 */
public final class TimingExample {
    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args) {
        final int reps = 5;
        final int n = 1000000;
        final Stopwatch clock = new Stopwatch();

        for (int i = 0; i < reps; i++) {

            clock.reset().start();
            {
                long dummy = sum(n);
            }
            long time = clock.stop().nanoseconds();

            System.out.printf("Time to run sum(%d): %d ms%n", n, time);
        }
        QuicksortFixedPivot qsfp = new QuicksortFixedPivot();
        QuicksortFixedPivotInsertion qsfpi = new QuicksortFixedPivotInsertion();
        QuicksortRandomPivot qsrp = new QuicksortRandomPivot();
        QuicksortRandomPivotInsertion qsrpi = new QuicksortRandomPivotInsertion();
        /*System.out.println("100 elements");
        System.out.println("quicksortFixedPivot");
        allKindsOfArraysToSort(100, qsfp);
        System.out.println("quicksortFixedPivotInsertion");
        allKindsOfArraysToSort(100, qsfpi);
        System.out.println("quicksortRandomPivot");
        allKindsOfArraysToSort(100, qsrp);
        System.out.println("quicksortrandomPivotInsertion");
        allKindsOfArraysToSort(100, qsrpi);

        System.out.println("1000 elements");
        System.out.println("quicksortFixedPivot");
        allKindsOfArraysToSort(1000, qsfp);
        System.out.println("quicksortFixedPivotInsertion");
        allKindsOfArraysToSort(1000, qsfpi);
        System.out.println("quicksortRandomPivot");
        allKindsOfArraysToSort(1000, qsrp);
        System.out.println("quicksortrandomPivotInsertion");
        allKindsOfArraysToSort(1000, qsrpi);
        */

        System.out.println("10 000 elements");
        System.out.println("quicksortFixedPivot");
        allKindsOfArraysToSort(10000, qsfp);
        System.out.println("quicksortFixedPivotInsertion");
        allKindsOfArraysToSort(10000, qsfpi);
        System.out.println("quicksortRandomPivot");
        allKindsOfArraysToSort(10000, qsrp);
        System.out.println("quicksortrandomPivotInsertion");
        allKindsOfArraysToSort(10000, qsrpi);
        /*
        System.out.println("100 000 elements");
        System.out.println("quicksortFixedPivot");
        allKindsOfArraysToSort(100000, qsfp);
        System.out.println("quicksortFixedPivotInsertion");
        allKindsOfArraysToSort(100000, qsfpi);
        System.out.println("quicksortRandomPivot");
        allKindsOfArraysToSort(100000, qsrp);
        System.out.println("quicksortrandomPivotInsertion");
        allKindsOfArraysToSort(100000, qsrpi);

        System.out.println("1 000 000 elements");
        System.out.println("quicksortFixedPivot");
        allKindsOfArraysToSort(1000000, qsfp);
        System.out.println("quicksortFixedPivotInsertion");
        allKindsOfArraysToSort(1000000, qsfpi);
        System.out.println("quicksortRandomPivot");
        allKindsOfArraysToSort(1000000, qsrp);
        System.out.println("quicksortrandomPivotInsertion");
        allKindsOfArraysToSort(1000000, qsrpi);
        */


    }
    private static void allKindsOfArraysToSort(int length, IntSorter sorter)
    {
        //list of all same elements
		Data allEqual = new Data(length, 1, Data.Order.RANDOM);
		//list of random elements
		Data rand = new Data(length, length,Data.Order.RANDOM);
		//list of ascending elements
		Data ascen = new Data(length, length, Data.Order.ASCENDING);
		//list of decending elements
		Data desen = new Data(length, length, Data.Order.DESCENDING);

		System.out.println("all equal:");
		time(sorter, allEqual);
		System.out.println();
		System.out.println("random:");
		time(sorter, rand);
		System.out.println();
		System.out.println("ascending:");
		time(sorter, ascen);
		System.out.println();
		System.out.println("descending:");
		time(sorter, desen);
		System.out.println("\n");
    }
    private static void time(IntSorter sorter, Data data)
    {
        // 
        int timeCount = 0;
        final Stopwatch clock = new Stopwatch();
        int repetitions = 10;
        //skips the first 100 tests
        int markCheck = 2;
        //saves all times so we can print the min and max values
        long[] times = new long[repetitions];
        for(int i = 0; i<repetitions; i++)
        {
            clock.reset().start();
            {
                sorter.sort(data.get());
            }
            long time = clock.stop().milliseconds();
            if(i>markCheck)
            {
                timeCount +=time;
                times[i] = time;
            }
        }
        Arrays.sort(times);
        long max = times[repetitions-1];
        long min = times[0];
        int average = timeCount/(repetitions-markCheck);
        System.out.println("Average: " + average + "ms");
        System.out.println("Maximum: " + max + "ms");
        System.out.println("Minimum: " + min + "ms");
    }

    /**
     * Returns the sum 1 + 2 + ... + n.
     */
    private static long sum(int n) {
       long sum = 0;
       for (int i = 1; i <= n; i++) {
           sum += i;
       }
       return sum;
   }
}
