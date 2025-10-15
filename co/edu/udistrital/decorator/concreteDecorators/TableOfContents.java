package co.edu.udistrital.decorator.concreteDecorators;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.decorator.DocElemsDecorator;
import co.edu.udistrital.flyweight.Text;
import co.edu.udistrital.flyweight.TextStyle;

/**
 * Concrete decorator for table of contents
 */
public class TableOfContents extends DocElemsDecorator {
    public TableOfContents(Report report) {
        super(report);
    }

    @Override
    public void applyDecoration() {
        TextStyle style = new TextStyle("TOCFont", 12, "black");
        Text toc = new Text("TABLE OF CONTENTS (simulated)", "en", style);
        report.addText(toc);
    }

    @Override
    public String generateContent() {
        StringBuilder content = new StringBuilder();
        content.append("===== TABLE OF CONTENTS =====\n");
        content.append("1. Introduction\n");
        content.append("2. Development\n");
        content.append("3. Results\n");
        content.append("4. Conclusions\n");
        content.append("=============================\n\n");
        content.append(report.generateContent());
        return content.toString();
    }
}