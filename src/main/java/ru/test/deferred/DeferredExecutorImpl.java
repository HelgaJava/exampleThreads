package ru.test.deferred;

import java.util.function.Consumer;

public class DeferredExecutorImpl<T> implements DeferredExecutor<T> {
    private Consumer<T> consumer;
    private long delay;
    @Override
    public void setConsumer(Consumer<T> consumer) {
        this.consumer = consumer;
    }
    @Override
    public void setDelay(long delay) {
        this.delay = delay;
    }
    @Override
    public long getDelay() {
        return delay;
    }
    @Override
    public Consumer<T> getConsumer() {
        return consumer;
    }

    @Override
    public void accept(T t) {
        try {
            Thread.sleep(delay);
            consumer.accept(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
