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


        boolean active = activeMember.isActiveMember();
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

    @Test
    void memberGetterAndSetterTest() {
        Member m = new Member();

        // Testa memberType
        m.setMemberType("Guld");
        assertEquals("Guld", m.getMemberType());

        // Testa memberStartDate
        LocalDate startDate = LocalDate.of(2025, 4, 13);
        m.setMemberStartDate(startDate);
        assertEquals(startDate, m.getMemberStartDate());

        // Testa memberLatestUpdateDate
        LocalDate latestUpdateDate = LocalDate.of(2024, 5, 11);
        m.setMemberLatestUpdateDate(latestUpdateDate);
        assertEquals(latestUpdateDate, m.getMemberLatestUpdateDate());

    }




}