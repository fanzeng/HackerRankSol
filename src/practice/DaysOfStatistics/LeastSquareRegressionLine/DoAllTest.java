package practice.DaysOfStatistics.LeastSquareRegressionLine;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class DoAllTest {
    @Test
    public void test0() {
        String data = "95 85\n"
                + "85 95\n"
                + "80 70\n"
                + "70 65\n"
                + "60 70";
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
            String correctString = "78.288";
            assertEquals(correctString, baos.toString());
        } finally {
          System.setIn(stdin);
          System.setOut(old);
        }
    }

}
    
    