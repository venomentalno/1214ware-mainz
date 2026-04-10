package neo.deobf;

public abstract class CancellableEvent implements Event, Cancellable {
    public boolean cancelled;

    @Override
    public boolean isCancelled() { return cancelled; }

    @Override
    public void setCancelled(boolean state) { this.cancelled = state; }
}
