package jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Project {

    private Long id;
    private String name;
    private Person owner;

    private List<Issue> issues= new ArrayList<Issue>();

    public Project(String name, Person user ){
        this.setName(name);
        this.setOwner(user);
    }
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToOne
    public Person getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Project [Project-id=" + id + ", Project-name=" + name + ", Project-owner="
                + owner.toString() + "]";
    }
}
