package jpa;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "person")
public class Person {
    private Long id;
    private String name;
    private List<Issue> issuesCreated;
    private List<Project> projectOwned= new ArrayList<Project>();
    private List<Issue> issuesClosed;
    private List<Issue> issuesHandled;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    public List<Issue> getIssuesCreated() {
        return issuesCreated;
    }

    public void setIssuesCreated(List<Issue> issuesCreated) {
        this.issuesCreated = issuesCreated;
    }
    @OneToMany(mappedBy = "closer", cascade = CascadeType.PERSIST)
    public List<Issue> getIssuesClosed() {
        return issuesClosed;
    }

    public void setIssuesClosed(List<Issue> issuesClosed) {
        this.issuesClosed = issuesClosed;
    }

    @ManyToMany(mappedBy = "teamMembers", cascade = CascadeType.PERSIST)
    public List<Issue> getIssuesHandled() {
        return issuesHandled;
    }
    public void setIssuesHandled(List<Issue> issuesHandled) {
        this.issuesHandled = issuesHandled;
    }
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    public List<Project> getProjectOwned() {
        return projectOwned;
    }

    public void setProjectOwned(List<Project> projectOwned) {
        this.projectOwned = projectOwned;
    }

    @Override
    public String toString() {
        return "User [User-id=" + id + ", User-name=" + name + "]";
    }
}
