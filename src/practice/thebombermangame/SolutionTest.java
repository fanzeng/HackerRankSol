package practice.thebombermangame;

import common.*;
import java.io.*;

import org.powermock.api.mockito.PowerMockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.mockito.Mockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Solution.class})
public class SolutionTest {
    public SolutionTest() {};
    class SolutionWrap implements SolutionTestable {
        Solution s = new Solution();
        public void runMain(String[] args) {
            try {
                s.main(args);
            } catch(IOException e) {
                System.err.println("Caught IOException in SolutionTest. " + e.getMessage());
            }
        };
    };
    
    SampleTest st; 
    SolutionWrap sw;
    
    
    String testIDString = "00";

//    @Rule
//    public EnvironmentVariables environmentVariables = new EnvironmentVariables().set("OUTPUT_PATH", "out_path/output" + testIDString + ".txt");

   
    @Test
    public void test0() {
        
                    PowerMockito.mockStatic(System.class);
        String outFileString = "out_path/output" + testIDString + ".txt";
        PowerMockito.when(System.getenv(Mockito.eq("OUTPUT_PATH"))).thenReturn(outFileString);
//        PowerMockito.when(System.getProperty(Mockito.any())).thenCallRealMethod();

        assertEquals(System.getenv("OUTPUT_PATH"), outFileString);
        
        st = new SampleTest("src/practice/thebombermangame/input/input" + testIDString + ".txt", 
                "src/practice/thebombermangame/output/output" + testIDString + ".txt");
        sw = new SolutionWrap();
        st.testMain(sw, 0);
        assertEquals(System.getenv("OUTPUT_PATH"), outFileString);

    }
    
    
//    
//    @Rule
//    public EnvironmentVariables environmentVariables1 = new EnvironmentVariables().set("OUTPUT_PATH", "out_path/output25.txt");
//       
        
//    @Test 
//    public void outputPathEnvisSet() {
//        assertEquals(System.getenv("OUTPUT_PATH"), "out_path/output25.txt");
//    }
//    @Test
//    public void test1() {
//        st = new SampleTest("src/practice/thebombermangame/input/input25.txt", "src/practice/thebombermangame/output/output25.txt");
//        sw = new SolutionWrap();
//        st.testMain(sw, 1);
//    }

};