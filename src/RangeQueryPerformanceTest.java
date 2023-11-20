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
        rc = rf.createContainer(generateRandomDataset());
    }

    @Test
    public void testPerformance() {
        long startTime = System.nanoTime();
        Ids ids = rc.findIdsInRange(-2000000000, 30000000, true, false);
        long endTime = System.nanoTime();
        System.out.println("findIdsInRange() execution time: " + (endTime - startTime) / 1000 + " micro seconds");


        int count = 0;
        startTime = System.nanoTime();
        while(ids.nextId() != Ids.END_OF_IDS) {
            count++;
        }
        endTime = System.nanoTime();
        if (count != 0) {
            System.out.println("average nextId() execution time: " + (endTime - startTime) / count + "nano seconds");
        }
    }

    private long[] generateRandomDataset() {

        Random random = new Random();
        long[] data = new long[DATASET_SIZE];
        for (int i = 0; i < DATASET_SIZE; i++) {
            data[i] = random.nextInt();
            // System.out.println(data[i] + ", ");
        }
        return data;
    }
}
