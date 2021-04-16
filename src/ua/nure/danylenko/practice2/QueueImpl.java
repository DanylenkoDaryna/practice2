package ua.nure.danylenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

        private Object[] queue;
        private int size;
        private static final int INITIAL_CAPACITY = 10;


    QueueImpl(){
            queue = new Object[INITIAL_CAPACITY];

        }

    private void grow(int oldCapacity){
        int newCapacity = oldCapacity + INITIAL_CAPACITY;
        Object[] temp=new Object[newCapacity];
        System.arraycopy(this.queue, 0,
                temp, 0,
                this.size);
        this.queue=temp;
    }

    @Override
    public void enqueue(Object element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size >= queue.length){
            grow(queue.length);
        }
        if(size==0){
                queue[0]=element;
            }else {
                queue[size] = element;
            }
        this.size++;
    }

    @Override
    public Object dequeue() {
        Object removedHead=queue[0];
        this.size=size-1;
        if(size==0){
            queue[0]=null;
        }
        Object[] temp = new Object[size];
        System.arraycopy(queue, 1,
                temp, 0,
                this.size);
        this.queue=temp;
        return removedHead;
    }

    @Override
    public Object top() {
        return this.queue[0];
    }

    @Override
    public void clear() {
        for(int i = size-1; i>=0; i--){
                queue[i]=null;
                size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Object> {
        // index of next element to return
        private int cursor;
        // index of last element returned; -1 if no such
        private int lastRet = -1;

        IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            return cursor!=QueueImpl.this.size;
        }

        @Override
        public Object next() {
            int index = cursor;
            if (index >= QueueImpl.this.size){
                throw new NoSuchElementException();
            }
            cursor=index+1;
            lastRet=index;
            return queue[index];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            int elemsToMove = size - lastRet - 1;
            if (elemsToMove > 0) {
                System.arraycopy(queue, lastRet + 1,
                        queue, lastRet,
                        elemsToMove);
            }
            size=size-1;
            cursor=lastRet;
            lastRet=cursor-1;
        }
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=0; i<=size-1; i++){
                if(i!=size-1){
                    sb.append(queue[i]).append(", ");
                }else {
                    sb.append(queue[i]);
                }
            }
            return sb.append("]").toString();
    }

}
