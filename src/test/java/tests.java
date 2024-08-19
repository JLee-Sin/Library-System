import com.example.librarysystem.Book;
import com.example.librarysystem.Library;
import com.example.librarysystem.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class tests {

    @Test
    public void saveTest() {
        Library lib = new Library();
        lib.addBook(new Book("test", "author", Status.Wishlist, 5.0, new ArrayList<String>(), ""));
        lib.saveLibrary();
    }

    @Test
    public void loadTest() {
        Library lib = new Library();
        Assert.assertFalse(lib.getLibrary().isEmpty());
        Assert.assertEquals(lib.getBook("test").getTitle(), "test");
        Assert.assertEquals(lib.getBook("test").getAuthor(), "author");
    }
}
