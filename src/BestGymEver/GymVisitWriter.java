package BestGymEver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GymVisitWriter {

    private String filePath = "src/BestGymEver/gym_visits.txt";

    public void writeVisit(GymVisit visitor, String platina) {

        String line = visitor.getMemberName() + " (" + visitor.getPersonnummer() + ") - " +
                visitor.getVisitDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " " +
                visitor.getVisitTime().format(DateTimeFormatter.ofPattern("HH:mm"));

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(line + "\n");

        } catch (IOException e) {
            System.err.println("Kunde inte skriva till fil: " + e.getMessage());
        }
    }
}
