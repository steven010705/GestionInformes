package co.edu.udistrital.decorator.concreteDecorators;

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
}