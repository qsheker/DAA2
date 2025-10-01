package algorithms;


import metrics.Metrics;

public class KadanesAlgorithm {
    public int[] findMaxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0, end = 0, tempStart = 0;
        Metrics.incrementArrayAccess();
        Metrics.incrementArrayAccess();


        for (int i = 1; i < arr.length; i++) {
            Metrics.incrementArrayAccess();
            Metrics.incrementComparisons();
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            Metrics.incrementComparisons();
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSum, start, end};
    }

    public String getInfo(){
        return Metrics.getInfo();
    }
}