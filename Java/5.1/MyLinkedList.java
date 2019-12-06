import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private void checkIndex(int index) {
        if(!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException("Item index is not in size range");
    }

    @Override
    public void add(E element) {
        Node<E> prev = last;
        Node<E> newNode = new Node<>(prev, element, null);
        last = newNode;
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if(index == size) {
            add(element);
        }
        else {
            Node<E> curNode = getNode(index);
            Node<E> newNode = new Node<>(curNode.prev, element, curNode);
            if (curNode == first)
                first = newNode;
            else
                curNode.prev.next = newNode;
            curNode.prev = newNode;
            size++;
        }
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (element.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> curNode = getNode(index);
        E element = curNode.item;
        Node<E> next = curNode.next;
        Node<E> prev = curNode.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            curNode.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            curNode.next = null;
        }
        curNode.item = null;
        size--;
        return element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> curNode = getNode(index);
        E oldEl = curNode.item;
        curNode.item = element;
        return oldEl;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] array) {
        if(array.length < size)
            array = (E[])java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        int i = 0;
        Object[] seq = array;
        for (Node<E> x = first; x != null; x = x.next)
            seq[i++] = x.item;

        if (array.length > size)
            array[size] = null;
        return array;
    }

    @Override
    public Object[] toArray() {
        Object[] seq = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            seq[i++] = x.item;
        return seq;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> curNode = first;
            @Override
            public boolean hasNext() {
                return curNode != null;
            }
            @Override
            public E next() {
                if (hasNext()) {
                    E value = curNode.item;
                    curNode = curNode.next;
                    return value;
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}