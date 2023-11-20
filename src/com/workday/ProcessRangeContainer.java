package com.workday;

import java.util.ArrayList;
import java.util.List;

public class ProcessRangeContainer implements RangeContainer {
    private final long[] data;

    public ProcessRangeContainer(long[] data) {
        this.data = data;
    }

    @Override
    public Ids findIdsInRange(long fromValue,
                              long toValue,
                              boolean fromInclusive,
                              boolean toInclusive) {
        List<Short> result = new ArrayList<>();

        for (short i = 0; i < data.length; i++) {
            // add index to result if data value is in range
            if ((fromInclusive && data[i] >= fromValue || !fromInclusive && data[i] > fromValue)
                    && (toInclusive && data[i] <= toValue || !toInclusive && data[i] < toValue)) {
                result.add(i);
            }
        }
        return new ProcessedIds(result);
    }
}
