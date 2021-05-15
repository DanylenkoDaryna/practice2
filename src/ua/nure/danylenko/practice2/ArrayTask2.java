package ua.nure.danylenko.practice2;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayTask2 {

    public static void main(String[] args){

        //треба delete середній елемент в однозвязному списку,
//        використовувати розміри у вигляді чітного і нечітного числа
//        якщо елемент чітний, то брати перший елемент другої половини
        //функцыя має вертати оригінайльний змінений список, а не новий
        // linked list

        System.out.println("---");

        LinkedList elements = new LinkedList();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(6);

        LinkedList elements2 = new LinkedList();
        elements2.add(1);
        elements2.add(1.23);
        elements2.add(3455);
        elements2.add("Samurai");
        elements2.add('c');

        System.out.println("elements:");
        elements.forEach(n -> System.out.print(n+"; "));
        System.out.println();

        deleteMiddle(elements);
        System.out.println("elements:");
        elements.forEach(n -> System.out.println(n));
        System.out.println();
//
//        System.out.println(maximumProduct2(t1));
//        System.out.println(maximumProduct2(t2));
//        System.out.println(maximumProduct2(t3));
//        System.out.println(maximumProduct2(t4));

    }

    private static LinkedList deleteMiddle(LinkedList elements){

        if(elements.size()%2==0){
            System.out.println(elements.size()/2);
            elements.remove(elements.size()/2);
        }else{
            System.out.println(elements.size()/2);
            elements.remove(elements.size()/2);
        }
        return  elements;
    }

}
