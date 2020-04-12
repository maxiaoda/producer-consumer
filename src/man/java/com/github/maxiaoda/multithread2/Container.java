package man.java.com.github.maxiaoda.multithread2;

import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
    private Condition notConsumedYet;
    private Condition notProducedYet;
    private Optional<Integer> value = Optional.empty();

    public Container(ReentrantLock lock) {
        this.notConsumedYet = lock.newCondition();
        this.notProducedYet = lock.newCondition();
    }

    public Condition getNotConsumedYet() {
        return notConsumedYet;
    }

    public void setNotConsumedYet(Condition notConsumedYet) {
        this.notConsumedYet = notConsumedYet;
    }

    public Condition getNotProducedYet() {
        return notProducedYet;
    }

    public void setNotProducedYet(Condition notProducedYet) {
        this.notProducedYet = notProducedYet;
    }

    public Optional<Integer> getValue() {
        return value;
    }

    public void setValue(Optional<Integer> value) {
        this.value = value;
    }
}
