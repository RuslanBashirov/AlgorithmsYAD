import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

public class ATest {
    @Test
    public void shouldCutZeros(){
        String[] input = {"3\n" +
                "9 10\n" +
                "11 12.25\n" +
                "12.15 13.3"};
        String output = readFromConsoleAndGetResult(input[0]);
        String expected = "2\n" +
                "9 10\n" +
                "11 12.25";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void thousandOfTests(){
        for (int i = 0; i < 1000; i++) {
            String[] input = {"3\n" +
                    "9 10\n" +
                    "11 12.25\n" +
                    "12.15 13.3"};
            String output = readFromConsoleAndGetResult(input[0]);
            String expected = "2\n" +
                    "9 10\n" +
                    "11 12.25";
            Assert.assertEquals(expected, output);
        }
    }

    @Test
    public void zeroContinTest(){
            String[] input = {"3\n" +
                    "8 8.5\n" +
                    "8.5 8.5\n" +
                    "8.5 9"};
            String output = readFromConsoleAndGetResult(input[0]);
            String expected = "3\n" +
                    "8 8.5\n" +
                    "8.5 8.5\n" +
                    "8.5 9";
            Assert.assertEquals(expected, output);
    }

    @Test
    public void crossSectionWithZeroTest(){
            String[] input = {"2\n" +
                    "20 20\n" +
                    "19 20"};
            String output = readFromConsoleAndGetResult(input[0]);
            String expected = "2\n" +
                    "20 20\n" +
                    "19 20";
            Assert.assertEquals(expected, output);
    }



    public String readFromConsoleAndGetResult(String input){
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        String[] input_arr = new String[1];
        input_arr[0] = input;
        A.main(input_arr);
        System.out.flush();
        System.setOut(old);
        String output = new String(baos.toByteArray(), Charset.defaultCharset()).trim();
        return output;
    }
}
