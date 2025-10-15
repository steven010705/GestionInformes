package co.edu.udistrital;

import co.edu.udistrital.bridge.Exporter;
import co.edu.udistrital.bridge.concreteImplementations.PdfExporter;
import co.edu.udistrital.bridge.refinedAbstractions.DetailedReport;
import co.edu.udistrital.decorator.concreteDecorators.Cover;
import co.edu.udistrital.decorator.concreteDecorators.Headers;
import co.edu.udistrital.flyweight.StyleFactory;
import co.edu.udistrital.flyweight.Text;
import co.edu.udistrital.flyweight.TextStyle;
import co.edu.udistrital.proxy.ReportProxy;
import co.edu.udistrital.proxy.RoleType;
import co.edu.udistrital.proxy.User;

public class Main {
    public static void main(String[] args) {
        // Flyweight factory
        StyleFactory styleFactory = new StyleFactory();
        TextStyle titleStyle = styleFactory.getTextStyle("Arial-Bold", 18, "black");
        TextStyle bodyStyle = styleFactory.getTextStyle("Arial", 12, "darkgray");
        TextStyle smallStyle = styleFactory.getTextStyle("Arial", 10, "gray");

        // Create texts
        Text t1 = new Text("Introduction to project goals.", "es", titleStyle);
        Text t2 = new Text("This project aims to design a modular reporting system...", "es", bodyStyle);
        Text t3 = new Text("Summary notes and action items.", "es", smallStyle);

        // Create a report (bridge)
        DetailedReport detailed = new DetailedReport();
        detailed.addText(t1);
        detailed.addText(t2);
        detailed.addText(t3);

        // Set exporter (Bridge)
        Exporter pdf = new PdfExporter();
        detailed.setExporter(pdf);

        // Wrap with proxy to control modifications
        ReportProxy proxy = new ReportProxy(detailed);

        // Set non-admin user and try to add decorator
        User alice = new User("alice", RoleType.EDITOR);
        proxy.setUser(alice);
        boolean added = proxy.addDecorator(new Cover(detailed, "Project Report"));
        System.out.println("Decorator added by alice? " + added);

        // Set admin user and add decorators
        User admin = new User("admin", RoleType.ADMIN);
        proxy.setUser(admin);
        proxy.addDecorator(new Cover(detailed, "Project Report"));
        // Add headers via admin
        proxy.addDecorator(new Headers(proxy.getRealReport(), "Company X - Internal"));

        // Export via proxy (delegates to realReport.export())
        proxy.export();

        // Show flyweight pool size
        System.out.println("TextStyle pool size: " + styleFactory.getPoolSize());
    }
}
