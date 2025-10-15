package co.edu.udistrital.decorator.concreteDecorators;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.decorator.DocElemsDecorator;
import co.edu.udistrital.flyweight.Text;
import co.edu.udistrital.flyweight.TextStyle;

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

    @Override
    public String generateContent() {
       StringBuilder content = new StringBuilder();
    content.append("[WATERMARK: Confidential Document]\n");
    content.append(report.generateContent());
    return content.toString();
    }
}