import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVDatabase {
    public static void main(String[] args) {
        try (
                BufferedReader studentFile = new BufferedReader(
                        new FileReader("C:\\Users\\petar\\Desktop\\student.txt"));
                BufferedReader gradesFile = new BufferedReader(
                        new FileReader("C:\\Users\\petar\\Desktop\\grades.txt"))

        ) {

            TreeMap<Integer, String> studentsInfo = new TreeMap<>();
            String line = null;
            String nums = "0123456789";

            while ((line = studentFile.readLine()) != null) {

                String[] info = line.split(",\\s*");
                if (nums.contains(info[0])) {
                    int id = Integer.parseInt(info[0]);
                    String firstName = info[1];
                    String lastName = info[2];
                    int age = Integer.parseInt(info[3]);
                    String town = info[4];

                    String studentInfo = firstName + " " + lastName + "( age: " + age + ", town: " + town + ")";
                    studentsInfo.put(id, studentInfo);


                }

            }
            TreeMap<Integer, String> gradesMap = new TreeMap<>();

            while ((line = gradesFile.readLine()) != null) {

                String[] info = line.split(",");
                if (nums.contains(info[0])) {
                    int id = Integer.parseInt(info[0]);
                    String firstGrades = info[1];
                    String secondGrades = info[2];

                    String gradesInfo = firstGrades + '\n' + secondGrades;
                    gradesMap.put(id, gradesInfo);
                }

            }

            HashMap<Integer,String> allInfoStudents = new HashMap<>();

            for (Map.Entry<Integer,String> person:studentsInfo.entrySet()) {

                for (Map.Entry<Integer,String> gradePerson:gradesMap.entrySet()) {

                    if (person.getKey() == gradePerson.getKey()){
                        String value = person.getValue() + '\n' + gradePerson.getValue();
                        allInfoStudents.put(person.getKey(), value );

                        break;
                    }
                }
            }
            Scanner reader = new Scanner(System.in);
            String command = reader.nextLine();
            while(command != "END"){
                command = reader.nextLine();
                if(command.equals("Search-by-full-name")){
                    String name = reader.nextLine();
                    Pattern pat = Pattern.compile(name);
                    int counterMatches = 0;
                    for (Map.Entry<Integer, String> entry : allInfoStudents.entrySet()) {
                        Matcher match = pat.matcher(entry.getValue());
                        if(match.find()){
                            System.out.println(entry.getValue());
                            counterMatches++;
                        }
                    }
                    if(counterMatches == 0){
                        System.out.println("Student does not exist!");
                    }
                    counterMatches = 0;
                } else if(command.equals("Search-by-id")){

                        int id = Integer.parseInt(reader.nextLine());

                        int counterMatches = 0;
                        for (Map.Entry<Integer, String> entry : allInfoStudents.entrySet()) {

                            if (id == entry.getKey()) {
                                System.out.println(entry.getValue());
                                counterMatches++;
                            }
                        }
                        if (counterMatches == 0) {
                            System.out.println("Student does not exist!");
                        }
                        counterMatches = 0;

                } else if(command.equals("Delete-by-id")) {

                    int id = Integer.parseInt(reader.nextLine());
                    if(allInfoStudents.containsKey(id)){
                        allInfoStudents.remove(id);
                    } else {
                        System.out.println("Student does not exist");
                    }

                } else if(command.equals("Update-by-id")) {
                    int id = Integer.parseInt(reader.nextLine());
                    String update = reader.nextLine();
                    allInfoStudents.replace(id, update);

                } else if(command.equals("Insert-student")){
                    String newStudent = reader.nextLine();
                    allInfoStudents.put(allInfoStudents.keySet().size()+1, newStudent);

                }
                command = reader.nextLine();
            }
        }



        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}