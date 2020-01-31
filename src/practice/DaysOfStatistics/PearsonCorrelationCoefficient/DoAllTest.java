package practice.DaysOfStatistics.PearsonCorrelationCoefficient;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class DoAllTest {
    @Test
    public void test0() {
        String data = "10\n"
                      + "10 9.8 8 7.8 7.7 7 6 5 4 2 \n"
                      + "200 44 32 24 22 17 15 12 8 4";
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
            String correctString = "0.612";
            assertEquals(correctString, baos.toString());
        } finally {
          System.setIn(stdin);
          System.setOut(old);
        }
    }

}
    
    