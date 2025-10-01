package metrics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class Metrics {
    private static final ThreadLocal<Integer> depth = ThreadLocal.withInitial(()->0);
    private static final AtomicInteger depthMax = new AtomicInteger();
    private static final AtomicLong comparisons = new AtomicLong();
    private static final AtomicLong allocations = new AtomicLong();


    public static void reset() {
        comparisons.set(0);
        allocations.set(0);
        depth.remove();
        depthMax.set(0);
    }

    public static void enter() {
        int d = depth.get() + 1;
        depth.set(d);
        depthMax.getAndAccumulate(d, Math::max);
    }

    public static void exit() {
        depth.set(Math.max(0, depth.get() - 1));
    }
    public static void incrementComparisons(){
        long c = comparisons.get()+1;
        comparisons.set(c);
    }
    public static void incrementAllocations(){
        long a = allocations.get()+1;
        allocations.set(a);
    }

    public static int getDepthMax() {
        return depthMax.get();
    }
    public static long getComparisons(){
        return comparisons.get();
    }
    public static long getAllocations(){
        return allocations.get();
    }

    public static String getInfo() {
        return comparisons.get() + "," + allocations.get() + "," + depthMax.get();
    }

}

