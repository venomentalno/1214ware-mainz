package neo.deobf;

import java.util.function.Supplier;

public class InfoSetting extends Setting {
    private final Supplier<String> textSupplier;

    public InfoSetting(String name, Supplier<String> textSupplier) {
        super(name);
        this.textSupplier = textSupplier;
        setVisible(() -> true);
    }

    public String getText() {
        return textSupplier.get();
    }
}
