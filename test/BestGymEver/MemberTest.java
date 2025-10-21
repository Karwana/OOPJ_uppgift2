package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void memberActiveTest() {
        Member activeMember = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2023, 10, 20),  // startdatum
                LocalDate.of(2025, 4, 1),    // senaste betalning
                "Platina");                                         // memberType

        assertTrue(activeMember.isActiveMember());
    }

    @Test
    void memberInactiveTest() {

        Member inactiveMember = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2022, 10, 20),  // startdatum
                LocalDate.of(2023, 4, 1),    // senaste betalning
                "Platina");                                         // memberType

        assertFalse(inactiveMember.isActiveMember());

    }

    @Test
    void memberInactiveAfterOneYearTest() {

        Member inactiveMemberAfterOneYear = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2022, 10, 20),  // startdatum
                LocalDate.now().minusYears(1),    // senaste betalning
                "Platina");                                         // memberType

        assertFalse(inactiveMemberAfterOneYear.isActiveMember());


    }
}