package com.ctci;

import java.util.HashSet;

public class linkedList<T> {


    public Node<T> head;

    public void removeDuplicates() {
        HashSet<T> existing = new HashSet<>();
        if (head == null) {
            return;
        }
        Node<T> curr = head;
        if (curr.next == null) {
            return;
        }
        Node<T> follow = curr.next;
        existing.add(curr.data);
        while (follow != null) {
            if (!existing.contains(follow.data)) {
                existing.add(follow.data);
                curr = follow;
                follow = follow.next;
            } else {
                curr.next = follow.next;
                follow = curr.next;
            }
        }
    }

    public void removeDupsNoBuffer() {
        if (head == null) {
            return;
        }
        Node<T> current = head;
        Node<T> checker;
        while (current != null) {
            T currData = current.data;
            checker = current;
            while (checker.next != null) {
                if (checker.next.data.equals(currData)) {
                    checker.next = checker.next.next;
                } else {
                    checker = checker.next;
                }
            }
            current = current.next;
        }
    }

    public linkedList() {
        this.head = null;
    }

    public void printList() {
        if (this.head == null) {
            System.out.println("");
        } else {
            Node<T> curr = this.head;
            System.out.print(curr.data + "-->");
            while (curr.next != null) {
                curr = curr.next;
                System.out.print(curr.data + "-->");
            }
        }
        System.out.println();
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            System.out.print("This item does not exist in the linked list");
        } else {
            Node<T> curr = this.head;
            if (curr.data.equals(data)) {
                head = curr.next;
            } else {
                while (curr.next != null) {
                    if (curr.next.data.equals(data)) {
                        curr.next = curr.next.next;
                        return;
                    }
                    curr = curr.next;
                }
            }
        }
    }

    public int length() {

        if (this.head == null) {
            return 0;
        } else {
            Node<T> curr = this.head;
            int len = 1;
            while (curr.next != null) {
                len += 1;
                curr = curr.next;
            }
            return len;
        }
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T item) {
            this.data = item;
            this.next = null;
        }
    }
}

