import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GandalfsStash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstMood = Integer.parseInt(scanner.nextLine());
        String[] foods = scanner.nextLine().split("\\W");
        int pointsOfHappiness = firstMood;

        for (int i = 0; i < foods.length; i++) {
            Pattern pat = Pattern.compile("[a-zA-Z]+");
            Matcher match = pat.matcher(foods[i]);
            if (match.find()) {
                String food = match.group();
                food = food.toLowerCase();

                if (food.equals("cram")) {
                    pointsOfHappiness += 2;
                } else if (food.equals("lembas")) {
                    pointsOfHappiness += 3;
                } else if (food.equals("apple")) {
                    pointsOfHappiness += 1;
                } else if (food.equals("melon")) {
                    pointsOfHappiness += 1;
                } else if (food.equals("honeycake")) {
                    pointsOfHappiness += 5;
                } else if (food.equals("mushrooms")) {
                    pointsOfHappiness -= 10;
                } else {
                    pointsOfHappiness -= 1;
                }
            }
        }
        System.out.println(pointsOfHappiness);
        if(pointsOfHappiness < -5){
            System.out.println("Angry");
        } else if (pointsOfHappiness >= -5 && pointsOfHappiness <= 0){
            System.out.println("Sad");
        } else if (pointsOfHappiness > 0 && pointsOfHappiness < 15){
            System.out.println("Happy");
        } else {
            System.out.println("Special JavaScript mood");
        }
    }
}
