package co.edu.udistrital.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight factory - returns shared TextStyle instances
 */
public class StyleFactory {
    // Map key could be "font|size|color"
    private final Map<String, TextStyle> textStyles = new HashMap<>();

    public TextStyle getTextStyle(String font, int size, String color) {
        String key = font + "|" + size + "|" + color;
        return textStyles.computeIfAbsent(key, k -> new TextStyle(font, size, color));
    }

    public int getPoolSize() {
        return textStyles.size();
    }
}
