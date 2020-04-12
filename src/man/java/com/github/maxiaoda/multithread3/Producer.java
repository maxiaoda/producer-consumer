package man.java.com.github.maxiaoda.multithread3;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {
    LinkedBlockingQueue<Integer> queue;
    LinkedBlockingQueue<Integer> signalQueue;

    public Producer(LinkedBlockingQueue<Integer> queue, LinkedBlockingQueue<Integer> signalQueue) {
        this.queue = queue;
        this.signalQueue = signalQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt();
            System.out.println("Producing: " + r);

            try {
                queue.put(r);
                signalQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
