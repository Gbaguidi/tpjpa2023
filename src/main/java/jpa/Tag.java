package jpa;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Tag {
    private Long id;
    private String title;
    private String description;
    private Project project;
    private List<Issue> issues = new ArrayList<Issue>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    @ManyToMany(mappedBy = "tags", cascade = CascadeType.PERSIST)
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Tag [Tag-id=" + id + ", Tag-name=" + title + ", Project=" + project.toString() + "]";
    }
}
