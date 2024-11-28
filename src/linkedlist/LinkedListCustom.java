package linkedlist;

import java.util.*;

public class LinkedListCustom<E> implements List<E> {

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;


    public LinkedListCustom() {
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E e) {

        checkPositionIndex(index);

        if(index == size)
            linkLast(e);
        else
            linkBefore(e, node(index));
    }



    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public void addLast(E e) {
        linkLast(e);
    }



    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }


    private Node<E> search(int index) {

        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
    }

    private void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void linkBefore(E e, Node<E> node) {

        final Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, e, node);
        node.prev = newNode;

        if(pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }


    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isPositionIndex ( int index ) {
        return index >= 0 && index <=size;
    }

    private Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
    }



    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
