package BestGymEver;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GymVisitWriterTest {

    @Test
    void testWriteVisit() throws IOException {
        Path testFile = Path.of("test/BestGymEver/test_gym_visits.txt");

        GymVisitWriter writer = new GymVisitWriter();
        writer.setFilePath(testFile.toString());

        GymVisit anna = new GymVisit("Anna Andersson", "Guld", "901201-1234", LocalDate.of(2025, 10, 22));
        GymVisit bert = new GymVisit("Bert Bertilsson", "Platina", "850505-5678", LocalDate.of(2025, 10, 23));

        writer.writeVisit(anna);
        writer.writeVisit(bert);

        List<String> lines = Files.readAllLines(testFile);

        // -2, -1 för senaste personer
        assertEquals("Anna Andersson, Guld, (901201-1234), 2025-10-22", lines.get(lines.size()-2));
        assertEquals("Bert Bertilsson, Platina, (850505-5678), 2025-10-23", lines.get(lines.size()-1));
    }
}
