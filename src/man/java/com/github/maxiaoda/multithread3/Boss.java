package man.java.com.github.maxiaoda.multithread3;

import java.util.concurrent.LinkedBlockingQueue;

public class Boss {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        LinkedBlockingQueue<Integer> signalQueue = new LinkedBlockingQueue<>(1);

        Producer producer = new Producer(signalQueue, queue);
        Consumer consumer = new Consumer(signalQueue, queue);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
