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
                library.enterQueue( true);
                library.requestWrite();
                library.leaveQueue(this, true);
                library.addWriter();

                Logs.info(name + " is writing.");
                Thread.sleep(2500);
                library.finishWrite();
                library.removeWriter();


                Thread.sleep(Random.getRandomInt(1000, 1500));
            } catch (InterruptedException e) {
                logger.log(Level.OFF, "catch runServer", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
