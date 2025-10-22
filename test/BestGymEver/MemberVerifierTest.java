package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberVerifierTest {

    @Test
    void findMemberExistsTest() {

        Member fredrik = new Member(
                "Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20),
                LocalDate.now().minusDays(20), "Platina"
        );

        // lista som innehåller Fredrik
        MemberVerifier verifier = new MemberVerifier(List.of(fredrik));


        assertEquals(fredrik, verifier.findMember("851020-6728"));
    }

    @Test
    void findMemberNotExistsTest() {

        Member fredrik = new Member(
                "Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20),
                LocalDate.now().minusDays(20), "Platina"
        );


        MemberVerifier verifier = new MemberVerifier(List.of(fredrik));

        // okänt personnummer
        assertNull(verifier.findMember("000000-0000"));
    }

    @Test
    void verifyMemberStatusTest() {

        Member fredrik = new Member(
                "Fredrik Berggren", "Skolgränd 8", "fredde@fakemail.se",
                "851020-6728", LocalDate.of(2023, 10, 20),
                LocalDate.now().minusDays(20), "Platina"
        );


        MemberVerifier verifier = new MemberVerifier(List.of(fredrik));

        // aktiv medlem
        assertEquals("Nuvarande medlem: Platina", verifier.verifyMemberStatus(fredrik));

        // obehörig
        assertEquals("Obehörig!", verifier.verifyMemberStatus(null));
    }
}
