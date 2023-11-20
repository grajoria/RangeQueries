import com.workday.RangeContainer;
import com.workday.RangeContainerFactory;
import com.workday.YourRangeContainerFactory;
import com.workday.Ids;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class RangeQueryPerformanceTest {
    private RangeContainer rc;
    private static final int DATASET_SIZE = 32000;

    @Before
    public void setUp() {
        RangeContainerFactory rf = new YourRangeContainerFactory();
        rc = rf.createContainer(generateRandomDataset(DATASET_SIZE));
    }

    @Test
    public void testPerformance() {
        long startTime = System.nanoTime();

        Ids ids = rc.findIdsInRange(1000, 5000, true, false);

        long endTime = System.nanoTime();

        System.out.println("Query execution time: " + (endTime - startTime) / 1000 + " micro seconds");
    }

    private long[] generateRandomDataset(int size) {
        Random random = new Random();
        long[] data = new long[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextLong();
        }
        return data;
    }
}

