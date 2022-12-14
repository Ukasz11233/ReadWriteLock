import org.junit.Before;
import org.junit.Test;
import library.Library;
import writer.Writerr;
import static org.junit.Assert.*;

public class TestWriter {
    private Writerr writer;
    private final static Library library = new Library();

    @Before
    public void initializeWriter() {
        writer = new Writerr(library, "George Orwell");
    }

    @Test
    public void testConstructor() {
       assertNotNull(writer);
    }
}
