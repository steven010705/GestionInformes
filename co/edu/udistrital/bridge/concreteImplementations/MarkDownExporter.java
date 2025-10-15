package co.edu.udistrital.bridge.concreteImplementations;

import co.edu.udistrital.bridge.Exporter;
import co.edu.udistrital.bridge.Report;

public class MarkDownExporter implements Exporter {

    @Override
    public void export(Report report) {
        System.out.println("--- MARKDOWN EXPORT ---");
        System.out.println(report.getContent());
        System.out.println("--- END MARKDOWN EXPORT ---");
    }
}
