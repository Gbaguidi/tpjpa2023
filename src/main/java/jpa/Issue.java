package jpa;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
public class Issue {
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)

    private IssueState state;

    private Date openDate;
    private Date closeDate;
    private Project project;
    private String title;
    private Person author;
    private Person closer;
    private List<Tag> tags = new ArrayList<Tag>();
    private List<Message> messages= new ArrayList<Message>();
    private List<Person> teamMembers= new ArrayList<Person>();


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    @ManyToOne
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person user) {
        this.author = user;
    }

    @ManyToMany(mappedBy = "issues", cascade = CascadeType.PERSIST)
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "issue", cascade = CascadeType.PERSIST)
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @ManyToOne
    public Person getCloser() {
        return closer;
    }

    public void setCloser(Person closer) {
        this.closer = closer;
    }

    @ManyToMany(mappedBy = "issues", cascade = CascadeType.PERSIST)
    public List<Person> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Person> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "Issue [Issue-id=" + id + ",Issue-title=" + title + ",Issue-author=" + author.toString() +",Issue-closer=" + closer.toString() + "]";
    }

}
