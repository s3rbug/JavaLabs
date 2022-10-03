import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPerson {
    @Test public void equalsContract(){
        EqualsVerifier.forClass(Person.class).verify();
    }
    @Test public void convertToJson(){
        Person testPerson = new Person(
                "Test name",
                50,
                180.95,
                true,
                new String[]{"Name1", "Name2", "Name3"});
        String json = testPerson.toJson();
        Person testPersonFromJson = testPerson.getFromJson(json);
        assertEquals(testPerson, testPersonFromJson);
    }
}
