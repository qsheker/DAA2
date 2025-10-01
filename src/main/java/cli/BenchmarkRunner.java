package cli;

import benches.Benchmark;
import utils.CSVwriter;

public class BenchmarkRunner {
    public static void main(String[] args) {
        CSVwriter writer = new CSVwriter("C:\\Users\\aldik\\IdeaProjects\\DAA2\\docs\\result\\benchmark_results.csv");

        writer.writeHeader("Algorithm,n,time_ms,comparisons,allocations,depthMax,arrayAccess");

        Benchmark bench = new Benchmark(writer);

        int[] sizes = {100, 1000, 10000, 100000};
        for (int n : sizes) {
            bench.testKadaneAlgorithm(n);
            bench.testMajorityElementProblem(n);
        }

        writer.close();
    }
}
