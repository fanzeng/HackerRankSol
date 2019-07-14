package common;
import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SampleTest {
    SolutionTestable st;
    String outCorrectFile;
    public SampleTest(String systemInRewrite, String outCorrectFile_) {
        setSystemIn(systemInRewrite);
        outCorrectFile = outCorrectFile_;
    };

    final public void setSystemIn(String systemInRewrite) {
        try {
            System.out.println("Setting System.in to " + systemInRewrite);
            System.setIn(new FileInputStream(systemInRewrite));

        } catch(IOException e) {
            System.err.println("IO exception opening input file.");
        }
    }
    
//    @Test 
//    public void outputPathEnvisSet() {
//        assertEquals(System.getenv("OUTPUT_PATH"), "out_path/out.txt");
//    }
//    
    public void testMain(SolutionTestable st, int testID) {

        try {
            String[] args = null;
            st.runMain(args);
            System.out.println("THISSS=" + System.getenv("OUTPUT_PATH"));
            File ourFile = new File("out_path/output00.txt");
            Scanner scOur = new Scanner(ourFile); 
            File correctFile = new File(outCorrectFile);
            Scanner scCorrect = new Scanner(correctFile);
            boolean isSame = true;
            int count = 0;
            while (scOur.hasNextLine() && scCorrect.hasNextLine()) {
                String ourLine = scOur.next();
                String correctLine = scCorrect.next();
                    if (!ourLine.equals(correctLine)) {
                        isSame = false;
                        System.out.println("Our line:" + ourLine);
                        System.out.println("Correctline: " + correctLine);
                        break;
                    }
                count++;
                System.out.println(count + " lines are the same.");

            }
            assertEquals(isSame, true);
            scOur.close();
            scCorrect.close();
        } catch (IOException e) {
            System.err.println("IO exception when running solution.");
        }
    }
}