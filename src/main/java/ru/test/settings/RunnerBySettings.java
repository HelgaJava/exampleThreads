package ru.test.settings;

import ru.test.deferred.DeferredExecutor;

import java.util.function.Consumer;

public class RunnerBySettings implements Runnable {
    private final DeferredExecutor<String> executor;
    private long delay;
    private Consumer<String> consumer;
    public RunnerBySettings(DeferredExecutor<String> executor, long delay, Consumer<String> consumer) {
        this.executor = executor;
        this.delay = delay;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (executor){
                executor.setConsumer(consumer);
                executor.setDelay(delay);
                executor.accept("hello!"+"Индекс: "+i+" "+Thread.currentThread().getName());
            }
        }

    }
}
