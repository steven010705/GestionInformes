package co.edu.udistrital.decorator.concreteDecorators;

/**
 * Concrete decorator that adds a cover (simulated).
 */
public class Cover extends DocElemsDecorator {
    private final String coverTitle;

    public Cover(Report report, String coverTitle) {
        super(report);
        this.coverTitle = coverTitle;
    }

    @Override
    public void applyDecoration() {
        // For the sake of example, add a Text representing the cover to the wrapped report
        TextStyle style = new TextStyle("CoverFont", 24, "black");
        Text coverText = new Text("COVER: " + coverTitle, "en", style);
        report.addText(coverText);
    }
}