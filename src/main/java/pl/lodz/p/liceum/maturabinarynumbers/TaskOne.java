package pl.lodz.p.liceum.maturabinarynumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskOne {
    public int taskOne(String path) {
        List<String> binaryNumbers;

        try {
            binaryNumbers = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int amount = 0;
        for (String binaryNumber : binaryNumbers) {
            if (hasMoreZeros(binaryNumber)) ++amount;
        }
        return amount;
    }

    private boolean hasMoreZeros(String binaryNumber) {
        int zeros = 0;
        int ones = 0;
        for (char digit : binaryNumber.toCharArray()) {
            if (digit == '0') ++zeros;
            else ++ones;
        }
        return zeros > ones;
    }
}
