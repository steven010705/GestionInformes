package co.edu.udistrital.bridge.concreteImplementations;

import co.edu.udistrital.bridge.Exporter;
import co.edu.udistrital.bridge.Report;

public class PdfExporter implements Exporter {

    @Override
    public void export(Report report) {
        // For demo, just print to console with a PDF header
        System.out.println("[PDF EXPORT] ------------------");
        System.out.println(report.getContent());
        System.out.println("[END PDF EXPORT] ------------------");
    }
}