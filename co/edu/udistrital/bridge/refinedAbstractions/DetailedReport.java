package co.edu.udistrital.bridge.refinedAbstractions;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.flyweight.Text;

public class DetailedReport extends Report {

    @Override
    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DETAILED REPORT ===\n");
        for (Text t : texts) {
            sb.append(t.render()).append("\n");
        }
        sb.append("=======================\n");
        return sb.toString();
    }

    @Override
    public String getContent() {
        return generateContent();
    }
}