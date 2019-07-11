package practice.thebombermangame;
import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test 
    public void outputPathEnvisSet() {
        assertEquals(System.getenv("OUTPUT_PATH"), "out_path/out.txt");
    }
    
    @Test
    public void testMain() {
        try {
            System.setIn(new FileInputStream("src/practice/thebombermangame/input/input00.txt"));
        } catch(IOException e) {
            System.err.println("IO exception opening input file.");
        }
        try {
            Solution s = new Solution();
            String[] args = null;
            s.main(args);
            File ourFile = new File("out_path/out.txt");
            Scanner scOur = new Scanner(ourFile); 
            File correctFile = new File("src/practice/thebombermangame/output/output00.txt");
            Scanner scCorrect = new Scanner(correctFile);
            boolean isSame = true;
            int count = 0;
            while (scOur.hasNextLine() && scCorrect.hasNextLine()) {
                System.out.println(count + " lines are the same.");
                String ourLine = scOur.next();
                String correctLine = scCorrect.next();
                    if (!ourLine.equals(correctLine)) {
                        isSame = false;
                        System.out.println(ourLine);
                        System.out.println(correctLine);
                        break;
                    }
            }
            assertEquals(isSame, true);
            scOur.close();
            scCorrect.close();
        } catch (IOException e) {
            System.err.println("IO exception when running solution.");
        }
    }
}