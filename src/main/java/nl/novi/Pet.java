package nl.novi;

public class Pet {
    String name;
    int age;
    String species;
    Person owner;

    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
        owner.addPet(this);
    }

    @Override
    public String toString() {
        return owner + " has a " + species + " called " + name; }
}
