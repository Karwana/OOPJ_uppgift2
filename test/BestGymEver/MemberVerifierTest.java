package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberVerifierTest {

    @Test
    void findMemberExists() {
        Member fredrik = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023,10,20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier verifier = new MemberVerifier(List.of(fredrik));

        // Testar att medlem med personnummer finns
        assertEquals(fredrik, verifier.findMember("851020-6728"));
    }

    @Test
    void findMemberNotExists() {
        Member fredrik = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023,10,20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier verifier = new MemberVerifier(List.of(fredrik));

        // Testar att medlem med okänt personnummer inte finns
        assertNull(verifier.findMember("000000-0000"));
    }

    @Test
    void verifyMemberStatus() {
        Member active = new Member("Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20), LocalDate.now().minusDays(20), "Platina");

        MemberVerifier verifier = new MemberVerifier(List.of(active));

        // Testa aktiv medlem
        assertEquals("Nuvarande medlem: Platina", verifier.verifyMemberStatus(active));

        // Testa obehörig
        assertEquals("Obehörig!", verifier.verifyMemberStatus(null));
    }
}
