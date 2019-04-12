package com.javarush.task.task33.task3310.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapStorageStrategyTest {
    OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();

    @Test
    void containsKey() {
        strategy.put(100L, "100L");
        assertTrue(strategy.containsKey(100L));
    }

    @Test
    void containsValue() {
        strategy.put(100L, "100L");
        assertTrue(strategy.containsValue("100L"));
    }

    @Test
    void getKey() {
        strategy.put(100L, "100L");
        assertEquals(100L, (long)  strategy.getKey("100L"));
    }

    @Test
    void getValue() {
        strategy.put(100L, "100L");
        assertEquals("100L", strategy.getValue(100L));
    }
}