package library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Library {
    private final ExecutorService service;
    private final Semaphore queueLock;
    private final Semaphore readLock;
    private final Semaphore writeLock;
    private int numOfReaders;


    public Library() {
        queueLock = new Semaphore(1);
        readLock = new Semaphore(1);
        writeLock = new Semaphore(1);
        service = Executors.newFixedThreadPool(5);
        numOfReaders = 0;
    }

    public void execute(Thread thread) {
        service.execute(thread);
    }
    public void requestRead() throws InterruptedException {
        readLock.acquire();
    }

    public void enterQueue() throws InterruptedException{
        queueLock.acquire();
    }

    public void leaveQueue(){
        queueLock.release();
    }
    public void finishRead(){
        readLock.release();
    }

    public void requestWrite() throws InterruptedException {
        writeLock.acquire();
    }

    public void finishWrite(){
        writeLock.release();
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
