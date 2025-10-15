package co.edu.udistrital.decorator;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.flyweight.Text;

/**
 * Abstract decorator that wraps a Report.
 */
public abstract class DocElemsDecorator extends Report implements ReportDecorator {
    protected final Report report;

    public DocElemsDecorator(Report report) {
        this.report = report;
    }

    @Override
    public void export() {
        // default behavior: apply decoration and then delegate export to wrapped report
        applyDecoration();
        report.export();
    }

    @Override
    public void addText(Text text) {
        // delegate to wrapped report so all text fragments end up in the real report
        report.addText(text);
    }

    // concrete decorators must implement
    @Override
    public abstract void applyDecoration();
}