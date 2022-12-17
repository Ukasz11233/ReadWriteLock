package library;


import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MySemaphore {

        Queue<Thread> queue = new ArrayDeque<>();
        private int initialValue = 0;
        private int bound = 0;

        public MySemaphore(int initialValue,int upperBound){
            this.bound = upperBound;
            this.initialValue = initialValue;
        }


        public void release() throws InterruptedException{
            initialValue++;
            if(initialValue <= 0) {
                Thread tmp = queue.remove();
                tmp.run();
            }
        }

        public synchronized void acquire(Thread thread) throws InterruptedException{
            this.initialValue--;
            if (initialValue < 0) {
                queue.add(thread);
                thread.wait();
            }
        }
}
