package com.workday;

public class YourRangeContainerFactory implements RangeContainerFactory {
    @Override
    public RangeContainer createContainer(long[] data) {
        return new ProcessRangeContainer(data);
    }
}
