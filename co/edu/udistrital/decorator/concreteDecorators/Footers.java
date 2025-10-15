package co.edu.udistrital.decorator.concreteDecorators;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.decorator.DocElemsDecorator;
import co.edu.udistrital.flyweight.Text;
import co.edu.udistrital.flyweight.TextStyle;

/**
 * Concrete decorator for footers.
 */
public class Footers extends DocElemsDecorator {
    private final String footerText;

    public Footers(Report report, String footerText) {
        super(report);
        this.footerText = footerText;
    }

    @Override
    public void applyDecoration() {
        TextStyle style = new TextStyle("FooterFont", 8, "gray");
        Text footer = new Text("FOOTER: " + footerText, "en", style);
        report.addText(footer);
    }

    @Override
    public String generateContent() {
        StringBuilder content = new StringBuilder();
        content.append(report.generateContent());
        content.append("\n------------------------\n");
        content.append("Footer: Confidential Report - 2025\n");
        return content.toString();
    }
}