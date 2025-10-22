package BestGymEver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class GymVisitWriter {

    private String filePath = "src/BestGymEver/gym_visits.txt";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void writeVisit(GymVisit visitor) {
        String line = visitor.getMemberName() + ", " + visitor.getMembershipType() + ", (" + visitor.getPersonnummer() + "), " +
                visitor.getVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(line + "\n");
        } catch (IOException e) {
            System.err.println("Kunde inte skriva till fil: " + e.getMessage());
        }
    }
}