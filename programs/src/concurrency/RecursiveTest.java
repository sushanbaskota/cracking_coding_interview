package concurrency;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        dib(3, list);
        System.out.println(list);
    }

    public static void dib(int n, List<Integer> list) {
        list.add(n);

        if (n <= 1) {
            return;
        }

        dib(n - 1, list);
        dib(n - 1, list);
    }
}
