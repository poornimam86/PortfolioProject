package portfolioproject.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public void executeThreads(PriceUpdater[] threads) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (PriceUpdater thread : threads) {
            executor.execute(thread);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // Wait until all tasks complete
        }

        System.out.println("\nAll stock prices updated using ExecutorService.");
    }
}