package co.edu.udistrital.proxy;

import co.edu.udistrital.bridge.Exporter;
import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.decorator.DocElemsDecorator;
import co.edu.udistrital.flyweight.Text;

/**
 * Proxy for controlling access to a Report (e.g., only ADMIN can add decorators).
 */
public class ReportProxy extends Report {
    private final Report realReport;
    private User user;

    public ReportProxy(Report realReport) {
        this.realReport = realReport;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Try to add a decorator around the real report: only ADMIN allowed.
     * Returns true if decorator was applied/allowed.
     */
    public boolean addDecorator(DocElemsDecorator decorator) {
        if (user != null && user.isAdmin()) {
            // We will simulate decoration by applying the decoration directly to the real report.
            decorator.applyDecoration();
            return true;
        } else {
            System.out.println("Permission denied: user " + (user != null ? user.getUsername() : "null"));
            return false;
        }
    }

    @Override
    public String generateContent() {
        // Delegate to realReport
        return realReport.generateContent();
    }

    @Override
    public void export() {
        // Delegate export to realReport (keeps bridge behavior)
        realReport.export();
    }

    @Override
    public void addText(Text text) {
        realReport.addText(text);
    }

    @Override
    public void setExporter(Exporter exporter) {
        realReport.setExporter(exporter);
    }

    @Override
    public java.util.List<Text> getTexts() {
        return realReport.getTexts();
    }
}