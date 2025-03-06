package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public AbstractItemHandler getItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackStageItem(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(item);
            case "Conjured" :
                return new ConjuredItem(item);
            default:
                return new RegularItem(item);
        }
    }

    public void updateQuality() {
        for(Item item : items) {
            AbstractItemHandler itemHandler = getItem(item);
            itemHandler.updateQuality();
        }
    }


}



