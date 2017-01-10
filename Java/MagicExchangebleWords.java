import java.util.Scanner;

import java.util.*;


/**
 * Created by petar on 2016-02-29.
 */
public class MagicExchangebleWords{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(" ");
        char [] firstWord = input[0].toCharArray();
        char [] secondWord = input[1].toCharArray();
        Map<Character,Character> bookOfLetters = new HashMap<>();


        for (int i = 0; i < firstWord.length; i++) {
            if(!bookOfLetters.containsKey(firstWord[i])){

            bookOfLetters.put(firstWord[i], secondWord[i]);

            }else{
                if (!bookOfLetters.containsValue(secondWord[i])){
                    System.out.println("false");
                    return;
                }


            }
        }
        System.out.println("true");
    }
}

