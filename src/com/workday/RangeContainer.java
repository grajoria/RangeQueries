package com.workday;

public interface RangeContainer {
    Ids findIdsInRange(long fromValue,
                       long toValue,
                       boolean fromInclusive,
                       boolean toInclusive);
}
