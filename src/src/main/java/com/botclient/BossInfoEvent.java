package neo.deobf;

public class BossInfoEvent implements Event {
    public String bossName;

    public BossInfoEvent(String bossName) {
        this.bossName = bossName;
    }
}
