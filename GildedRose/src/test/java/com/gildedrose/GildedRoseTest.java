package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void agedBrie_Expired() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void agedBrie_MaxQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void agedBrie_NegativeQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, -1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void sulfuras_ConstantQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void sulfuras_MaxQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void backstage_SellIn10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void backstage_SellIn5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void backstage_SellIn11() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void backstage_AboveMaxQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 51)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(51, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void backstage_NearMaxQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void standardItem_DecreasesQuality() {
        Item[] items = new Item[]{new Item("None", 11, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void standardItem_Expired() {
        Item[] items = new Item[]{new Item("None", -1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void backstage_Expired() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


    @Test
    void Conjured_BeforeSellIn() {
        Item[] items = {new Item("Conjured", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    void Conjured_AfterSellIn() {
        Item[] items = {new Item("Conjured", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void Conjured_QualityNeverNegative() {
        Item[] items = {new Item("Conjured", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }


}
