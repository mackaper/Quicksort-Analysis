import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class QuicksortFixedPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void sortLargeArray(){
        Data actuall = even;
        Data expected = even;
        
        sorter.sort(actuall.get());
        Arrays.sort(expected.get());

        assertThat(actuall, equalTo(expected));
    }
}