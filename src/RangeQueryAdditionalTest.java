import com.workday.RangeContainer;
import com.workday.RangeContainerFactory;
import com.workday.YourRangeContainerFactory;
import com.workday.Ids;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeQueryAdditionalTest {
    private RangeContainer rc;

    @Before
    public void setUp() {
        RangeContainerFactory rf = new YourRangeContainerFactory();
        rc = rf.createContainer(new long[]{-10, 12, 17, 21, -1, 2, 15, 16,});
    }

    @Test
    public void runARangeQuery() {
        Ids ids = rc.findIdsInRange(-14, 17, true, true);
        assertEquals(0, ids.nextId());
        assertEquals(1, ids.nextId());
        assertEquals(2, ids.nextId());
        assertEquals(4, ids.nextId());
        assertEquals(5, ids.nextId());
        assertEquals(6, ids.nextId());
        assertEquals(7, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(-5, 3, true, false);
        assertEquals(4, ids.nextId());
        assertEquals(5, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
        assertEquals(3, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
    }
}


