package ua.nure.danylenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] array;
    private static final int INITIAL_CAPACITY = 10;
    private int size;

    class IteratorImpl implements Iterator {

        // index of next element to return
        private int cursor;
        // index of last element returned; -1 if no such
        private int lastRet = -1;

        IteratorImpl(){}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= getSize()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            lastRet = i;
            return getArray()[lastRet];

        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            ArrayImpl.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
        }
    }

    ArrayImpl(){
        setSize(0);
        setArray(new Object[INITIAL_CAPACITY]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<=getSize()-1; i++){
           if(i!=getSize()-1){
               sb.append(getArray()[i]).append(", ");
           }else{
               sb.append(getArray()[i]);
           }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void add(Object element) {

        if(getSize() == getArray().length){
            grow(getSize());
        }else {
            getArray()[getSize()] = element;
            setSize(getSize() + 1);
        }
    }

    private void grow(int oldCapacity) {
        int newCapacity = oldCapacity + INITIAL_CAPACITY;
        Object[] temp=new Object[newCapacity];
        System.arraycopy(getArray(), 0,
                temp, 0,
                getSize());
        setArray(temp);
    }

    @Override
    public void set(int index, Object element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("check bounds");
        }else {
            getArray()[index] = element;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("check bounds");
        }else {
            return getArray()[index];
        }
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (getArray()[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(getArray()[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }else {
            int elemsToMove = size - index - 1;
            if (elemsToMove > 0) {
                Object[] temp1 = getArray();
                Object[] temp2 = getArray();
                System.arraycopy(temp1, index + 1,
                        temp2, index,
                        elemsToMove);
            }
            getArray()[--size] = null;
        }
    }

    @Override
    public void clear() {

        for (int i = 0; i < getSize(); i++) {
            getArray()[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private Object[] getArray() {
        return array;
    }

    private void setArray(Object[] array) {
        this.array = array;
    }

    private int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }
}
