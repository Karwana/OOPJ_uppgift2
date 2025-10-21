package BestGymEver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberVerifierTest {

    MemberVerifier v = new MemberVerifier();

    @Test
    void findExistingMemberTest() {
        Member payingMember = createDummyPayingMember();
        List<Member> list = List.of(payingMember);

        Member find = v.findMember("881231-1335");

        assertEquals(payingMember, find);
    }

    private Member createDummyPayingMember() {
        return new Member("Fredrik Berggren",
                "Kungsgatan 8",
                "fredrik.berggren@hotmail.com",
                "881231-1335",
                LocalDate.of(2019,12,12),
                LocalDate.now().minusDays(20),
                "Guld");
    }

    // testa verify metod

    // testa find metod när medlem finns i listan
    // testa find metod när medlem inte finns i listan
    /*



    test: kolla om fredrik finns -> ja
    test: kolla att jens INTE finns -> ja
     */

}
