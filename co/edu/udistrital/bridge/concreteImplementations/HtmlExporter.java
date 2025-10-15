package co.edu.udistrital.bridge.concreteImplementations;

import co.edu.udistrital.bridge.Exporter;
import co.edu.udistrital.bridge.Report;

public class HtmlExporter implements Exporter {

    @Override
    public void export(Report report) {
        System.out.println("<html><body>");
        System.out.println("<pre>");
        System.out.println(report.getContent());
        System.out.println("</pre>");
        System.out.println("</body></html>");
    }
}