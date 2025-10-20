package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Member m = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
            LocalDate.of(2023, 10, 20),  // startdatum
            LocalDate.of(2025, 4, 1),    // senaste betalning
            "Platina");                                         // memberType

    @Test
    void MemberActiveTest() {
        boolean active = m.isActiveMember();
        assertTrue(active);
    }



}