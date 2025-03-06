package com.gildedrose;

public abstract class AbstractItemHandler {

    protected Item item;

    public AbstractItemHandler(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();
}
