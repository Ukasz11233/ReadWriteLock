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
                Logs.info(name + " wants to enter the library.");
                library.enterQueue();
                library.requestWrite();
                Logs.info(name + " is WRITING.");
                Thread.sleep(2500);
                Logs.info(name + " has finished WRITING.");
                library.finishWrite();
                library.leaveQueue();
                Thread.sleep(Random.getRandomInt(100, 150));
                Logs.info(name + " is leaving the library.");
            } catch (InterruptedException e) {
                logger.log(Level.OFF, "catch runServer", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
