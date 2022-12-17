package reader;
import random.Random;
import library.Library;
import logs.*;
public class Readerr extends Thread {

    Library library;
    String name;

    public Readerr(Library lib, String name) {
        this.library = lib;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Logs.info(name +" is WAITING");
                library.enterQueue();
                library.requestRead();
                library.addReader();
                if (library.getNumOfReaders() == 1) {
                    library.requestWrite();
                }
                library.finishRead();

                Logs.info(name + " is READING");
                Thread.sleep(1500);
                Logs.info(name + " has FINISHED READING");

                library.requestRead();
                library.removeReader();
                if (library.getNumOfReaders() == 0) {
                    library.finishWrite();
                }
                library.finishRead();
                library.leaveQueue();
                Logs.info(name + " is LEAVING");
                Thread.sleep(Random.getRandomInt(20, 50));
            } catch (InterruptedException e) {
                Logs.info(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
