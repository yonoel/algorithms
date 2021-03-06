package com.study.chapter.Fir_Base.TwoSection_AbstractDataType.collection;

import java.util.Iterator;

/**
 * LIFO == FILO
 * @param <Item>
 */
public class LinkedStack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){return N;}
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
