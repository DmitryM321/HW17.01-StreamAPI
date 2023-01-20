import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,  //
            Comparator<? super T> order,  //
            BiConsumer<? super T, ? super T> minMaxConsumer) {     //
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        T min = list.get(0);
        T max = list.get(list.size() - 1);
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }
    }
    // findMinMax(stream, order, minMaxConsumer)

    public static void makeMethod2(List<Integer> list) {
        System.out.println("Четных " + list.stream().filter(i -> i %2 ==0).count());
    }
    public static void main(String[] args) {
        System.out.println("Задание 1");

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(12);
        list.add(11);
        list.add(54);
        list.add(555);

        Stream<Integer> stream = list.stream();
        Comparator<Integer> comparator = Integer::compareTo;
        BiConsumer<Integer, Integer> biConsumer = (integer, integer2) -> {
            System.out.println("Min " + integer);
            System.out.println("Min " + integer2);
        };
        findMinMax(stream, comparator, biConsumer);
        System.out.println("Задание 2");
        makeMethod2(list);
    }
}




