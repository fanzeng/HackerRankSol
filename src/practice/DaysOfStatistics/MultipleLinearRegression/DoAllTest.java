package practice.DaysOfStatistics.MultipleLinearRegression;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertEquals;

public class DoAllTest {
    @Test
    public void test0() {
        String data = "2 7\n"
            + "0.18 0.89 109.85\n"
            + "1.0 0.26 155.72\n"
            + "0.92 0.11 137.66\n"
            + "0.07 0.37 76.17\n"
            + "0.85 0.16 139.75\n"
            + "0.99 0.41 162.6\n"
            + "0.87 0.47 151.77\n"
            + "4\n"
            + "0.49 0.18\n"
            + "0.57 0.83\n"
            + "0.56 0.64\n"
            + "0.76 0.18\n";
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
            String correctString = "105.21\n142.67\n132.94\n129.70\n";
            assertEquals(correctString, baos.toString());
        } finally {
          System.setIn(stdin);
          System.setOut(old);
        }
    }

}
    
    