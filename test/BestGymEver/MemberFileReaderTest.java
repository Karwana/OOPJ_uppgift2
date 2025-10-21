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
    void readMembersTest() {
        List<Member> l = r.read(p);

        assertNotNull(l);
        assertFalse(l.isEmpty());
        assertEquals(20, l.size());



        // Testa första medlem
        Member first = l.getFirst();
        assertEquals("Fredrik Berggren", first.getNamn());
        assertEquals("851020-6728", first.getPersonnummer());
        assertEquals("Platina", first.getMemberType());
        assertEquals("Skolgränd 8, 16819 Norrköping", first.getAdress());
        assertEquals("fredde@fakemail.se", first.getMailadress());
    }

    @Test
    void readDatesTest() {
        List<Member> l = r.read(p);

        Member first = l.getFirst();
        assertEquals(LocalDate.of(2021, 12, 30), first.getMemberLatestUpdateDate());
    }

    @Test
    void fileNotFoundTest() {
        Path invalid = Paths.get("test/BestGymEver/does_not_exist.txt");
        List<Member> memberList = r.read(invalid);
        assertNull(memberList);
    }
}