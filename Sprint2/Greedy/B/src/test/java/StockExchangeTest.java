import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class StockExchangeTest {
        @Test
        public void zeroInputTest(){
            String input = "0\n";
            String result = readFromConsoleAndGetResult(input);
            String expected = "0";
            Assert.assertEquals(expected, result);
        }

    @Test
    public void oneElTest(){
        String input = "1\n5";
        String result = readFromConsoleAndGetResult(input);
        String expected = "0";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void firstExampleTest(){
        String input = "6\n" +
                "7 1 5 3 6 4";
        String result = readFromConsoleAndGetResult(input);
        String expected = "7";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void secondExampleTest(){
        String input = "5\n" +
                "1 2 3 4 5";
        String result = readFromConsoleAndGetResult(input);
        String expected = "4";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void thirdExampleTest(){
        String input = "6\n" +
                "1 12 12 16 1 8";
        String result = readFromConsoleAndGetResult(input);
        String expected = "22";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void nextDayCheaperTest(){
        String input = "6\n" +
                "10 9 8 7 4 0";
        String result = readFromConsoleAndGetResult(input);
        String expected = "0";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void maximumLoadTest(){
        StringBuilder input = new StringBuilder();
        input.append("10000\n");
        int num = 0;
        for (int i = 1; i <= 10000; i++) {
            input.append(num).append(" ");
            num = num + 1;
        }
        String result = readFromConsoleAndGetResult(input.toString());
        String expected = "9999";
        Assert.assertEquals(expected, result);
    }

    public String readFromConsoleAndGetResult(String input){
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        String[] input_arr = new String[1];
        input_arr[0] = input;
        StockExchange.main(input_arr);
        System.out.flush();
        System.setOut(old);
        String output = new String(baos.toByteArray(), Charset.defaultCharset()).trim();
        return output;
    }
}
