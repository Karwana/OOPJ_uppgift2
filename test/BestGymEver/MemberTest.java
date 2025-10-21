package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void memberActiveTest() {
        //given
        Member activeMember = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2023, 10, 20),  // startdatum
                LocalDate.of(2025, 4, 1),    // senaste betalning
                "Platina");                                         // memberType

        // when
        boolean active = activeMember.isActiveMember();

        // then
        assertTrue(active);
    }

    @Test
    void memberInactiveTest() {

        Member inactiveMember = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2022, 10, 20),  // startdatum
                LocalDate.of(2023, 4, 1),    // senaste betalning
                "Platina");                                         // memberType

        boolean active = inactiveMember.isActiveMember();
        assertFalse(active);
    }

    @Test
    void memberInactiveAfterOneYearTest() {

        Member inactiveMemberOneYear = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728",
                LocalDate.of(2022, 10, 20),  // startdatum
                LocalDate.now().minusYears(1),    // senaste betalning
                "Platina");                                         // memberType

        boolean inactive = inactiveMemberOneYear.isActiveMember();
        assertFalse(inactive);

    }
}