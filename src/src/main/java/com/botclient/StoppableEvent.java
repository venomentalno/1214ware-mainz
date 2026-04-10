package neo.deobf;

public abstract class StoppableEvent implements Event {
    private boolean stopped;
    public void stop()           { this.stopped = true; }
    public boolean isStopped()   { return stopped; }
}
