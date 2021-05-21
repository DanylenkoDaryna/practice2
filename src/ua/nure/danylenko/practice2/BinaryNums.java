package ua.nure.danylenko.practice2;

public class BinaryNums {

    public static void main(String[] args){

//        узяти число і згенерувати та вивести у функції двійкові числа усіх чисел, що ідуть до вказаного
//                якщо менше або =0 то нічого не виводити
//                знайти патерн
//                        у документації джава
        int concreteNum = 6;
        System.out.println("Binary nums of concrete num");
        System.out.println(concreteNum + ": ");
        findBinaryNum(concreteNum);
        findBinaryNum(0);
        findBinaryNum(-12);
        findBinaryNum(12);
    }

    private static void findBinaryNum(int concreteNum){

        if(concreteNum<=0){
            System.out.print("nothing cuz num<=0");
            return;
        }else{
            int count = 1;
            while(count<=concreteNum){
                System.out.print(Integer.toBinaryString(count)+ "; ");
                count++;
            }
        }
        System.out.println();
    }
}
