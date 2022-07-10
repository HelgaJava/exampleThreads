package ru.test.deferred;

import java.util.function.Consumer;

public interface DeferredExecutor<T> extends Consumer<T> {
    void setConsumer(Consumer<T> consumer);
    void setDelay(long delay);

    long getDelay();
    Consumer<T> getConsumer();

}
