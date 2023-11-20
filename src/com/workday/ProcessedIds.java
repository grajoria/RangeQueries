package com.workday;

import java.util.List;

public class ProcessedIds implements Ids {
    private final List<Short> ids;
    private int currentIndex;

    public ProcessedIds(List<Short> ids) {
        this.ids = ids;
        this.currentIndex = 0;
    }

    @Override
    public short nextId() {
        if (currentIndex < ids.size()) {
            return ids.get(currentIndex++);
        } else {
            return END_OF_IDS;
        }
    }
}
