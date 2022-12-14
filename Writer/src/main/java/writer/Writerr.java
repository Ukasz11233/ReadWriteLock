package writer;

import library.Library;
import logs.*;
import random.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writerr extends Thread
{
    private final Logger logger = Logger.getAnonymousLogger();
    String name;
    Library library;

    public Writerr(Library lib, String name) {
        this.library = lib;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                library.enterQueue();
                Logs.info(name + " wants to enter the library.");
                library.requestWrite();
                Logs.info(name + " is WRITING.");
                Thread.sleep(2500);
                Logs.info(name + " has finished WRITING.");
                library.finishWrite();
                Thread.sleep(Random.getRandomInt(1000, 1500));
                Logs.info(name + " is leaving the library.");
                library.leaveQueue();
            } catch (InterruptedException e) {
                logger.log(Level.OFF, "catch runServer", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
