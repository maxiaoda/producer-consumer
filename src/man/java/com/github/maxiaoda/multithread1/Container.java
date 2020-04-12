package man.java.com.github.maxiaoda.multithread1;

import java.util.Optional;

public class Container {
    private Optional<Integer> value = Optional.empty();

    public Optional<Integer> getValue() {
        return value;
    }

    public void setValue(Optional<Integer> value) {
        this.value = value;
    }
}
