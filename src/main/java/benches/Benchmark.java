package benches;

import utils.CSVwriter;
import algorithms.KadanesAlgorithm;
import algorithms.MajorityElementProblem;
import metrics.Metrics;

import java.util.Random;

public class Benchmark {
    private final CSVwriter csvWriter;
    private final Random random = new Random();

    public Benchmark(CSVwriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    private int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }

    public void testKadaneAlgorithm(int n) {
        int[] arr = generateArray(n);
        KadanesAlgorithm kadane = new KadanesAlgorithm();
        Metrics.reset();

        long start = System.nanoTime();
        int[] result = kadane.findMaxSubarray(arr);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;
        String[] metrics = kadane.getInfo().split(",");

        csvWriter.writeRow("Kadane", n, timeMs,
                Integer.parseInt(metrics[0]),
                Integer.parseInt(metrics[1]),
                Integer.parseInt(metrics[2]),
                Integer.parseInt(metrics[3]));
    }

    public void testMajorityElementProblem(int n) {
        int[] arr = generateArray(n);
        MajorityElementProblem majority = new MajorityElementProblem();
        Metrics.reset();

        long start = System.nanoTime();
        int result = majority.solution(arr);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;
        String[] metrics = majority.getResult().split(",");

        csvWriter.writeRow("Majority", n, timeMs,
                Integer.parseInt(metrics[0]),
                Integer.parseInt(metrics[1]),
                Integer.parseInt(metrics[2]),
                Integer.parseInt(metrics[3]));
    }
}
