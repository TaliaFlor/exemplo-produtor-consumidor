import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private static final Long TIMEOUT = 500L;   //milisegundos
    private final BlockingQueue<Integer> queue;


    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                if (queue.remainingCapacity() == 5) {
                    System.out.println("*** [Wait] Queue vazia ***");
                    Thread.sleep(TIMEOUT);
                }
                int num = queue.poll();

                System.out.println("<-- Consumed " + num);

                Thread.sleep(TIMEOUT);

                if (queue.remainingCapacity() <= 3) {
                    System.out.println("========== Queue ==========");
                    System.out.println("\t" + queue);
                    System.out.println("===========================");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
    }

}
