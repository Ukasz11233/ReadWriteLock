package library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Library {
    private final ExecutorService service;
    private final MySemaphore readWriteLock;
    private final MySemaphore queueLock;
    private int numOfReaders;


    public Library() {
        readWriteLock = new MySemaphore(1, 1);
        queueLock = new MySemaphore(1, 1);
        service = Executors.newFixedThreadPool(5);
        numOfReaders = 0;
    }

    public void execute(Thread thread) {
        service.execute(thread);
    }

    public void enterQueue() throws InterruptedException
    {
        queueLock.acquire();
    }

    public void leaveQueue() throws InterruptedException
    {
        queueLock.release();
    }
    public void requestRead() throws InterruptedException {
        readWriteLock.acquire(true);
    }

    public void finishRead() throws InterruptedException {
        readWriteLock.release(true);
    }

    public void requestWrite() throws InterruptedException {
        readWriteLock.acquire(false);
    }

    public void finishWrite() throws InterruptedException {
        readWriteLock.release(false);
    }

    public void closeLibrary() {
        service.shutdown();
    }

    public void addReader() {
        numOfReaders++;
    }

    public void removeReader() {
        numOfReaders--;
    }

    public int getNumOfReaders() {
        return numOfReaders;
    }
}
