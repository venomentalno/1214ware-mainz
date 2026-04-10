/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Theme
 */
package neo.deobf;

import java.awt.Color;
import java.util.ArrayList;
import neo.deobf.Theme;

public class ThemeManager {
    public ArrayList<Theme> themes = new ArrayList();

    public ArrayList<Theme> getThemes() {
        return (this.themes);
    }

    public Theme getDefaultTheme() {
        return this.getThemes().get(6);
    }

    public ThemeManager() {
        this.themes.add(new Theme("Midnight", new Color(6645607), new Color(4277061)));
        this.themes.add(new Theme("Gold", new Color(16762447), new Color(16751900)));
        this.themes.add(new Theme("Purple", new Color(8605083), new Color(13651670)));
        this.themes.add(new Theme("Night", new Color(2719929), new Color(2899536)));
        this.themes.add(new Theme("Electric", new Color(4683494), new Color(9327849)));
        this.themes.add(new Theme("Bloody Mary", new Color(16732463), new Color(14492790)));
        this.themes.add(new Theme("Rose Water", new Color(15031687), new Color(6276068)));
        this.themes.add(new Theme("Monte Carlo", new Color(13407680), new Color(14406836)));
        this.themes.add(new Theme("Argon", new Color(5645182), new Color(8455895)));
        this.themes.add(new Theme("Wiretap", new Color(9053063), new Color(15286359)));
        this.themes.add(new Theme("Rainbow Blue", new Color(62048), new Color(357862)));
        this.themes.add(new Theme("Orange Fun", new Color(16534042), new Color(16234291)));
        this.themes.add(new Theme("Hydrogen", new Color(6716854), new Color(33480)));
        this.themes.add(new Theme("Velvet Sun", new Color(14806723), new Color(15749203)));
        this.themes.add(new Theme("King Yna", new Color(1714796), new Color(16628525)));
        this.themes.add(new Theme("Kimoby", new Color(3762940), new Color(2705663)));
        this.themes.add(new Theme("Subu", new Color(846827), new Color(2155442)));
        this.themes.add(new Theme("Telegram", new Color(1872594), new Color(15924478)));
        this.themes.add(new Theme("Scooter", new Color(3592668), new Color(5998309)));
        this.themes.add(new Theme("Meridian", new Color(2636934), new Color(4563527)));
        this.themes.add(new Theme("Celestial", new Color(12793700), new Color(1910385)));
        this.themes.add(new Theme("Dream", new Color(3467422), new Color(996419)));
        this.themes.add(new Theme("Candy", new Color(28, 167, 222), new Color(236, 133, 209)));
        this.themes.add(new Theme("Summer", new Color(34, 193, 195), new Color(253, 187, 45)));
        this.themes.add(new Theme("River", new Color(4443810), new Color(1596061)));
        this.themes.add(new Theme("Gloria", new Color(641745), new Color(6363340)));
        this.themes.add(new Theme("Lollipop", new Color(16234331), new Color(15476088)));
        this.themes.add(new Theme("Jesic", new Color(12189542), new Color(7049291)));
        this.themes.add(new Theme("Shine", new Color(11760581), new Color(7170255)));
        this.themes.add(new Theme("Heron", new Color(15893890), new Color(6855044)));
        this.themes.add(new Theme("Doup", new Color(14412429), new Color(8225371)));
        this.themes.add(new Theme("Leen", new Color(10285765), new Color(4291953)));
        this.themes.add(new Theme("Crimson", new Color(215, 60, 67), new Color(140, 23, 39)));
        this.themes.add(new Theme("Windy", new Color(11319013), new Color(8846824)));
        this.themes.add(new Theme("Orange", new Color(242, 201, 76), new Color(241, 143, 56)));
        this.themes.add(new Theme("Atlas", new Color(16690270), new Color(4964552)));
        this.themes.add(new Theme("Sublime", new Color(16538749), new Color(6980347)));
        this.themes.add(new Theme("Azure", new Color(239, 50, 217), new Color(137, 255, 253)));
        this.themes.add(new Theme("Magic", new Color(5882227), new Color(6104769)));
        this.themes.add(new Theme("Orca", new Color(4497549), new Color(1006685)));
        this.themes.add(new Theme("Emerald", new Color(3731325), new Color(1153422)));
        this.themes.add(new Theme("Witchery", new Color(12784690), new Color(6430354)));
        this.themes.add(new Theme("Flare", new Color(15804177), new Color(16101145)));
        this.themes.add(new Theme("Falling", new Color(12993134), new Color(6564723)));
        this.themes.add(new Theme("Moonlight", new Color(10986455), new Color(5855641)));
        this.themes.add(new Theme("Deep Blue", new Color(1981554), new Color(2773656)));
        this.themes.add(new Theme("Melon", new Color(173, 247, 115), new Color(128, 243, 147)));
        this.themes.add(new Theme("Neon Red", new Color(210, 39, 48), new Color(184, 27, 45)));
        this.themes.add(new Theme("Pink Blood", new Color(226, 0, 70), new Color(255, 166, 200)));
    }

    public Theme getThemeByName(String name) {
        for (Theme theme : this.getThemes()) {
            if (!theme.getName().equalsIgnoreCase(name)) continue;
            return theme;
        }
        return this.getThemes().get(6);
    }
private static ArrayList getThemes(ThemeManager instance) {
        return instance.themes;
    }
}

