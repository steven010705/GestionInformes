package co.edu.udistrital.bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.edu.udistrital.flyweight.Text;

public abstract class Report {
    // Bridge: implementor
    protected Exporter exporter;

    // Flyweight: composition of Text fragments
    protected List<Text> texts = new ArrayList<>();

    public void setExporter(Exporter exporter) {
        this.exporter = exporter;
    }

    public void addText(Text t) {
        if (t != null) texts.add(t);
    }

    public List<Text> getTexts() {
        return Collections.unmodifiableList(texts);
    }

    /**
     * Produce the main content (without decorator modifications).
     * Concrete report types implement this.
     */
    public abstract String generateContent();

    /**
     * Return the current (possibly cached) content; by default it delegates to generateContent.
     */
    public String getContent() {
        return generateContent();
    }

    /**
     * Exports the report using the configured Exporter.
     */
    public void export() {
        if (exporter == null) {
            throw new IllegalStateException("No exporter configured");
        }
        exporter.export(this);
    }
}