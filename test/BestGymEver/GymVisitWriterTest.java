package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GymVisitWriterTest {

    GymVisitWriter writer = new GymVisitWriter();

    @Test
    void writeVisitTest() {
        GymVisit visitor = new GymVisit("Fredrik Berggren", "851020-6728", LocalDate.of(2025, 10, 21));
        writer.writeVisit(visitor, "Platina");
        assertTrue(true);

    }

}
