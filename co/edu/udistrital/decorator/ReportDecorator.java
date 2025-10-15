package co.edu.udistrital.decorator;

/**
 * Decorator interface that mirrors Report responsibilities.
 * Could also be an abstract class extending Report; here we use interface + adapter for clarity.
 */
public interface ReportDecorator {
    void applyDecoration(); // apply the decoration to the wrapped report
    void export();          // delegate or enhance export
}