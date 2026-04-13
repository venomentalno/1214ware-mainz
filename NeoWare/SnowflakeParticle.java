/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 */
package neo.deobf;

import java.util.Random;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class SnowflakeParticle {
    public int size;
    public int x;
    public int fallingSpeed;
    public int y;

    public void update(ScaledResolution res) {
        Gui.drawRect((int)(this.x), (int)(this.y), (int)((this.x) + (this.size)), (int)((this.y) + (this.size)), (int)(-1714829883));
        this.y = SnowflakeParticle.getY4(this) + SnowflakeParticle.getFallingSpeed(this);
        if ((this.y) > res.getScaledHeight() + (10) || (this.y) < (-10)) {
            this.y = -10;
            Random rand = new Random();
            this.fallingSpeed = rand.nextInt(10) + (1);
            this.size = rand.nextInt(4) + (1);
        }
    }

    public SnowflakeParticle(int x, int y, int fallspeed, int size) {
        this.x = x;
        this.y = y;
        this.fallingSpeed = fallspeed;
        this.size = size;
    }

    private static int getFallingSpeed(SnowflakeParticle instance) {
        return instance.fallingSpeed;
    }

    private static int getY4(SnowflakeParticle instance) {
        return instance.y;
    }

}

