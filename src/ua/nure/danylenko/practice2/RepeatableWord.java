package ua.nure.danylenko.practice2;

import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RepeatableWord {

    public static void main(String[] args) {

// знайти найповторюваніше слово у строці через відомі структури, слова розділяються пунктуацією і пробілами
// слова у верхньому та нижньому регістрі -однакові
// якщо декілька слів повторюються однаково, то повертається перше із них короткі слова -зв 'Язки не рахуються

        String testString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

      //  String testString2 = "Penguins are aquatic, flightless birds that are highly adapted to life in the water. Their distinct tuxedo-like appearance is called countershading, a form of camouflage that helps keep them safe in the water. Penguins do have wing-bones, though they are flipper-like and extremely suited to swimming. Penguins are found almost exclusively in the southern hemisphere, where they catch their food underwater and raise their young on land.";

      //  String testString3 = "Students seek relief from rising prices through the purchase of used copies of textbooks, which tend to be less expensive. Most college bookstores offer used copies of textbooks at lower prices. Most bookstores will also buy used copies back from students at the end of a term if the book is going to be re-used at the school. Books that are not being re-used at the school are often purchased by an off-campus wholesaler for 0-30% of the new cost, for distribution to other bookstores where the books will be sold. Textbook companies have countered this by encouraging faculty to assign homework that must be done on the publisher's website. If a student has a new textbook, then he or she can use the pass code in the book to register on the site. If the student has purchased a used textbook, then he or she must pay money directly to the publisher in order to access the website and complete assigned homework. ";

        System.out.println(findMostRepeatable(testString));//Lorem
      //  System.out.println(findMostRepeatable(testString2));//Penguins
      //  System.out.println(findMostRepeatable(testString3));//used
    }

    private static String findMostRepeatable(String input){

        List<String> wordList = Arrays.asList(input.replace(".", "").replace(",", "")
                                    .toLowerCase().split(" "));

       // HashMap<String,String> wordsMap = new HashMap<>();
        Queue<Word> queue = new LinkedList();

        ArrayList<String> listNoWords = new ArrayList<>();
        listNoWords.addAll(Arrays.asList("the","a","or","and", "but", "is", "are", "of", "on", "to", "was", "were", "in",
                "that", "in", "your", "i", "his", "their", "her", "it`s", "it", "you", "me", "they", "at", "be" ));

        Predicate<String> predicate = str -> {
            for(String noWord :listNoWords){
                if(noWord.equals(str)) return false;
                else continue;
            }
            return true;
        };

        Consumer<String> consumer = st ->{
            if(predicate.test(st)) {

                queue.add(new Word(0,st));
                System.out.println(st);
            }
        };

        wordList.forEach(consumer);

        Consumer<Word> consumer2 = wrd ->{
           
        };
        queue.forEach(consumer2);





       // wordsMap.forEach( (k,v) -> System.out.println(k + " - " + v));


        return "";
    }

}

class Word{
    private int count;
    private String value;

    public Word(){
        count=0;
        value="";
    }

    public Word(int num, String str){
        count=num;
        value=str;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
