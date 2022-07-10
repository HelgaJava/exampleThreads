package ru.test.settings;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValueSettings {
    private static Scanner scanner = new Scanner(System.in);
    public static long getValueDelay() {
        long value = 0;
        if (scanner.hasNextLong()) {
            value = scanner.nextLong();
        }
        return value;
    }
    public static Consumer<String> getConsumer() {
        Consumer<String> consumer1 = s -> System.out.println(s.toUpperCase());
        Consumer<String> consumer2 = s -> System.out.println(s.toLowerCase());
        Consumer<String> consumer3 = s -> System.out.println("Длина строки: " + s.length());
        Stream<Consumer<String>> consumerStream = Stream.of(consumer1, consumer2, consumer3);
        List<Consumer> consumers = new ArrayList<>(consumerStream.collect(Collectors.toList()));
        int index = 0;
        if (scanner.hasNextInt()) {
            index = scanner.nextInt();
        }
        return consumers.get(index > consumers.size() ? 0 : index);
    }

}

