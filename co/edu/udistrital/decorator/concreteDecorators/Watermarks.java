package co.edu.udistrital.decorator.concreteDecorators;

/**
 * Concrete decorator for watermarks (simulated as a text fragment).
 */
public class Watermarks extends DocElemsDecorator {
    private final String watermark;

    public Watermarks(Report report, String watermark) {
        super(report);
        this.watermark = watermark;
    }

    @Override
    public void applyDecoration() {
        TextStyle style = new TextStyle("WatermarkFont", 40, "lightgray");
        Text w = new Text("WATERMARK: " + watermark, "en", style);
        report.addText(w);
    }
}