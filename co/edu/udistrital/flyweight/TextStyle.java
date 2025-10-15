package co.edu.udistrital.flyweight;
/**
 * Flyweight: the shared intrinsic state
 */
public class TextStyle {
    // protected because subclasses or package classes might want access
    protected final String font;
    protected final int size;
    protected final String color;

    public TextStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "TextStyle{" +
                "font='" + font + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}

