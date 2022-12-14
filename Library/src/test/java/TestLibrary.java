import library.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestLibrary {
    private Library library;

    @Before
    public void initializeLibrary() {
        library = new Library();
    }


    @Test
    public void testRemoveReader() {
        library.removeReader();
        library.removeReader();
        library.removeReader();
        library.removeReader();
        library.removeReader();
        library.removeReader();
        library.removeReader();
        final int expectedResult = -7;
        assertEquals(expectedResult, library.getNumOfReaders());
    }

    @Test
    public void testAddReader() {
        library.addReader();
        library.addReader();
        library.addReader();
        library.addReader();
        library.addReader();
        final int expectedResult = 5;
        assertEquals(expectedResult, library.getNumOfReaders());
    }
}
