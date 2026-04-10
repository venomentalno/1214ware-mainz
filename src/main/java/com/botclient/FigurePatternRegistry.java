package neo.deobf;

import java.io.File;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public class FigurePatternRegistry {
    public static BlockPos[] getFigureByName(String name) {
        int botsCount = PBot.getOnline().size();
        String lowerName = name.toLowerCase();
        switch (lowerName) {
            case "line": {
                BlockPos[] positions = new BlockPos[botsCount];
                for (int i = 0; i < botsCount; ++i) {
                    positions[i] = new BlockPos(i, 0, 0);
                }
                return positions;
            }
            case "-line": {
                BlockPos[] positions = new BlockPos[botsCount];
                for (int i = 0; i < botsCount; ++i) {
                    positions[i] = new BlockPos(0, 0, i);
                }
                return positions;
            }
        }
        try {
            boolean isUrl = name.startsWith("https://") || name.startsWith("http://");
            String content;
            if (isUrl) {
                content = Jsoup.connect(name).ignoreContentType(true).get().text();
            } else {
                File file = new File(Minecraft.getMinecraft().gameDir, "/NeoWare/figures/" + name + ".json");
                content = FileReadUtils.readUsingFiles(file);
            }
            if (content == null) {
                return null;
            }
            JSONObject figureData = new JSONObject(content);
            int centerX = figureData.getInt("x");
            int centerY = figureData.getInt("y");
            JSONArray matrix = figureData.getJSONArray("matrix");
            ArrayList<BlockPos> positions = new ArrayList<>();
            for (int row = 0; row < matrix.length(); ++row) {
                String line = matrix.getString(row);
                char[] cells = line.toCharArray();
                for (int col = 0; col < cells.length; ++col) {
                    if (cells[col] != '*') {
                        continue;
                    }
                    positions.add(new BlockPos(col - centerX, 0, row - centerY));
                }
            }
            return positions.toArray(new BlockPos[0]);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

