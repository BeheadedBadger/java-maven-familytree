package nl.novi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<Person>();
    private List<Person> children = new ArrayList<Person>();
    private Person partner;
    private List<Pet> pets = new ArrayList<Pet>();

    public Person(String name, String middleName, String lastName, String sex, int age, Person mother, Person father, List<Person> siblings, List<Person> children, List<Pet> pets) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;

        if (siblings != null) {
            this.siblings = siblings;
        }
        if (children != null) {
            this.children = children;
        }
        if (pets != null) {
            this.pets = pets;
        }
    }

    public Person(String name, String middleName, String lastName, String sex, List<Person> siblings, ArrayList<Person> children) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        if (siblings != null) {
            this.siblings = siblings;
        }
        if (children != null) {
            this.children = children;
        }
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addChild(Person child) {
        ArrayList<Person> newListChildren = new ArrayList<>(children);
        newListChildren.add(child);

        this.children = newListChildren;
    }

    public void addSibling(Person sibling) {
        ArrayList<Person> newListSiblings = new ArrayList<>(siblings);
        newListSiblings.add(sibling);

        this.siblings = newListSiblings;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        ArrayList<Pet> newListPets = new ArrayList<>(pets);
        newListPets.add(pet);

        this.pets = newListPets;
    }

    public String getSex() {
        return sex;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child : children) {
            if (child.getChildren() != null) {
                List<Person> newGrandChildren = child.getChildren();
                grandChildren.addAll(newGrandChildren);
            }
        }

        return grandChildren;
    }

    public List<Pet> getPetsOfGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        for (Person child : children) {
            if (child.getChildren() != null) {
                List<Person> newGrandChildren = child.getChildren();
                grandChildren.addAll(newGrandChildren);
            }
        }

        List<Pet> grandChildrenPets = new ArrayList<>();
        for (Person grandChild : grandChildren) {
            if (grandChild.getPets() != null) {
                List<Pet> newgrandChildrenPets = grandChild.getPets();
                grandChildrenPets.addAll(newgrandChildrenPets);
            }
        }

        return grandChildrenPets;
    }


    public List<Person> getNieces()
    {
        List<Person> nieces = new ArrayList<>();
        for (Person sibling : siblings) {
            if (sibling.getChildren() != null) {
                List<Person> childrenOfSiblings  = sibling.getChildren();
                for (Person child : childrenOfSiblings) {
                    if (child.getSex().equals("f"))
                    {
                        nieces.add(child);
                    }
                }
            }
        }

        return nieces;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
