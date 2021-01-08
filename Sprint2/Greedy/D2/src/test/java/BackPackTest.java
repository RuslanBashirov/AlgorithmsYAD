import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class BackPackTest {
    @Test
    public void zeroInputTest(){
        String input = "0\n0";
        String result = readFromConsoleAndGetResult(input);
        String expected = "";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void nothingToTakeTest(){
        String input = "123\n" +
                "3\n" +
                "25 500\n" +
                "30 400\n" +
                "30 800\n";
        String result = readFromConsoleAndGetResult(input);
        String expected = "";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void zeroVolumeTest(){
        String input = "0\n" +
                "3\n" +
                "25 50\n" +
                "30 40\n" +
                "30 80\n";
        String result = readFromConsoleAndGetResult(input);
        String expected = "";
        Assert.assertEquals(expected, result);
    }

    public String readFromConsoleAndGetResult(String input){
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        String[] input_arr = new String[1];
        input_arr[0] = input;
        BackPack.main(input_arr);
        System.out.flush();
        System.setOut(old);
        String output = new String(baos.toByteArray(), Charset.defaultCharset()).trim();
        return output;
    }
}