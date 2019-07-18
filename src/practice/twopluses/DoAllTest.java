package practice.twopluses;
import practice.thebombermangame.*;
import common.SolutionTest;
import common.SolutionTestable;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.experimental.runners.Enclosed;
import org.junit.Ignore;

@RunWith(Enclosed.class)
public class DoAllTest {
    class SolutionWrap implements SolutionTestable {
        public void runSolution(String[] args) {
            try {
                Solution s = new Solution();
                s.main(args);
            } catch(IOException e) {
                System.err.println("Caught IOException in SolutionWrap.runMain(). " + e.getMessage());
            }
        };
    };

    static SolutionWrap solutionWrap = new DoAllTest().new SolutionWrap();
    
//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test0.class})
    public static class Test0 {
        @Test
        public void test0() {
            String testIDString = "00";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };

//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test1.class})
    public static class Test1 {
        @Test
        public void test1() {
            String testIDString = "01";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };

//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test2.class})
    public static class Test2 {
        @Test
        public void test2() {
            String testIDString = "02";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test3.class})
    public static class Test3 {
        @Test
        public void test3() {
            String testIDString = "03";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test4.class})
    public static class Test4 {
        @Test
        public void test4() {
            String testIDString = "04";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test5.class})
    public static class Test5 {
        @Test
        public void test5() {
            String testIDString = "05";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test6.class})
    public static class Test6 {
        @Test
        public void test6() {
            String testIDString = "06";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test7.class})
    public static class Test7 {
        @Test
        public void test7() {
            String testIDString = "07";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };   
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test8.class})
    public static class Test8 {
        @Test
        public void test8() {
            String testIDString = "08";
            String inputFileName = "src/practice/twopluses/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/twopluses/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };   
}
