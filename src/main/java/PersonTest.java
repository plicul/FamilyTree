import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Ivan");
    }

    @Test
    @DisplayName("Adding Children")
    void testAdd() {
        Person ivor = new Person("Ivor");
        person.addChild(ivor);
        person.addChild(new Person("Zvonimir"));
        ivor.addChild(new Person("Tomislav"));
        assertEquals(2, person.children.size(),
                "Children added");
        assertEquals(1, ivor.children.size(),
                "Children added to child");
    }

    @Test
    @DisplayName("Print test")
    void testPrint() {
        Person ivor = new Person("Ivor");
        person.addChild(ivor);
        person.addChild(new Person("Zvonimir"));
        ivor.addChild(new Person("Tomislav"));
        String full="";

        assertEquals("\nIvan\n" +
                        "\tIvor\n" +
                        "\t\tTomislav\n" +
                        "\tZvonimir", person.print(0),
                "Children added to child");
    }
}
