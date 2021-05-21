package ua.nure.danylenko.practice2;


import java.util.Random;
import java.util.function.*;

public class LambdaExamples {

    public static void main(String[] args){


        task1();
        System.out.println();
        task12();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();
        task5();
        System.out.println();
        task6();
        System.out.println();
        task7();
        System.out.println();
        task8();
        System.out.println();
        task9();

    }


    private static void task1( ){
        //Створити лямбда вираз, який повертає значення true, якщо рядок не null, використовуючи функціональний інтерфейс Predicate.

        System.out.println("---");
        Predicate<String> predicate = n -> {

            if(n.isEmpty()==false){
                System.out.println("|" + n + "|" + " - it`s true - string isn`t empty");
                return true;
            }else if(n==null){
                System.out.println("string is null");
                return false;
            }
            else{
                System.out.println("|" + n + "|" + " - it`s false - string is empty");
                return false;}
        };
        System.out.println(predicate.test("abc"));
        System.out.println(predicate.test(" a"));
        System.out.println(predicate.test(" "));
        System.out.println(predicate.test(""));


    }

    private static void task12( ){
        //Створити лямбда вираз, який повертає значення true, якщо рядок не null, використовуючи функціональний інтерфейс Predicate.

        System.out.println("---");
        Predicate<String> predicate = n -> {
            try{
                if(n!=null || !n.isEmpty()){
                    System.out.println("string isn`t null");
                    return true;
                }else{
                    return false;
                }
            }catch(NullPointerException nex){
                System.out.println("string is null");
                return false;
            }

        };

        System.out.println(predicate.test(" "));
        System.out.println(predicate.test(""));
        System.out.println(predicate.test(new String()));
        System.out.println(predicate.test(null));
        String s = null;
        System.out.println(predicate.test(s));


    }

    private static void task2( ){
        //Створити лямбда вираз, яке перевіряє, що рядок не порожній, використовуючи функціональний інтерфейс Predicate.
        System.out.println("---");
        Predicate<String> predicate2 = n -> n.isEmpty();
        String str = "abba-labba-dub-dub";
        String str2 = " ";
        String str3 = "";
        String str4 = "  6  ";
        String str5 = ""+"";

        System.out.println(predicate2.test(str));
        System.out.println(predicate2.test(str2));
        System.out.println(predicate2.test(str3));
        System.out.println(predicate2.test(str4));
        System.out.println(predicate2.test(str5));
    }

    private static void task3( ){
        System.out.println("---");
        //Написати програму яка перевіряє, що рядок не null і не порожня, використовуючи метод and () функціонального інтерфейсу Predicate.
    Predicate<String> pred = str -> str!=null?true:false;

        System.out.println(pred.and(str2 -> !str2.isEmpty()).test(" "));

    }

    private static void task4( ){
        System.out.println("---");
        //Написати програму, яка перевіряє, що рядок починається буквою "J" або "N" і закінчується "A".
        // Використовуємо функціональний інтерфейс Predicate.
    Predicate<String> p1 = str -> ((str.charAt(0)=='J'||str.charAt(0)=='N') & str.charAt(str.length()-1)=='A');

        System.out.println(p1.test("NitrA"));
        System.out.println(p1.test("Nitra"));
        System.out.println(p1.test("nitra"));
        System.out.println(p1.test("Jitra"));
        System.out.println(p1.test("JitrA"));

    }

    private static void task5( ){
        System.out.println("---");
        //Написати лямбда вираз, який приймає на вхід об'єкт типу HeavyBox і виводить на консоль повідомлення
        // "Відвантажили ящик з вагою n". "Відправляємо ящик з вагою n" Використовуємо функціональний інтерфейс
        // Consumer і метод за замовчуванням andThen.

        class HeavyBox{
            public int weight;
            public HeavyBox(){

            }
            public HeavyBox(int value){
             weight = value;
            }
        }
        Consumer<HeavyBox> consumer = heavyBox -> {
            System.out.printf("Відвантажили ящик з вагою %s", heavyBox.weight);
            System.out.println();
        };

        Consumer<HeavyBox> consumer2 = heavyBox -> {
            System.out.printf("Відправляємо ящик з вагою %s", heavyBox.weight);
            System.out.println();
        };

        HeavyBox hb1 = new HeavyBox(45);
        HeavyBox hb2 = new HeavyBox(234);

        consumer.andThen(consumer2).accept(hb1);
        consumer.andThen(consumer2).accept(hb2);

    }

    private static void task6( ){
        System.out.println("---");
        //Написати лямбда вираз, який приймає на вхід число і повертає значення "Позитивне число",
        // "Негативне число" або "Нуль". Використовуємо функціональний інтерфейс Function.
        Function<Integer,String> funk = num -> {
            if(num>0)return " Позитивне число";
            else if(num<0)return " Негативне число";
                    else return " Нуль";
        };

        System.out.println(funk.apply(357));
        System.out.println(funk.apply(-7));
        System.out.println(funk.apply(0));
    }

    private static void task7( ){
        System.out.println("---");
        //Написати лямбда вираз, яке повертає випадкове число від 0 до 10. Використовуємо функціональний інтерфейс Supplier.
        Supplier<Integer> supplier= () -> {
            Random random = new Random();
            return random.nextInt(10);
        };

        System.out.println(supplier.get());
    }

    private static void task8( ){
        System.out.println("---");
        //Написати лямбда вираз для інтерфейсу Printable, який має один метод void print().
//        Printable printable = (str)->{
//            System.out.println("new string: " + str);
//        };
        Printable printable = System.out::println;
      printable.print("dsaff");
      printable.print("Deny that rubbish");
    }

    private static void task9( ){
        System.out.println("---");
        //Переробити клас, що використовує Printable використавши посилання на статичний метод.
        Printable printable = P::print;
        printable.print("dsaff");
        printable.print("Deny that rubbish");
    }


}

class P {

    public static void print(String str){

        System.out.println("new string: " + str);

    }
}

@FunctionalInterface
interface Printable {

    void print(String string);


}
