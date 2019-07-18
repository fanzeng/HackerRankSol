package practice.larrysarray;
import practice.larrysarray.Solution;
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
            } catch (IOException e) {
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
        public void test00() {
            String testIDString = "00";
            String inputFileName = "src/practice/larrysarray/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/larrysarray/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };

//    @Ignore
    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test1.class})
    public static class Test1 {
        @Test
        public void test21() {
            String testIDString = "21";
            String inputFileName = "src/practice/larrysarray/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/larrysarray/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            solutionTest.mockSystemAndTest(solutionWrap);
        }
    };
}
