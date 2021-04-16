package ua.nure.danylenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private Node firstEl;
    private Node lastEl;
    private int size;

    ListImpl(){ }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(this.firstEl==null && this.lastEl==null){
            return sb.append("]").toString();
        }else {
            for(Node x = this.firstEl; x != this.lastEl; x=x.next) {
                if(x!=null){
                    sb.append(x.obj).append(", ");
                }else{
                    throw new IllegalArgumentException();
                }
            }
            return sb.append(this.lastEl.obj).append("]").toString();
        }
    }

    private static class Node {

        private Object obj;
        private Node prev;
        private Node next;

        Node(Node prev, Object item, Node next) {
            this.obj = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return obj.toString();
        }
    }

    private class IteratorImpl implements Iterator<Object> {

        private Node current;
        private Node next;
        private int nextIndex;

        IteratorImpl(){
            this.next=firstEl;
            this.current=null;
        }

        @Override
        public boolean hasNext(){
            return nextIndex < ListImpl.this.size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
         Node tempNext=next;
            next=tempNext.next;
            current=tempNext;
            nextIndex++;
            return current.obj;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException();
            }
            Node lastNext = current.next;
            unlink(current);
            if (current.next == current) {
                current.next = lastNext;
            }else{
                nextIndex--;
            }
            current = null;
        }
    }

    @Override
    public void addFirst(Object element) {

        final Node temp = this.firstEl;
        final Node newNode=new Node(null,element,temp);
        this.firstEl=newNode;
        if(temp==null){
            this.lastEl = newNode;
        }else{
            temp.prev=newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(Object element) {
        final Node tempPrev = this.lastEl;
        final Node newNode = new Node(tempPrev,element,null);
        this.lastEl = newNode;
        if(tempPrev==null){
            this.firstEl=newNode;
        }else{
            tempPrev.next=newNode;
        }
        this.size++;
    }

    @Override
    public void removeFirst() {
        final Node nextFirst=this.firstEl.next;
        this.firstEl.obj=null;
        this.firstEl.next=null;
        this.firstEl=nextFirst;
        if(nextFirst==null){
            this.lastEl=null;
        }else{
            nextFirst.prev=null;
        }

        this.size--;
    }

    @Override
    public void removeLast() {
        final Node nextLast=this.lastEl.prev;
        this.lastEl.obj=null;
        this.lastEl.prev=null;
        this.lastEl=nextLast;
        if(nextLast==null){
            this.firstEl=null;
        }else{
            nextLast.next=null;
        }
        this.size--;
    }

    @Override
    public Object getFirst() {
        return this.firstEl.obj;
    }

    @Override
    public Object getLast() {
        return this.lastEl.obj;
    }

    @Override
    public Object search(Object element) {
        if (element == null) {
            for (Node x = this.firstEl; x != null; x = x.next) {
                if (x.obj == null) {
                    return null;
                }
            }
        } else {
            for (Node x = this.firstEl; x != null; x = x.next) {
                if (element.equals(x.obj)) {
                    return x.obj;
                }
            }
        }

        return null;
    }

        @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (Node x = this.firstEl; x != null; x = x.next) {
                if (x.obj == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = this.firstEl; x != null; x = x.next) {
                if (element.equals(x.obj)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node x) {
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            this.firstEl = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            this.lastEl = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.obj = null;
        this.size--;
    }

    @Override
    public void clear() {
        Node next;
        Node x = this.firstEl;
        while (x != null) {
            next = x.next;
            x.obj = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        this.firstEl = this.lastEl = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

}
