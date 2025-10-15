package co.edu.udistrital.decorator.concreteDecorators;

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
}