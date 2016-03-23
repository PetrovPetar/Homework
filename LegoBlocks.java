import java.util.*;
import java.util.stream.Collectors;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        boolean isEqualLines = true;
        ArrayList<String[]> all = new ArrayList<>();
        int cells = 0;

        for (int i = 0; i < lines * 2; i++) {

            String[] nums = Arrays.asList(scanner.nextLine().split("\\s+"))
                    .stream().filter(str -> !str.isEmpty())
                    .collect(Collectors.toList()).toArray(new String[0]);


            cells += nums.length;
            if (i < lines) {
                all.add(nums);
            } else {
                Collections.reverse(Arrays.asList(nums));
                all.add(nums);
            }

        }

        for (int i = 0; i < all.size(); i++) {
          if(i + 1+ lines < all.size() && all.get(i).length + all.get(i+lines).length != all.get(i+1).length + all.get(i+1+lines).length){
              isEqualLines = false;
          }

        }
        if(isEqualLines == true){
            ArrayList<Integer> result = new ArrayList<>();

                for (int i = 0; i < all.size(); i++) {
                    if(i + lines < all.size()){
                        for (int j = 0; j < all.get(i).length; j++) {
                            result.add(Integer.parseInt(all.get(i)[j]));
                        }
                        for (int j = 0; j < all.get(i+lines).length; j++) {
                            result.add(Integer.parseInt(all.get(i+lines)[j]));
                        }
                        System.out.println(result);
                        result.clear();
                    }

                }


            } else {
            System.out.println("The total number of cells is: " + cells);
        }


    }
}
