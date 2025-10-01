package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVwriter {
    private final PrintWriter writer;

    public CSVwriter(String filename) {
        try {
            this.writer = new PrintWriter(new FileWriter(filename, false));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeHeader(String header) {
        writer.println(header);
        writer.flush();
    }

    public void writeCSV(String line) {
        writer.println(line);
        writer.flush();
    }

    public void writeRow(String algorithm, int n, double timeMs,
                         int comparisons, int allocations, int depthMax, int arrayAccess) {
        writer.printf("%s,%d,%.3f,%d,%d,%d,%d%n",
                algorithm, n, timeMs, comparisons, allocations, depthMax, arrayAccess);
        writer.flush();
    }

    public void close() {
        writer.close();
    }
}
