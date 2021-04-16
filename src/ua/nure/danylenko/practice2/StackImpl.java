package ua.nure.danylenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    private int top;
    private Object[] stack;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    StackImpl(){
        stack = new Object[INITIAL_CAPACITY];
        size=0;
        top=0;
    }

    private void grow(int oldCapacity){
        int newCapacity = oldCapacity + INITIAL_CAPACITY;
        Object[] temp=new Object[newCapacity];
        System.arraycopy(stack, 0,
                temp, 0,
                size);
        stack=temp;
    }

    @Override
    public void push(Object element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size >= stack.length){
            grow(stack.length);
        }
        stack[size]=element;
            top=size;
            size++;
    }

    @Override
    public Object pop() {
        Object removed=stack[top];
        if(size==0){
            stack[0]=null;
        }
        stack[size-1]=null;
        size=size-1;
        top=size-1;
        return removed;
    }

    @Override
    public Object top() {
        return stack[top];
    }

    @Override
    public void clear() {
        for(int i = size-1; i>=0; i--){
            stack[i]=null;
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Object> {
        // index of next element to return
        private int cursor=size-1;
        private int lastRet = size;

        IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            return cursor>=0;
        }

        @Override
        public Object next() {
            int next=cursor;
            if (next<0){
                throw new NoSuchElementException();
            }
            lastRet=next;
            cursor=next-1;
            return stack[next];
        }

        @Override
        public void remove() {
            if (lastRet>=size){
                throw new IllegalStateException();
            }
            stack[lastRet]=null;
            int elemsToMove = size - lastRet - 1;
            if (elemsToMove > 0) {
                System.arraycopy(stack, lastRet + 1,
                        stack, lastRet,
                        elemsToMove);
            }
            size=size-1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<=size-1; i++){
            if(i!=size-1){
                sb.append(stack[i]).append(", ");
            }else {
                sb.append(stack[i]);

            }
        }
        return sb.append("]").toString();
    }

}
