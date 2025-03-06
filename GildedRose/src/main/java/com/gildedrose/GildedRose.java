package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    handleItemAged_Brie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleItemBackStage(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    handleItemSulfuras(item);
                    break;
                case "Conjured" :
                    handleItemConjured(item);
                    break;
                default:
                    handleItemRegular(item);
                    break;
            }
        }
    }

    public void handleItemAged_Brie(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 0 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
    }

    public void handleItemSulfuras(Item item) {
    }


    public void handleItemBackStage(Item item) {
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

    public void handleItemRegular(Item item) {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 1 : 2);
        }
        item.sellIn--;
    }

    public void handleItemConjured(Item item) {
        if (item.quality > 0) {
            item.quality -= (item.sellIn > 0 ? 2 : 4);
            if (item.quality < 0) {
                item.quality = 0;
            }
        }
        item.sellIn--;
    }


}



