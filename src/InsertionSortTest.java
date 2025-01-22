import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class InsertionSortTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new InsertionSort();
    }
    @Before
    public void setUp() {
        super.setUp();
    }
    /*@Test
    public void sortEvenArray(){
        super.sortEvenArray();
    }
    @Test
    public void sortOddArray(){
        super.sortOddArray();
    }
    @Test
    public void sortRandomArray(){
        super.sortRandomArray();
    }
    @Test
    public void sortAscendingArray(){
        super.sortAscendingArray();
    }
    @Test
    public void sortDescendingArray(){
        super.sortDescendingArray();
    }*/
}