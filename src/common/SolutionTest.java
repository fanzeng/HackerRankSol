package common;
import java.io.FileInputStream;
import java.io.IOException;
import org.powermock.api.mockito.PowerMockito;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class SolutionTest {
    static String inputFileName;
    String outputFileName;
    String correctFileName;
    
    public SolutionTest(String inputFileName_, String outputFileName_, String correctFileName_) {
        inputFileName = inputFileName_;
        outputFileName = outputFileName_;
        correctFileName = correctFileName_;
        setSystemIn();
    }


    public String getOutputFileName() {
        return outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getCorrectFileName() {
        return correctFileName;
    }
    
    final static void setSystemIn() {
        try {
            System.out.println("Setting System.in to " + inputFileName);
            System.setIn(new FileInputStream(inputFileName));

        } catch(IOException e) {
            System.err.println("IO exception opening input file.");
        }
    }

    public void doTest(SolutionTestable solutionTestable) {
        PowerMockito.mockStatic(System.class);
        String outFileString = getOutputFileName();
        PowerMockito.when(System.getenv(Mockito.eq("OUTPUT_PATH"))).thenReturn(outFileString);
        assertEquals(System.getenv("OUTPUT_PATH"), outFileString);
        
        SampleTest sampleTest = new SampleTest();
        sampleTest.testMain(solutionTestable, getOutputFileName(), getCorrectFileName());
        assertEquals(System.getenv("OUTPUT_PATH"), outFileString);
    }
};