package ru.test;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.test.settings.RunnerBySettings;
import ru.test.deferred.DeferredExecutor;
import ru.test.deferred.DeferredExecutorImpl;

import java.util.function.Consumer;

import static org.junit.Assert.*;

public class DeferredExecutorImplTest {
    static DeferredExecutor<String> executor;
    static Consumer<String> consumerStart;
    static long delayStart;

    @BeforeClass
    public static void setUp() {
        executor = new DeferredExecutorImpl<>();
        Consumer<String> consumer = s -> System.out.println("Длина строки: " + s.length());
        for (int i = 0; i < 5; i++) {
            executor.setConsumer(consumer);
            executor.setDelay(1000);
            executor.accept("hello!");
        }
        consumerStart = executor.getConsumer();
        delayStart = executor.getDelay();
    }

    @Test
    public void compareValues() throws InterruptedException {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        Thread thread = new Thread(new RunnerBySettings(executor, 1500, consumer), "New Thread");
        thread.start();
        thread.join();
        assertNotEquals(consumerStart, executor.getConsumer());
        assertNotEquals(delayStart, executor.getDelay());
    }
}