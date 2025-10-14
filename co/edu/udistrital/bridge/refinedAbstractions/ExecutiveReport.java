package co.edu.udistrital.bridge.refinedAbstractions;

import co.edu.udistrital.bridge.Report;
import co.edu.udistrital.flyweight.Text;

public class ExecutiveReport extends Report {

    @Override
    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== EXECUTIVE SUMMARY ===\n");
        // executive reports might summarize texts: only first 100 chars of each Text
        for (Text t : texts) {
            String r = t.render();
            if (r.length() > 100) r = r.substring(0, 100) + "...";
            sb.append(r).append("\n");
        }
        sb.append("=========================\n");
        return sb.toString();
    }

    @Override
    public String getContent() {
        return generateContent();
    }
}
