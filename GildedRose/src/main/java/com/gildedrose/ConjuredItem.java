package com.gildedrose;

public class ConjuredItem extends AbstractItemHandler{
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 2 : 4);
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn--;
    }
}
