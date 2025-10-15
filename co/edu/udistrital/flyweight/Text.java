package co.edu.udistrital.flyweight;
/**
 * Represents a fragment of text (with extrinsic state referencing a TextStyle flyweight).
 */
public class Text {
    private final int length;
    private final String language;
    private final TextStyle style;
    private final String content; // actual characters

    public Text(String content, String language, TextStyle style) {
        this.content = content;
        this.length = content != null ? content.length() : 0;
        this.language = language;
        this.style = style;
    }

    public int getLength() {
        return length;
    }

    public String getLanguage() {
        return language;
    }

    public TextStyle getStyle() {
        return style;
    }

    public String getContent() {
        return content;
    }

    // A simple textual representation combining content and style info
    public String render() {
        return String.format("[%s] %s (lang=%s, %s)", style.getFont(), content, language, style);
    }
}
