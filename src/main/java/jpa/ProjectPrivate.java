package jpa;


import jakarta.persistence.Entity;


@Entity
public class ProjectPrivate extends Project {
    private final String state="Private";

    public ProjectPrivate(String name, Person user) {
        super(name, user);
    }
}
