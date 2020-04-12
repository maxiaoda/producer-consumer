package man.java.com.github.maxiaoda.multithread3;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread {
    LinkedBlockingQueue<Integer> queue;
    LinkedBlockingQueue<Integer> signalQueue;

    public Consumer(LinkedBlockingQueue<Integer> queue, LinkedBlockingQueue<Integer> signalQueue) {
        this.queue = queue;
        this.signalQueue = signalQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Consuming: " + queue.take());
                signalQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
