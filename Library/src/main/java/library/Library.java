package library;

import java.util.concurrent.Semaphore;

public class Library {


    private final MySemaphore queueLock;
    private final Semaphore readLock;
    private final Semaphore writeLock;
    private int numOfReaders;

    private int numOfWriters;


    public Library() {
        queueLock = new MySemaphore(1);
        readLock = new Semaphore(1);
        writeLock = new Semaphore(1);
        numOfReaders = 0;
        numOfWriters = 0;
    }

    public void requestRead() throws InterruptedException {
        readLock.acquire();
    }

    public void enterQueue(boolean isWriter) {
        queueLock.acquire(isWriter);
    }

    public void leaveQueue(Thread thread, boolean isWriter) {
        queueLock.release(thread, isWriter);
    }
    public void finishRead(){
        readLock.release();
    }

    public void requestWrite() throws InterruptedException {
        writeLock.acquire();
    }

    public void finishWrite() {
        writeLock.release();
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

    public void addWriter() {numOfWriters++;}
    public void removeWriter() {numOfWriters--;}

    public String toString()
    {
        return "Number of readers/writers: " + numOfReaders + " / " + numOfWriters;
    }
}
