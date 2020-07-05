package com.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class linkedListTest {

    linkedList<Integer> dupLinkedList = new linkedList<>();
    linkedList<Integer> dupLinkedList2 = new linkedList<>();
    linkedList<Integer> dupLinkedList3 = new linkedList<>();

    void linkedListDuplicates() {
        dupLinkedList.insert(4);
        dupLinkedList.insert(3);
        dupLinkedList.insert(4);
        dupLinkedList.insert(4);
        dupLinkedList.insert(3);
        dupLinkedList.insert(1);
        dupLinkedList.insert(7);
        dupLinkedList.insert(4);

        dupLinkedList2.insert(1);
        dupLinkedList2.insert(1);
        dupLinkedList2.insert(1);

        for (int i = 0; i < 5; i++) {
            dupLinkedList3.insert(i);
        }
        for (int i = 0; i < 5; i++) {
            dupLinkedList3.insert(i);
        }
    }


    @Test
    void testRemoveDuplicates() {
        linkedListDuplicates();
        dupLinkedList.printList();
        dupLinkedList.removeDuplicates();
        dupLinkedList.printList();

        dupLinkedList2.printList();
        dupLinkedList2.removeDuplicates();
        dupLinkedList2.printList();
    }

    @Test
    void testRemoveDuplicatesNoBuffer() {
        linkedListDuplicates();

        dupLinkedList.printList();
        dupLinkedList.removeDupsNoBuffer();
        dupLinkedList.printList();

        dupLinkedList2.printList();
        dupLinkedList2.removeDupsNoBuffer();
        dupLinkedList2.printList();

        dupLinkedList3.printList();
        dupLinkedList3.removeDupsNoBuffer();
        dupLinkedList3.printList();
    }

    @Test
    void testConstructor() {
        linkedList<Integer> linkedList = new linkedList<>();
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(12);
        linkedList.printList();
        assertEquals(3, linkedList.length());
    }

    @Test
    void testRemove() {
        linkedList<Integer> linkedList = new linkedList<>();
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(12);
        linkedList.insert(7);
        linkedList.printList();
        System.out.println();
        assertEquals(4, linkedList.length());
        linkedList.remove(3);
        linkedList.printList();
        System.out.println();
        assertEquals(3, linkedList.length());
        linkedList.remove(4);
        linkedList.printList();
        System.out.println();
        assertEquals(2, linkedList.length());
        linkedList.insert(23);
        linkedList.remove(23);
        linkedList.printList();
    }
}