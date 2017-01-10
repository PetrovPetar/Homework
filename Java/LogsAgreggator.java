import java.util.*;

public class LogsAgreggator {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Integer lines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Person> users = new TreeMap<>();


        for (int i = 0; i < lines; i++) {
        String [] line = scanner.nextLine().split("\\s+");
        String ip = line[0];
        String name = line[1];
        int duration = Integer.parseInt(line[2]);

            if(!users.containsKey(name)){
                Person person = new Person(new HashSet<>(),new ArrayList<Integer>());
                person.duration.add(duration);
                person.ip.add(ip);

                users.put(name, person);

            } else {

                users.get(name).ip.add(ip);
                users.get(name).duration.add(duration);
            }
        }

        for (Map.Entry<String, Person> user:users.entrySet()) {
            int sumOfDuration = 0;
            for (Integer valueIp : user.getValue().duration) {
                sumOfDuration += valueIp;
            }
            ArrayList <String> str = new ArrayList<>(user.getValue().ip);
            Collections.sort(str);
            System.out.println(user.getKey() + ": " + sumOfDuration + " " + str);
        }

    }
    private static class Person{
        HashSet<String> ip;
        ArrayList<Integer> duration;
        Person(HashSet<String> ip, ArrayList<Integer> duration){
            this.ip = ip;
            this.duration = duration;
        }
    }
}
