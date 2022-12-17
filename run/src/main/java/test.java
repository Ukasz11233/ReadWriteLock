import library.Library;
import reader.Readerr;
import writer.Writerr;

public class test {
    public static void main(String[] args) {
        Library library = new Library();
        Writerr writer = new Writerr(library, "writer 1");
        Writerr writer2 = new Writerr(library, "writer 2");
        Writerr writerr3 = new Writerr(library, "writer 3");
        Writerr writerr4 = new Writerr(library, "writer 4");
        Writerr writerr5 = new Writerr(library, "writer 5");
        Writerr writerr6 = new Writerr(library, "writer 6");

        Readerr reader1 = new Readerr(library, "reader 1");
        Readerr reader2 = new Readerr(library, "reader 2");
//        Readerr reader3 = new Readerr(library, "reader 3");
//        Readerr reader4 = new Readerr(library, "reader 4");
//        Readerr reader5 = new Readerr(library, "reader 5");
//        Readerr reader6 = new Readerr(library, "reader 6");


        library.execute(writer);
        library.execute(reader1);
        library.execute(reader2);
//        library.execute(reader3);
//        library.execute(reader4);
//        library.execute(reader5);
//        library.execute(reader6);
        library.execute(writer2);
        library.execute(writerr3);
        library.execute(writerr4);
        library.execute(writerr5);
        library.execute(writerr6);
        library.closeLibrary();
    }
}
