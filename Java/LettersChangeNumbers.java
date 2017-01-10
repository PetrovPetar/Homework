import java.text.DecimalFormat;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String [] words = scanner.nextLine().split("\\s+");
        double finalSum = 0;

        for (int i = 0; i < words.length; i++) {
            double digit = Integer.parseInt(words[i].substring(1,words[i].length()-1));
            double sumOfWord = 0;
            if(Character.isLowerCase(words[i].charAt(0))){
                sumOfWord = digit*(words[i].charAt(0) - 96);
            } else if ( Character.isUpperCase(words[i].charAt(0))){
                sumOfWord = digit/(words[i].charAt(0) - 64);
            }
            if(Character.isLowerCase(words[i].charAt(words[i].length()-1))){
                sumOfWord += words[i].charAt(words[i].length()-1) - 96;
            } else if(Character.isUpperCase(words[i].charAt(words[i].length()-1))){
                sumOfWord -= words[i].charAt(words[i].length()-1) - 64;
            }
            finalSum += sumOfWord;

        }
        System.out.println(String.format("%.2f", finalSum));
    }
}
