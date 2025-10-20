package BestGymEver;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MemberFileReaderTest {

    MemberFileReader r = new MemberFileReader();

    Path p = Paths.get("test/BestGymEver/gym_medlemmar.txt");

    @Test
    public void readToStringListTest() {
        List<String> l = r.read(p);

        assert(l.size() == 21 );
        assert(l.get(0).equals("Namn;Adress;Mailadress;Personnummer;Datum_köpt_gymmedlemskap;Datum_senast_uppdaterad;Medlemsnivå"));
        assert(l.get(1).equals("Fredrik Berggren;Skolgränd 8, 16819 Norrköping;fredde@fakemail.se;851020-6728;2019-12-30;2021-12-30;Platina"));
        assert(!l.get(1).equals("Maria Holmberg;Fabriksgatan 4, 54886 Borlänge;maria@fakemail.se;480120-5578;2021-07-06;2024-07-06;Platina\n"));


    }


}
