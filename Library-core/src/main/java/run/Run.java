package run;

import library.Library;
import logs.Logs;
import reader.Readerr;
import writer.Writerr;

import java.util.ArrayList;

public class Run {

    private static Library library = new Library();
    private static int writerIdx = 0;
    private static int readerIdx = 0;

    private static ArrayList<Writerr> writers = new ArrayList<>();
    private static ArrayList<Readerr> readers = new ArrayList<>();

    private static void InitializeReadersAndWriters(){
        for(int i = 0 ; i < 20; ++i) {
            writers.add(new Writerr(library, "writer " + writerIdx++));
            readers.add(new Readerr(library, "reader " + readerIdx++));
        }
    }
    public static void main(String[] args) {
        InitializeReadersAndWriters();
        if (args.length < 2) {
            Logs.info("Please enter number of readers and writers");
        } else if (args.length == 2) {

            for(int i = 0 ; i< Integer.parseInt(args[1]); ++i) {
                writers.get(i).start();
            }

            for(int i = 0; i < Integer.parseInt(args[0]); ++i) {
                readers.get(i).start();
            }
        }
    }

}
