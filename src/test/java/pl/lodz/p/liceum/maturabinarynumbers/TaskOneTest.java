package pl.lodz.p.liceum.maturabinarynumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskOneTest {

    private static final String summaryTestLogFile = "./test_results/task_one/test_summary.txt";
    private static final String detailsTestLogFile = "./test_results/task_one/test_details.txt";

    private final TaskOne taskOne = new TaskOne();
    private static final TestLogger logger = new TestLogger();

    @org.junit.jupiter.api.AfterAll
    static void tearDown() {
        logger.saveResults(summaryTestLogFile, detailsTestLogFile);
    }

    @Test
    void testTaskOneMaturaExample() {
        String inputPath = "./tests_input/matura_task_one_example.txt";
        int expected = 3;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("TestTaskOneMaturaExample", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }

    @Test
    void testTaskOneMaturaOfficial() {
        String inputPath = "./tests_input/matura_official_test.txt";
        int expected = 422;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("testTaskOneMaturaOfficial", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }

    @Test
    void testTaskOneBig() {
        String inputPath = "./tests_input/big_test.txt";
        int expected = 168991;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("testTaskOneBig", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }

    @Test
    void testTaskOneMax() {
        String inputPath = "./tests_input/max_test.txt";
        int expected = 0;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("testTaskOneMax", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }

    @Test
    void testTaskOneOnlyZero() {
        String inputPath = "./tests_input/only_zero.txt";
        int expected = 1;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("testTaskOneOnlyZero", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }

    @Test
    void testTaskOneOnlyOne() {
        String inputPath = "./tests_input/only_one.txt";
        int expected = 0;

        long startTime = System.nanoTime();
        int result = taskOne.taskOne(inputPath);
        long endTime = System.nanoTime();
        logger.logSingleTestResult("testTaskOneOnlyOne", expected == result, (endTime - startTime) / 1e9);

        assertEquals(expected, result);
    }
}