package common;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class SampleTest {
    SolutionTestable st;
    public SampleTest() {};

    public void testMain(SolutionTestable st, String outputFileName, String correctFileName) {
        try {
            String[] args = null;
            st.runSolution(args);
            String outFileName = outputFileName;
            System.out.println("Comparing " + outFileName + " to " + correctFileName + ":");
            File outFile = new File(outFileName);
            Scanner scOutFile = new Scanner(outFile); 
            File correctFile = new File(correctFileName);
            Scanner scCorrect = new Scanner(correctFile);
            boolean isSame = true;
            int count = 0;
            while (scOutFile.hasNextLine() && scCorrect.hasNextLine()) {
                String ourLine = scOutFile.nextLine();
                String correctLine = scCorrect.nextLine();
                    if (!ourLine.equals(correctLine)) {
                        isSame = false;
                        System.out.println("Our line:" + ourLine);
                        System.out.println("Correctline: " + correctLine);
                        break;
                    }
                count++;
                System.out.println(count + " lines are the same.");
            }
            if (scOutFile.hasNextLine() || scCorrect.hasNextLine()) isSame = false;
            if (isSame) {
                System.out.println("They are the same.");
            } else {
                System.out.println("They are different.");
            }
            assertEquals(true, isSame);
            scOutFile.close();
            scCorrect.close();
        } catch (IOException e) {
            System.err.println("IO exception when running solution.");
        }
    }
}