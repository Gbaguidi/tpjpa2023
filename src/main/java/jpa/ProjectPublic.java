package jpa;


import jakarta.persistence.Entity;


@Entity
public class ProjectPublic extends Project {
    private final String state="Public";

    public ProjectPublic(String name, Person user) {
        super(name, user);
    }
}
