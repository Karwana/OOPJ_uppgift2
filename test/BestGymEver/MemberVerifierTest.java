package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberVerifierTest {

    @Test
    void findMemberExistsTest() {
        Member activeMemberFredrik = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier memberExists = new MemberVerifier(List.of(activeMemberFredrik));

        // Testa att medlem med personnummer finns
        assertEquals(activeMemberFredrik, memberExists.findMember("851020-6728"));
    }

    @Test
    void findMemberNotExistsTest() {
        Member fredrik = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier memberNotExists = new MemberVerifier(List.of(fredrik));

        // Testa att medlem med okänt personnummer inte finns
        assertNull(memberNotExists.findMember("000000-0000"));
    }

    @Test
    void verifyMemberStatusTest() {
        Member activeMember = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier verifyOneYear = new MemberVerifier(List.of(activeMember));

        // Testa aktiv medlem
        assertEquals("Nuvarande medlem: Platina", verifyOneYear.verifyMemberStatus(activeMember));

        // Testa obehörig
        assertEquals("Obehörig!", verifyOneYear.verifyMemberStatus(null));
    }
}
