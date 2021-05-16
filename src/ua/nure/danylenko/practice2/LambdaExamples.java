package ua.nure.danylenko.practice2;

import java.util.function.Predicate;

public class LambdaExamples {

    public static void main(String[] args){

        //Створити лямбда вираз, яке повертає значення true, якщо рядок не null, використовуючи функціональний інтерфейс Predicate.
        //Створити лямбда вираз, яке перевіряє, що рядок не порожній, використовуючи функціональний інтерфейс Predicate.
        //Написати програму яка перевіряє, що рядок не null і не порожня, використовуючи метод and () функціонального інтерфейсу Predicate.
        //Написати програму, яка перевіряє, що рядок починається буквою "J" або "N" і закінчується "A". Використовуємо функціональний інтерфейс Predicate.
        //Написати лямбда вираз, яке приймає на вхід об'єкт типу HeavyBox і виводить на консоль повідомлення "Відвантажили ящик з вагою n". "Відправляємо ящик з вагою n" Використовуємо функціональний інтерфейс Consumer і метод за замовчуванням andThen.
        //Написати лямбда вираз, яке приймає на вхід число і повертає значення "Позитивне число", "Негативне число" або "Нуль". Використовуємо функціональний інтерфейс Function.
        //Написати лямбда вираз, яке повертає випадкове число від 0 до 10. Використовуємо функціональний інтерфейс Supplier.
        //Переробити клас використовує Printable використовуючи посилання на статичний метод.

        System.out.println("---");
        Predicate<String> predicate = n -> n.isEmpty();
        String str = "abba-labba-dub-dub";

       // System.out.println(str.chars().(predicate));


    }


    private static String deleteMiddle( Predicate<String> predicate){

//        if(elements.size()%2==0){
//            System.out.println(elements.size()/2);
//            elements.remove(elements.size()/2);
//        }else{
//            System.out.println(elements.size()/2);
//            elements.remove(elements.size()/2);
//        }
//        return  elements;
        return null;
    }
}
