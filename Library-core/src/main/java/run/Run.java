package run;

import library.Library;
import reader.Readerr;
import writer.Writerr;

public class Run {
    public static void main(String[] args) {
        Library library = new Library();
        Writerr writer = new Writerr(library, "writer 1");
        Writerr writer2 = new Writerr(library, "writer 2");
        Writerr writerr3 = new Writerr(library, "writer 3");
        Writerr writerr4 = new Writerr(library, "writer 4");
        Writerr writerr5 = new Writerr(library, "writer 5");
        Writerr writerr6 = new Writerr(library, "writer 6");
        Writerr writerr7 = new Writerr(library, "writer 7");
        Writerr writerr8 = new Writerr(library, "writer 8");
        Writerr writerr9 = new Writerr(library, "writer 9");

        Readerr reader1 = new Readerr(library, "reader 1");
        Readerr reader2 = new Readerr(library, "reader 2");
        Readerr reader3 = new Readerr(library, "reader 3");
        Readerr reader4 = new Readerr(library, "reader 4");
        Readerr reader5 = new Readerr(library, "reader 5");
        Readerr reader6 = new Readerr(library, "reader 6");


        writer.start();
        writer2.start();
        reader1.start();
        reader3.start();
        reader4.start();
        reader6.start();
        writerr3.start();
        writerr4.start();
        writerr5.start();
        writerr6.start();
        reader5.start();
        reader2.start();
        writerr7.start();
        writerr8.start();
        writerr9.start();

    }
}
