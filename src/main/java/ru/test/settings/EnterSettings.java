package ru.test.settings;

import ru.test.deferred.DeferredExecutor;
import ru.test.deferred.DeferredExecutorImpl;

import java.util.function.Consumer;

public class EnterSettings {

    public static void start() {
        final DeferredExecutor<String> executor = new DeferredExecutorImpl<>();

        System.out.println("Enter delay for thread1: ");
        long delay1 = ValueSettings.getValueDelay();

        System.out.println("Enter index consumer for thread1: ");
        Consumer<String> consumer1 = ValueSettings.getConsumer();

        System.out.println("Enter delay for thread2: ");
        long delay2 = ValueSettings.getValueDelay();

        System.out.println("Enter index consumer for thread2: ");
        Consumer<String> consumer2 = ValueSettings.getConsumer();

        Thread thread1 = new Thread(new RunnerBySettings(executor, delay1, consumer1), "Thread1");
        thread1.start();

        Thread thread2 = new Thread(new RunnerBySettings(executor, delay2, consumer2), "Thread2");
        thread2.start();
    }
}
