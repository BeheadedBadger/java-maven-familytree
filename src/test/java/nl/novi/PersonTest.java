package nl.novi;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void addChild() {
        //Arrange
        Person p = new Person("John", null, "Doe", "m", null, null);
        Person c1 = new Person("Child1", null, "Doe", "m", null, null);
        Person c2 = new Person("Child2", null, "Doe", "m", null, null);
        p.setChildren(List.of(c1, c2));

        //Act
        Person c3 = new Person("Child3", null, "Doe", "m", null, null);
        p.addChild(c3);

        //Assert
        assertEquals(List.of(c1, c2, c3), p.getChildren());
    }

    @Test
    void addSibling() {
        //Arrange
        Person p = new Person("John", null, "Doe", "m", null, null);
        Person s1 = new Person("Sibling1", null, "Doe", "m", List.of(p), null);

        //Act
        p.addSibling(s1);

        //Assert
        assertEquals(List.of(s1), p.getSiblings());
    }

    @Test
    void addPet() {
        //Arrange
        Person p = new Person("John", null, "Doe", "m", null, null);
        Pet pet = new Pet("Pet", 0, "Cat");
        Pet pet2 = new Pet("Pet2", 0, "Dog");
        //Act
        p.addPet(pet);
        pet2.setOwner(p);
        //Assert
        assertEquals(List.of(pet, pet2), p.getPets());
    }

    @Test
    void testToString() {
        //Arrange
        Person p = new Person("John", null, "Doe", "m", null, null);
        //Act
        //Assert
        assertEquals("John Doe", p.toString());
    }
}