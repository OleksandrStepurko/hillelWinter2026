package com.hillel.tests.collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CollectionTest {

    @Test
    void add() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add("a"));
        assertEquals(1, collection.size());
        assertEquals("a", collection.get(0));
        assertTrue(collection.contain("a"));
    }

    @Test
    void testAdd() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add(0, "a"));
        assertEquals(1, collection.size());
        assertEquals("a", collection.get(0));
        assertTrue(collection.contain("a"));
    }

    @Test
    void testAdd_invalid_index_less_zero() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertFalse(collection.add(-1, "a"));
        assertEquals(0, collection.size());
        assertFalse(collection.contain("a"));
    }

    @Test
    void testAdd_invalid_index_more_than_size() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertFalse(collection.add(10, "a"));
        assertEquals(0, collection.size());
        assertFalse(collection.contain("a"));
    }

    @Test
    @Disabled
    void delete() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add(0, "a"));
        assertEquals(1, collection.size());
        assertEquals(true, collection.delete("a"));
        assertEquals(0, collection.size());
    }

    @Test
    void get() {
    }

    @Test
    void contain() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void clear() {
        Collection collection = new Collection();
        assertEquals(0, collection.size());
        assertTrue(collection.add("a"));
        assertTrue(collection.add("a"));
        assertTrue(collection.add("a"));
        assertTrue(collection.add("a"));
        assertEquals(4, collection.size());
        collection.clear();
        assertEquals(0, collection.size());

    }

    @Test
    void size() {


    }
}
