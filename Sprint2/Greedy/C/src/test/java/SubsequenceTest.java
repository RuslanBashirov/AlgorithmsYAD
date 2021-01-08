import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class SubsequenceTest {
    @Test
    public void zeroInputTest() throws IOException {
        String input = "";
        String output = readFromConsoleAndGetResult(input);
        String expected = "";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void maximumLoadTest() throws IOException {
        String input = "";
        String output = readFromConsoleAndGetResult(input);
        String expected = "";
        Assert.assertEquals(expected, output);
    }

    public String readFromConsoleAndGetResult(String input) throws IOException {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        String[] input_arr = new String[1];
        input_arr[0] = input;
        Subsequence.main(input_arr);
        System.out.flush();
        System.setOut(old);
        String output = new String(baos.toByteArray(), Charset.defaultCharset()).trim();
        return output;
    }
}
