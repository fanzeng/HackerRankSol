package practice.almostsorted;
import practice.almostsorted.Solution;
import common.SolutionTest;
import common.SolutionTestable;
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
            Solution s = new Solution();
            s.main(args);
        };
    };

    static SolutionWrap solutionWrap = new DoAllTest().new SolutionWrap();

//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test0.class})
    public static class Test0 {
        @Test
        public void test00() {
            String testIDString = "00";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };

//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test1.class})
    public static class Test1 {
        @Test
        public void test20() {
            String testIDString = "20";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test2.class})
    public static class Test2 {
        @Test
        public void test21() {
            String testIDString = "21";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test3.class})
    public static class Test3 {
        @Test
        public void test01() {
            String testIDString = "01";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test4.class})
    public static class Test4 {
        @Test
        public void test02() {
            String testIDString = "02";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
    
    //    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test5.class})
    public static class Test5 {
        @Test
        public void test24() {
            String testIDString = "24";
            String inputFileName = "src/practice/almostsorted/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/almostsorted/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
}
