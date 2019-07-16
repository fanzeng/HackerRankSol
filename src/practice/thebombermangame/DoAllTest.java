package practice.thebombermangame;
import common.SolutionTest;
import common.SolutionTestable;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class DoAllTest {
    public DoAllTest(){}
    class SolutionWrap implements SolutionTestable {
        public void runMain(String[] args) {
            try {
                Solution s = new Solution();
                s.main(args);
            } catch(IOException e) {
                System.err.println("Caught IOException in SolutionWrap.runMain(). " + e.getMessage());
            }
        };
    };

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test1.class})
    public static class Test1{
        @Test
        public void test1() {
            String testIDString = "00";
            String inputFileName = "src/practice/thebombermangame/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/thebombermangame/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            DoAllTest doAllTest = new DoAllTest();
            SolutionWrap solutionWrap = doAllTest.new SolutionWrap();
            solutionTest.doTest(solutionWrap);
        }
    };

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({Solution.class, SolutionTest.class, Test2.class})
    public static class Test2{
        @Test
        public void test2() {
            String testIDString = "25";
            String inputFileName = "src/practice/thebombermangame/input/input" + testIDString + ".txt";
            String outputFileName = "out_path/output" + testIDString  + ".txt";
            String correctFileName = "src/practice/thebombermangame/output/output" + testIDString + ".txt";
            SolutionTest solutionTest = new SolutionTest(inputFileName, outputFileName, correctFileName);
            SolutionWrap solutionWrap = new DoAllTest().new SolutionWrap();
            solutionTest.doTest(solutionWrap);
        }
    };
}
