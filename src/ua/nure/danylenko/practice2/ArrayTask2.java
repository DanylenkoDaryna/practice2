package ua.nure.danylenko.practice2;


import com.sun.javafx.scene.NodeHelper;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

public class ArrayTask2 {

    public static void main(String[] args){

        //треба delete середній елемент в однозвязному списку,
//        використовувати розміри у вигляді чітного і нечітного числа
//        якщо елемент чітний, то брати перший елемент другої половини
        //функ має вертати оригінальний змінений список, а не новий
        // linked list
//
//        System.out.println("---  Double linked list ---");
//
//        LinkedList elements = new LinkedList();
//        elements.add(1);
//        elements.add(2);
//        elements.add(3);
//        elements.add(4);
//        elements.add(5);
//        elements.add(6);
//
//        deleteMiddle3(elements);
//
//        LinkedList elements2 = new LinkedList();
//        elements2.add(1);
//        elements2.add(1.23);
//        elements2.add(3455);
//        elements2.add("Samurai");
//        elements2.add('c');
//
//        System.out.println("elements:");
//        elements.forEach(n -> System.out.print(n+"; "));
//        System.out.println();
//
//        deleteMiddle2(elements);
//        System.out.println("elements:");
//        elements.forEach(n -> System.out.print(n+"; "));
//        System.out.println();
//
//        deleteMiddle2(elements);
//        deleteMiddle2(elements);
//        deleteMiddle2(elements);
//        deleteMiddle2(elements);
//        elements.forEach(n -> System.out.print(n+"; "));
//        System.out.println();
//
//
//        elements2.forEach(n -> System.out.print(n+"; "));
//        System.out.println();
//        deleteMiddle2(elements2);
//        deleteMiddle2(elements2);
//        elements2.forEach(n -> System.out.print(n+"; "));
//        System.out.println();


        System.out.println("---  One linked list ---");
        oneLinkedListTest();

        oneLinkedListTest2();
    }

    private static LinkedList deleteMiddle2(LinkedList elements){

            System.out.println(elements.get(elements.size()/2));
            elements.remove(elements.size()/2);
        return  elements;
    }

    private static void deleteMiddle3(LinkedList elements){

      System.out.println("-- Consumer --");

        Consumer<Object> consumer = value -> {

            System.out.println(elements.get(elements.size()/2));
            elements.remove(elements.size()/2);
        };

        consumer.accept(elements);
    }

    private static void oneLinkedListTest(){
        OneLinkList<Integer> listOne = new OneLinkList<>();
        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listOne.add(4);
        listOne.add(5);
        listOne.add(6);
        listOne.add(7);
       // listOne.remove(listOne.getSize()/2);

        Consumer<Integer> consumer = num -> System.out.print(num);
       listOne.forEach(consumer);
    }

    private static void oneLinkedListTest2(){



    }

}

class OneLinkList<T> implements IOneLinkList, Iterable<T>{

    private int size;
    private Node first;

    public OneLinkList(){
        size =0;
        first = new Node();
    }


    @Override
    public Object get(Object value) {
        return null;
    }

    @Override
    public void add(Object value) {
        if(size==0) {
            first.setValue((Integer)value);
            //first.setNext(new Node());
            size=size+1;
        }
        else {
            Node temp = findLast();
            Node finalNode = new Node();
            finalNode.setValue((Integer)value);
            temp.setNext(finalNode);
            size = size+1;
        }
    }

    private Node findLast(){
        Node temp = first;
        int count = 0;
        while(count!=size){
            temp = temp.getNext();
            count++;
        }
        return temp;
    }

    @Override
    public void remove(Object value) {

    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorImpl();
    }

    class MyIteratorImpl implements Iterator{

        private Node temp;

        protected  MyIteratorImpl(){
            temp=first;
        }


        @Override
        public boolean hasNext() {

            if(temp.getNext()!=null&temp.getNext().getValue()!=null)
                return true;
            else return false;
        }

        @Override
        public Object next() {
            return temp.getNext().getValue();
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }

}

interface IOneLinkList<T> {

     T get(T value);
     void add(T value);
     void remove(T value);
}

class Node {

    private Node next;
    private Integer value;

    public Node(){

    }

    public Node(Integer val){
        value=val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
