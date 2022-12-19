package library;
import logs.*;
import java.util.LinkedList;
import java.util.Queue;

public class MySemaphore {
        private int semaphore;
        private int numberOfReaders;
        private int numberOfWriters;
        Queue<Thread> queue = new LinkedList<>();
        public MySemaphore(int initialValue){
            this.semaphore = initialValue;
            numberOfWriters = 0;
            numberOfReaders = 0;
        }


        public synchronized void release(Thread thread, boolean isWriter){
            addToQueue(isWriter, true);
            Logs.debug(status());
            semaphore--;
            if(semaphore < 0)
            {
                queue.add(thread);
                thread.start();
            }
        }

        public synchronized void acquire(boolean isWriter) {
            addToQueue(isWriter, false);
            Logs.debug(status());
            semaphore++;
            if(semaphore <= 0)
            {
                queue.poll();
                while(semaphore <= 0);
            }
        }

        private void addToQueue(boolean isWriter, boolean isLeaving)
        {
            if(isWriter)
            {
                numberOfWriters += isLeaving ? -1 : 1;
            }
            else {
                numberOfReaders += isLeaving ? -1 : 1;
            }

        }

    private String status() {
            return "Number of readers/writers in queue: " + numberOfReaders + " / " + numberOfWriters;
    }
}
