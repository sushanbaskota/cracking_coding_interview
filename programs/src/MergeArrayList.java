import java.util.ArrayList;
import java.util.List;

public class MergeArrayList {
    public static List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        int p1 = 0, p2 = 0;

        List<Integer> newList = new ArrayList<>();

        while (p1 < list1.size() && p2 < list2.size()) {
            if (list1.get(p1) < list2.get(p2)) {
                newList.add(list1.get(p1));
                p1++;
            } else {
                newList.add(list2.get(p2));
                p2++;
            }
        }

        newList.addAll(list1.subList(p1, list1.size()));
        newList.addAll(list2.subList(p2, list2.size()));

        return newList;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoList(List.of(1, 2, 4), List.of(1, 3, 4)));
        System.out.println(mergeTwoList(List.of(), List.of()));
        System.out.println(mergeTwoList(List.of(1), List.of()));
        System.out.println(mergeTwoList(List.of(), List.of(1)));
    }
}
