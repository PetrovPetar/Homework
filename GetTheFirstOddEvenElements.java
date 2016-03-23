import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by petar on 2016-03-02.
 */
public class GetTheFirstOddEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");
        int [] numbers = new int[input.length];
        ArrayList<Integer> oddNums = new ArrayList<>();
        ArrayList<Integer> evenNums =  new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            if ( numbers[i] % 2 == 0){
                evenNums.add(numbers[i]);
            }else{
                oddNums.add(numbers[i]);
            }

        }
        for (Integer item:oddNums) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (Integer item:evenNums) {
            System.out.print(item + " ");
        }
    }
}
