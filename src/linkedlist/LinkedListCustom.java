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


    // add
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

    //remove
    public void removeFirst() {

        Node<E> f = first;

        if (f == null)
            throw new NoSuchElementException();

        unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {

        //첫번째 노드 값을 저장
        final E element = f.item;
        //첫번째 다음 노드를 저장
        final Node<E> next = f.next;

        //첫번째 노드 값을 비워줌
        f.item = null;
        //첫번째 노드 다음 노드를 비워줌
        f.next = null;
        //다음 노드를 첫 번째로 지정
        first = next;

        // 다음 노드가 없다면 last null처리, 있다면 이전 노드를 비워둔다.
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }


    public void removeLast() {

        Node<E> l = last;

        if (l == null) {
            throw new NoSuchElementException();
        }
        unlinkLast(l);
    }

    private E unlinkLast(Node<E> l) {

        //마지막 노드의 value 값 저장
        final E item = l.item;
        //마지막 노드 이전 노드 저장
        final Node<E> prev = l.prev;

        //마지막 노드 value 비워둠
        l.item = null;
        //마지막 노드 이전 노드 비워둠
        l.prev = null;
        //last를 이전 노드로
        last = prev;

        //이전 노드가 없다면 first를 null로 있다면 이전 노드의 다음을 null로
        if (prev == null) {
            first = null;
        }else {
            prev.next = null;
        }

        return item;
    }


    @Override
    public E remove(int index) {
        checkPositionIndex(index);
        return unlink(node(index));
    }


    private E unlink(Node<E> x) {
        E element = x.item;
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object o) {

        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }

        return false;
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
        checkPositionIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
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


    private Node<E> search(int index) {

        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
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
