package co.edu.udistrital.decorator.concreteDecorators;

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
}