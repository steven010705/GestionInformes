package co.edu.udistrital.bridge;

public interface Exporter {
    /**
     * Exports the provided report into a target format (PDF, HTML, Markdown, etc).
     * Implementations can inspect report.getContent() or other report attributes.
     */
    void export(Report report);
}
