 import org.junit.Test;
 import org.junit.Before;
 import static org.junit.Assert.*;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

 /**
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @version 2018-01-16
  */
 public abstract class IntSorterTest {
     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();
     IntSorter sorter;
     Data odd;
     Data even;
     Data random;
     Data ascending;
     Data decending;
     Data allEqual;
     Data large;

     @Before
     public void setUp() {  
        sorter = getIntSorter();
        odd = new Data(501, 100, Data.Order.RANDOM);
        even = new Data(500, 100, Data.Order.RANDOM);
        random = new Data(500, 100, Data.Order.RANDOM);
        ascending = new Data(500, 100, Data.Order.ASCENDING);
        decending = new Data(500, 100, Data.Order.DESCENDING);
        allEqual = new Data(500, 1, Data.Order.RANDOM);
        large = new Data(1000000, 300, Data.Order.RANDOM);
     }

     @Test
     public void sortEvenArray(){
      int[] expected = even.get();
      int[] actuall = even.get();
      
      Arrays.sort(expected);
      sorter.sort(actuall);

      assertThat(actuall, equalTo(expected));
     }
     @Test
     public void sortOddArray(){
        int[] expected = odd.get();
        int[] actuall = odd.get();

        Arrays.sort(expected);
        sorter.sort(actuall);

        assertThat(actuall, equalTo(expected));
     }
     @Test
     public void sortRandomArray(){
        int[] expected = random.get();
        int[] actuall = random.get();

        Arrays.sort(expected);
        sorter.sort(actuall);

        assertThat(actuall, equalTo(expected));
     }
     @Test
     public void sortAscendingArray(){
      int[] expected = ascending.get();
      int[] actuall = ascending.get();

      Arrays.sort(expected);
      sorter.sort(actuall);

      assertThat(actuall, equalTo(expected));
     }
     @Test
     public void sortDescendingArray(){
      int[] expected = decending.get();
      int[] actuall = decending.get();

      Arrays.sort(expected);
      sorter.sort(actuall);

      assertThat(actuall, equalTo(expected));
     }
     @Test
     public void sortArrayWithAllEqual(){
      int[] expected = allEqual.get();
      int[] actuall = allEqual.get();

      Arrays.sort(expected);
      sorter.sort(actuall);

      assertThat(actuall, equalTo(expected));
     }


 }
