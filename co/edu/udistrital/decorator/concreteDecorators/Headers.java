package co.edu.udistrital.decorator.concreteDecorators;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.decorator.DocElemsDecorator;
import co.edu.udistrital.flyweight.Text;
import co.edu.udistrital.flyweight.TextStyle;

/**
 * Concrete decorator for headers.
 */
public class Headers extends DocElemsDecorator {
    private final String headerText;

    public Headers(Report report, String headerText) {
        super(report);
        this.headerText = headerText;
    }

    @Override
    public void applyDecoration() {
        TextStyle style = new TextStyle("HeaderFont", 10, "gray");
        Text header = new Text("HEADER: " + headerText, "en", style);
        report.addText(header);
    }

    @Override
    public String generateContent() {
        StringBuilder content = new StringBuilder();
        content.append("<< Header >>\n");
        content.append("Company: MyCompany Inc.\n");
        content.append("------------------------\n");
        content.append(report.generateContent());
        return content.toString();
    }
}