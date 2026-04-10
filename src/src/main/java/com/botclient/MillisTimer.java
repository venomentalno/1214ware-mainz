package neo.deobf;

public class MillisTimer {
    private long lastMs = System.currentTimeMillis();

    public void reset() {
        lastMs = System.currentTimeMillis();
    }

    public long getTime() {
        return System.currentTimeMillis() - lastMs;
    }

    public boolean hasReached(double ms) {
        return getTime() >= ms;
    }
}
