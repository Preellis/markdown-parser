import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks0() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"),
            links);
    }
    @Test
    public void testGetLinks1() throws IOException{
        Path fileName = Path.of("break-test.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("some-thing.html"), links);
    }
    @Test
    public void testGetLinks2() throws IOException{
        Path fileName = Path.of("break-test2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }
    @Test
    public void testGetLinks3() throws IOException{
        Path fileName = Path.of("break-test3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }
    @Test
    public void testGetLinks4() throws IOException{
        Path fileName = Path.of("break-test4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("some-stuff.html"), links);
    }
    @Test
    public void testGetLinks5() throws IOException{
        Path fileName = Path.of("test4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("hi"), links);
    }
}
