package com.botclient;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import java.util.ArrayList;
import java.util.List;

public class AltManagerScreen extends Screen {
    private final Screen parent;
    private List<AltAccount> altList;
    private AltAccount selectedAlt;
    private double offset = 0;
    private int listWidth = 300;
    
    public AltManagerScreen(Screen parent) {
        super(Text.literal("Alt Manager"));
        this.parent = parent;
        this.altList = new ArrayList<>();
    }
    
    @Override
    protected void init() {
        super.init();
        
        // Add buttons
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Add Alt"), button -> {
            this.client.setScreen(new AddAltScreen(this));
        }).dimensions(this.width / 2 - 100, this.height - 60, 200, 20).build());
        
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Remove"), button -> {
            if (this.selectedAlt != null) {
                this.altList.remove(this.selectedAlt);
                this.selectedAlt = null;
            }
        }).dimensions(this.width / 2 - 150, this.height - 40, 140, 20).build());
        
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Login"), button -> {
            if (this.selectedAlt != null) {
                // Login logic here
            }
        }).dimensions(this.width / 2 + 10, this.height - 40, 140, 20).build());
        
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> {
            this.client.setScreen(this.parent);
        }).dimensions(this.width / 2 - 100, this.height - 20, 200, 20).build());
    }
    
    @Override
    public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawTextWithShadow(this.textRenderer, this.title.getString(), this.width / 2 - this.textRenderer.getWidth(this.title.getString()) / 2, 20, 0xFFFFFF);
        
        // Render alt list
        int x = this.width / 2 - listWidth / 2;
        int y = 40;
        int slotHeight = 24;
        
        for (int i = 0; i < altList.size(); i++) {
            AltAccount alt = altList.get(i);
            int slotY = y + (int)((i - offset) * slotHeight);
            
            if (slotY < y || slotY + slotHeight > this.height - 80) {
                continue;
            }
            
            boolean isSelected = alt == selectedAlt;
            int bgColor = isSelected ? 0x80A0A0A0 : 0x40000000;
            context.fill(x, slotY, x + listWidth, slotY + slotHeight, bgColor);
            
            String displayText = alt.getEmail() + " (" + alt.getStatus() + ")";
            context.drawTextWithShadow(this.textRenderer, displayText, x + 5, slotY + (slotHeight - 8) / 2, 0xFFFFFF);
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (verticalAmount > 0) {
            this.offset = Math.max(0, this.offset - 1.0);
        } else {
            this.offset = Math.min(Math.max(0, altList.size() - 5), this.offset + 1.0);
        }
        return true;
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int x = this.width / 2 - listWidth / 2;
        int y = 40;
        int slotHeight = 24;
        
        for (int i = 0; i < altList.size(); i++) {
            AltAccount alt = altList.get(i);
            int slotY = y + (int)((i - offset) * slotHeight);
            
            if (slotY >= y && slotY + slotHeight <= this.height - 80) {
                if (mouseX >= x && mouseX <= x + listWidth && mouseY >= slotY && mouseY <= slotY + slotHeight) {
                    this.selectedAlt = alt;
                    return true;
                }
            }
        }
        
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    public void addAlt(AltAccount alt) {
        this.altList.add(alt);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
}
