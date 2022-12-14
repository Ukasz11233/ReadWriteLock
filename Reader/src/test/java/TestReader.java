import org.junit.Before;
import org.junit.Test;
import reader.Readerr;
import library.Library;

import static org.junit.Assert.*;

public class TestReader {
    private Readerr reader;

    @Before
    public void initializeReader() {
        reader = new Readerr(new Library(), "Reader");
    }

    @Test
    public void testConstructor() {
        assertNotNull(reader);
    }
}
