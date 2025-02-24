/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ajaxlaur
 */
public class LinkedListTests {

    @Test
    public void emptyListTest() {
        LinkedList l = new LinkedList();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10Nums() {
        LinkedList<Integer> l = new LinkedList();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveralInt() {
        LinkedList<Integer> l = new LinkedList();
        int[] elements = new int[]{3, 8, 7, 2, 6, 5, 0};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetOOBInt() {
        LinkedList<Integer> l = new LinkedList();
        l.add(3);
        l.add(2);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSomeInt() {
        LinkedList<Integer> l = new LinkedList();
        l.add(5);
        l.add(8);
        l.add(7);
        l.add(1);
        l.add(9);

        assertEquals(7, l.remove(2));
        assertEquals(8, l.get(1));
        assertEquals(1, l.get(2));

        assertEquals(5, l.remove(0));
        assertEquals(8, l.get(0));

        assertEquals(9, l.remove(2));
        assertEquals(1, l.get(1));
    }

    @Test
    public void listRemoveOOBInt() {
        LinkedList<Integer> l = new LinkedList();
        l.add(5);
        l.add(8);
        l.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        LinkedList<String> l = new LinkedList();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveralString() {
        LinkedList<String> l = new LinkedList();
        String[] elements = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listRemoveSomeString() {
        LinkedList<String> l = new LinkedList();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));

        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }
}
