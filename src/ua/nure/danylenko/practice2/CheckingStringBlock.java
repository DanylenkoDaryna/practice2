package ua.nure.danylenko.practice2;
import java.util.Stack;

public class CheckingStringBlock {

    public static void main(String[] args) {

    //функція із логічним типом на вході строка перевірити чи правильна послідовність блоків: круглих скобок, трикутних скобок, квадратних скобок
    //тру якщо відкриваються і закриваються по черзі
      //use structures

        System.out.println(checkingBrackets("<increment("));
        System.out.println(checkingBrackets("()incre<>ment<>"));
        System.out.println(checkingBrackets("<incr>ement())"));
        System.out.println(checkingBrackets("[increment]"));

    }

    private static boolean checkingBrackets(String input){

        System.out.print(input + " is ");
        Stack<Character> openedBrackets = new Stack();
        Stack<Character> closedBrackets = new Stack();
        for(char ch:input.toCharArray()){
            if(ch=='('||ch=='<'||ch=='['){
                openedBrackets.push(ch);
            }else if(ch==')'||ch=='>'||ch==']'){
                closedBrackets.push(ch);
            }
        }

        if(openedBrackets.size()!=closedBrackets.size())
        return false;
        else{
            for(int i=0; i<openedBrackets.size(); i++){
                switch (openedBrackets.peek()){
                    case '<':
                        if (closedBrackets.peek() != '>') return false;
                        else break;
                    case '(':
                        if (closedBrackets.peek() != ')') return false;
                        else break;
                    case '[':
                        if (closedBrackets.peek() != ']') return false;
                        else break;
                }
                openedBrackets.pop();
                closedBrackets.pop();
            }
            return true;
        }
    }
}
