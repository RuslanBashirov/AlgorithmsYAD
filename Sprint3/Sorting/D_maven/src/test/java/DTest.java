import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class DTest {
    @Test
    public void exampleTest1(){
        String[] input = {"3\n" +
                "5\n" +
                "4 9 5\n" +
                "9 4 9 8 4"};
        String output = readFromConsoleAndGetResult(input[0]);
        String expected = "4 9";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void firstAttemptTest1(){
        String[] input = {"3\n" +
                "5\n" +
                "3 4 5\n" +
                "1 1 1 1 5"};
        String output = readFromConsoleAndGetResult(input[0]);
        String expected = "5";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void secondAttemptTest1(){
        String[] input = {"3\n" +
                "0\n" +
                "1 2 3"};
        String output = readFromConsoleAndGetResult(input[0]);
        String expected = "";
        Assert.assertEquals(expected, output);
    }

    public String readFromConsoleAndGetResult(String input){
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        String[] input_arr = new String[1];
        input_arr[0] = input;
        D_maven.main(input_arr);
        System.out.flush();
        System.setOut(old);
        String output = new String(baos.toByteArray(), Charset.defaultCharset()).trim();
        return output;
    }

}
