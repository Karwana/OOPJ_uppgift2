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

        // Kontrollera första medlem
        Member first = l.getFirst();
        assertEquals("Fredrik Berggren", first.getNamn());
        assertEquals("Platina", first.getMemberType());
        assertEquals("851020-6728", first.getPersonnummer());

        // Kontrollera att nästa medlem INTE är Maria
        Member second = l.get(1);
        assertNotEquals("Maria Holmberg", second.getNamn());
    }


}
