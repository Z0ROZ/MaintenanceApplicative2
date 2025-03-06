package com.gildedrose;

public class BackStageItem extends AbstractItemHandler {

    public BackStageItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.sellIn > 0) {
            if (item.quality < 50) {
                item.quality += 1;
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality += 1;
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality += 1;
                }
            }
        } else {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }
}
