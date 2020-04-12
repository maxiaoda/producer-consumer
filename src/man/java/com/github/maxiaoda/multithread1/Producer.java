package man.java.com.github.maxiaoda.multithread1;

import java.util.Optional;
import java.util.Random;

public class Producer extends Thread {
    private Container container;
    private Object lock;

    public Producer(Container container, Object lock) {
        this.container = container;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            synchronized (lock) {
                while (container.getValue().isPresent()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int r = new Random().nextInt();
                System.out.println("Producing: " + r);
                container.setValue(Optional.of(r));

                lock.notify();
            }
        }
    }
}
