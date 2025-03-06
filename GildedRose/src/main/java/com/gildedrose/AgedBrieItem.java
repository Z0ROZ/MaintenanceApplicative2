package com.gildedrose;

public class AgedBrieItem extends AbstractItemHandler{

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;

        if (item.sellIn <= 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
