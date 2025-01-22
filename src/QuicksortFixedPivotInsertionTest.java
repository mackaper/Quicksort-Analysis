import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class QuicksortFixedPivotInsertionTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }
    @Before
    public void setUp() {
        super.setUp();
    }
}