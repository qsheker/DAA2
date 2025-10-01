package algorithms;

import metrics.Metrics;

public class MajorityElementProblem {
    public int checkCandidate(int[] arr, int candidate){
        int count=0;

        // phase 2: checking candidate
        for(int num: arr){
            Metrics.incrementArrayAccess();
            Metrics.incrementComparisons();
            if(num==candidate){
                count++;
            }
        }
        Metrics.incrementComparisons();
        if(count>arr.length/2){
            return candidate;
        }
        return -1;
    }

    public int solution(int[] arr){
        Metrics.incrementComparisons();
        if(arr == null || arr.length==0){
            throw new IllegalArgumentException("Array is empty!");
        }

        Metrics.incrementArrayAccess();
        int candidate = arr[0];
        int count = 1;

        // phase 1: main loop to search the candidate
        for(int i = 1; i<arr.length;i++){
            Metrics.incrementArrayAccess();
            Metrics.incrementComparisons();
            if(arr[i]==candidate){
                count++;
            }
            else{
                count--;
                Metrics.incrementComparisons();
                if(count==0){
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
        // checking candidate if it's actually > arr.length/2
        return checkCandidate(arr,candidate);
    }

    // Getting Metrics result
    public String getResult(){
        return Metrics.getInfo();
    }

}
