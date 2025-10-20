package BestGymEver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonTest {

    Person p = new Person("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728");

   @Test
    void testPersonConstructorAndGetter() {

       assertEquals("Fredrik Berggren", p.getNamn());
       assertEquals("Skolgränd 8, 16819 Norrköping", p.getAdress());
       assertEquals("fredde@fakemail.se", p.getMailadress());
       assertEquals("851020-6728", p.getPersonnummer());
       assertNotEquals("189271-3718", p.getPersonnummer());



   }



}