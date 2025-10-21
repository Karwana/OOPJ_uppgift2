package BestGymEver;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberFileReaderTest {

    MemberFileReader r = new MemberFileReader();

    Path p = Paths.get("test/BestGymEver/gym_medlemmar.txt");

    @Test
    public void readListTest() {
        List<Member> l = r.read(p);

        assertEquals(20, l.size());

        // Kontrollera första medlemmen
        Member first = l.getFirst();
        assertEquals("Fredrik Berggren", first.getNamn());
        assertEquals("Platina", first.getMemberType());
        assertEquals("851020-6728", first.getPersonnummer());

        // Kontrollera att nästa medlem INTE är Maria
        Member second = l.get(1);
        assertNotEquals("Maria Holmberg", second.getNamn());
    }

    @Test
    public void findExistingMemberTest() {
        Member payingMember = createDummyPayingMember();
        List<Member> list = List.of(payingMember);

        Member find = r.findMember("881231-1335");

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

}
