import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    private static final Long TIMEOUT = 450L;   //milisegundos


    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int num = (int) (Math.random() * 100);
                boolean sucessful = queue.offer(num);
                if(!sucessful) {
                    Thread.sleep(TIMEOUT);
                }

                System.out.println("--> Produced " + num);

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
