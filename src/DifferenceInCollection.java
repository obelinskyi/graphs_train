import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DifferenceInCollection {

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        List<Integer> missed = new ArrayList<>(arr1);
//        missed.contains()
        missed.removeAll(arr2);
        arr2.removeAll(arr1);
        System.out.println(missed);
        System.out.println(arr2);
    }

}
