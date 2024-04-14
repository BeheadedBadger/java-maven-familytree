package nl.novi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //////////////////////////////// Set up all the people and pets ///////////////////////////////////////
        //Parents Shay
        Person Samantha = new Person("Samantha", null, "Mcgill", "f", null, null);
        Person Antony = new Person("Antony", null, "Mcgill", "m", null, null);

        //Shay and siblings
        Person Courtney = new Person("Courtney", null, "Mcgill", "f", 28, Samantha, Antony, null, null, null);
        Person Chloe = new Person("Cloe", null, "Mcgill", "f", 25, Samantha, Antony, null, null, null);
        Person Shay = new Person("Shay", null, "Mcgill", "m", 30, Samantha, Antony, List.of(Chloe, Courtney), null, null);

        //Nephews/Nieces Shay
        Person ChildChloe1 = new Person("Name", null, "LastName", "m", 4, Chloe, null, null, null, null);
        Person ChildChloe2 = new Person("Name", null, "LastName", "m", 2, Chloe, null, null, null, null);
        Person FakeDaughterChloe = new Person("Fake daughter of sibling of Shay", "Test", "to test the niece Getter", "f", 0, Chloe, null, null, null, null);

        //Assign remaining relations
        Chloe.setSiblings(List.of(Shay, Courtney));
        Chloe.setChildren(List.of(ChildChloe1, ChildChloe2, FakeDaughterChloe));
        Courtney.setSiblings(List.of(Shay, Chloe));
        Samantha.setChildren(List.of(Shay, Courtney, Chloe));
        Antony.setChildren(List.of(Shay, Courtney, Chloe));

        //Grandparents Zarra
        Person Hennie = new Person("Hennie", null, "de Ruijter", "f", null, null);
        Person Fritz = new Person("Fritz", null, "de Ruijter", "m", null, null);
        Person Joke = new Person("Joke", null, "Kornalijnslijper", "f", 90, null, null, null, null, null);
        Person Hans = new Person("Hans", null, "Kessenich", "m", null, null);

        //Parents and aunts/uncle Zarra
        Person Marga = new Person("Marga", null, "Kessenich", "f", 66, Joke, Hans, null, null, null);
        Person Roel = new Person("Roel", null, "de Ruijter", "m", 66, Hennie, Fritz, null, null, null);
        Person Mark = new Person("Mark", null, "Kessenich", "m", null, null);
        Person Miriam = new Person("Miriam", null, "Kessenich", "f", null, null);
        Person Inge = new Person("Inge", null, "Kessenich", "f", null, null);
        Person Nanja = new Person("Nanja", null, "Kessenich", "f", null, null);

        //Siblings Zarra
        Person Nick = new Person("Nick", "Vincent", "de Ruijter", "m", 34, Marga, Roel, null, null, null);
        Person Zarra = new Person("Zarra", "Sabrina", "de Ruijter", "f", 36, Marga, Roel, List.of(Nick), null, null);

        //Assign remaining relations
        Hennie.setChildren(List.of(Roel));
        Fritz.setChildren(List.of(Roel));
        Joke.setChildren(List.of(Marga, Mark, Miriam, Inge, Nanja));
        Hans.setChildren(List.of(Marga, Mark, Miriam, Inge, Nanja));
        Marga.setChildren(List.of(Nick, Zarra));
        Marga.setSiblings(List.of(Mark, Miriam, Inge, Nanja));
        Roel.setChildren(List.of(Nick, Zarra));
        Nick.setSiblings(List.of(Zarra));
        Nick.setPartner(new Person("Roxanne", null, "de Rojas", "f", 32, null, null, null, null, null));
        Zarra.setPartner(Shay);

        //Pets
        Pet Salem = new Pet("Salem", 8, "Cat");
        Salem.setOwner(Nick);
        Pet Sizzle = new Pet("Doctor Professor Maya Sizzle", 6, "Cat");
        Pet Ammit = new Pet("Ammit", 8, "Royal python");
        Pet Atl = new Pet ("Atl", 16, "Boa constrictor");
        Pet Basil = new Pet("Basil", 3, "Ferret");
        Sizzle.setOwner(Zarra);
        Ammit.setOwner(Zarra);
        Atl.setOwner(Zarra);
        Basil.setOwner(Zarra);
        Pet Bee = new Pet("Bee", 12, "Dog");
        Bee.setOwner(Samantha);
        Pet Fang = new Pet("Fangivilarious Delveorak Superitius the Third", 19, "Corn snake");
        Fang.setOwner(Courtney);


        ///////////////////////////////////////////// Do stuff with all this setup //////////////////////////////////
        System.out.println(Joke.getGrandChildren());
        System.out.println(Hans.getPetsOfGrandChildren());
        System.out.println(Shay.getNieces());
    }
}