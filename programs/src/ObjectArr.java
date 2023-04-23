import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ObjectArr {
    static class Person {
        String name;
        String id;

        public Person(String name, String id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person {" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        queue.
                Person[] personArr = new Person[5];

        personArr[0] = new Person("sushan", "1");
        personArr[1] = new Person("sangi", "2");
        personArr[2] = new Person("saskar", "3");
        personArr[3] = new Person("sasku", "4");
        personArr[4] = new Person("subham", "5");

        System.out.println(Arrays.toString(personArr));
    }
}
