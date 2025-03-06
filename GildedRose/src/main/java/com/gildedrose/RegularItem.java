package com.gildedrose;

public class RegularItem extends AbstractItemHandler{

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 1 : 2);
        }
        item.sellIn--;
    }
}
