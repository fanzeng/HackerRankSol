package practice.DaysOfStatistics.Quartiles;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class DoAllTest {
    @Test
    public void test0() {
        String data = "9\n3 7 8 5 12 14 21 13 18";
        InputStream stdin = System.in;
        PrintStream old = System.out;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            Solution s = new Solution();
            s.main(new String[0]);
            System.out.flush();
            String correctString = "6\n12\n16";
            assertEquals(correctString, baos.toString());
        } finally {
          System.setIn(stdin);
          System.setOut(old);
        }
    }
    @Test
    public void test1() {
        String data = "10\n3 7 8 5 12 14 21 15 18 14";
        InputStream stdin = System.in;
        PrintStream old = System.out;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            Solution s = new Solution();
            s.main(new String[0]);
            System.out.flush();
            String correctString = "7\n13\n15";
            assertEquals(correctString, baos.toString());
        } finally {
          System.setIn(stdin);
          System.setOut(old);
        }
    }
}
    
    