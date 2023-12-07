package pl.lodz.p.liceum.maturabinarynumbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TestLogger {

    private final Map<String, TestResult> results = new HashMap<>();

    void logSingleTestResult(String testName, boolean passed, double time) {
        results.put(testName, new TestResult(passed, time));
    }

    void saveResults(String summaryTestLogFile, String detailsTestLogFile) {
        saveSummaryResult(summaryTestLogFile);
        saveDetailedResults(detailsTestLogFile);
    }

    private void saveSummaryResult(String filePath) {
        File file = new File(filePath);
        try (var fileWriter = new FileWriter(file, false)) {
            boolean overallTestResult = results.values().stream().allMatch(TestResult::passed);
            fileWriter.write(String.format("TASK COMPLETED: %b\n", overallTestResult));
            int passedTestsCount = (int) results.values().stream().filter(TestResult::passed).count();
            fileWriter.write(String.format("PASSED TESTS: %d OF %d\n", passedTestsCount, results.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDetailedResults(String filePath) {
        File file = new File(filePath);
        try (var fileWriter = new FileWriter(file, false)) {
            for (var item : results.entrySet()) {
                fileWriter.write(String.format("%s;%s;%b;%.3f\n",
                        LocalDateTime.now(), item.getKey(), item.getValue().passed(), Math.round(item.getValue().time() * 1000) / 1000f));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
