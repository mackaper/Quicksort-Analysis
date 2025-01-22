import java.text.CollationElementIterator;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import java.util.Collections;


public class TimingMeasure
{
    public static void main(String[] args) {
        // create sorters
        QuicksortFixedPivot qsfp = new QuicksortFixedPivot();
        QuicksortFixedPivotInsertion qsfpi = new QuicksortFixedPivotInsertion();
        QuicksortRandomPivot qsrp = new QuicksortRandomPivot();
        QuicksortRandomPivotInsertion qsrpi = new QuicksortRandomPivotInsertion();
        InsertionSort ins = new InsertionSort();
        //warmup
        test(1000, 100 , qsrp, false );
        //testing
        final Stopwatch clock = new Stopwatch();

        Data[] RsortedData = {
            new Data(100 , 100, Data.Order.RANDOM),
            new Data(1000 , 1000, Data.Order.RANDOM),
            new Data(10000 , 10000, Data.Order.RANDOM),
            new Data(100000 , 100000, Data.Order.RANDOM),
            new Data(1000000, 10000000, Data.Order.RANDOM),
        };
        Data[] AllEqualsortedData = {
            new Data(100 , 1, Data.Order.RANDOM),
            new Data(1000 , 1, Data.Order.RANDOM),
            new Data(10000 , 1, Data.Order.RANDOM),
            new Data(100000 , 1, Data.Order.RANDOM),
            new Data(1000000, 1, Data.Order.RANDOM),
        };
        Data[] DsortedData = {
            new Data(100 , 100, Data.Order.DESCENDING),
            new Data(1000 , 1000, Data.Order.DESCENDING),
            new Data(10000 , 10000, Data.Order.DESCENDING),
            new Data(100000 , 100000, Data.Order.DESCENDING),
            new Data(1000000, 10000000, Data.Order.DESCENDING),
        };
        Data[] AsortedData = {
            new Data(100 , 100, Data.Order.ASCENDING),
            new Data(1000 , 1000, Data.Order.ASCENDING),
            new Data(10000 , 10000, Data.Order.ASCENDING),
            new Data(100000 , 100000, Data.Order.ASCENDING),
            new Data(1000000, 10000000, Data.Order.ASCENDING),
        };
        
        
        for(int i = 0; i<RsortedData.length; i++)
        {
            ArrayList<Long> results = new ArrayList<>();
            long aver = 0;
            int size = RsortedData[i].get().length;
            for(int n = 0; n<100; n++)
            {
                int[] array = RsortedData[i].get();
                clock.reset().start();
                {
                    ins.sort(array);
                }
                long time = clock.stop().nanoseconds();
                results.add(time);
                aver+=time;
            }
            aver=Math.floorDiv(aver, 100);
            Collections.sort(results);
            System.out.println(size+ "\naverage; " + aver);
            System.out.println("best; " + results.get(0));
            System.out.println("worst; " + results.get(results.size()-1)); 
        }
        
        
    }

    private static void test(int length, int reps, IntSorter sorter, boolean print)
    {
        //list of all same elements
		Data allEqual = new Data(length, 1, Data.Order.RANDOM);
		//list of random elements
		Data rand = new Data(length, length,Data.Order.RANDOM);
		//list of ascending elements
		Data ascen = new Data(length, length, Data.Order.ASCENDING);
		//list of decending elements
		Data desen = new Data(length, length, Data.Order.DESCENDING);

        //for arrays.sort
        /*
        System.out.println("all equal:");
		timeArraySort(reps, allEqual, print);
		System.out.println();
        System.out.println("Random:");
		timeArraySort(reps, rand, print);
		System.out.println();
        System.out.println("ascending:");
		timeArraySort(reps, ascen, print);
		System.out.println();
        System.out.println("descending:");
		timeArraySort(reps, desen, print);
		System.out.println();
        */

        
		System.out.println("all equal:");
		time(sorter,reps, allEqual, print);
		System.out.println();
		System.out.println("random:");
		time(sorter,reps, rand, print);
		System.out.println();
        
		System.out.println("ascending:");
		time(sorter,reps, ascen, print);
		System.out.println();
        
		System.out.println("descending:");
		time(sorter,reps, desen, print);
		System.out.println("\n");
    }
    
    private static void time(IntSorter sorter,int reps, Data data, boolean print)
    {
        // 
        int timeCount = 0;
        final Stopwatch clock = new Stopwatch();
        //int markCheck = -1;
        //saves all times so we can print the min and max values
        long[] times = new long[reps];
        for(int i = 0; i<reps; i++)
        {
            int[] testArray =data.get();
            clock.reset().start();
            {
                sorter.sort(testArray);
            }
            long time = clock.stop().milliseconds();

            timeCount +=time;
            times[i] = time;
            /*if(i>markCheck)
            {
                
            }*/
        }
        long max = Arrays.stream(times).max().getAsLong();
        long min = Arrays.stream(times).min().getAsLong();
        //int average = timeCount/(reps-markCheck);
        long aver = sumoftime(times)/times.length;
        if(print == true)
        {
            /*for(int i = 0; i< times.length; i++)
            {
                System.out.println(times[i]);
            }*/
            System.out.println("Average: " + aver + "ns");
            System.out.println("Maximum: " + max + "ns");
            System.out.println("Minimum: " + min + "ns");
        }
    }
    private static long sumoftime(long[] n) {
        long sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }




    private static void measureSorter(int size, IntSorter sorter){
		//100 one's elements
		Data one = new Data(size, 1, Data.Order.RANDOM);

		//Random 100 elements
		Data rand = new Data(size, size,Data.Order.RANDOM);

		//100 elements ascending
		Data asc = new Data(size, size, Data.Order.ASCENDING);

		//100 elements descending
		Data des = new Data(size, size, Data.Order.DESCENDING);


		System.out.println("Many ones");
		measureTime(sorter, one);
		System.out.println();
		System.out.println("Random:");
		measureTime(sorter, rand);
		System.out.println();
		System.out.println("Ascending:");
		measureTime(sorter, asc);
		System.out.println();
		System.out.println("Descending:");
		measureTime(sorter, des);
		System.out.println("\n");
	}
    private static void measureTime(IntSorter sorter, Data data) {
		
		int avarage = 0;
		final Stopwatch clock = new Stopwatch();
		final int reps = 1000;
		final int countMark = 100;
		final String surfix = " ms";
		for (int k = 0; k < reps; k++) {

			clock.reset().start();
			{
				sorter.sort(data.get());
			}
			long time = (clock.stop().nanoseconds());

			if(k > countMark){
				avarage += time;
			}
		}
		System.out.println("| Avarage: " +(avarage/(reps-countMark)) + surfix +" |");

	}

}

