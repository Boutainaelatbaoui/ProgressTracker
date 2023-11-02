package domain.entity;

import domain.enums.CompletionStatus;

import javax.persistence.*;
import java.util.*;

@Entity
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int objective_id;

    private String title;
    private String description;
    private Date start_date;
    private Date end_date;

    @Enumerated(EnumType.STRING)
    private CompletionStatus completion_status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProgressRecord> progressRecords;

    public int getObjective_id() {
        return objective_id;
    }

    public void setObjective_id(int objective_id) {
        this.objective_id = objective_id;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public CompletionStatus getCompletion_status() {
        return completion_status;
    }

    public void setCompletion_status(CompletionStatus completion_status) {
        this.completion_status = completion_status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProgressRecord> getProgressRecords() {
        return progressRecords;
    }

    public void setProgressRecords(List<ProgressRecord> progressRecords) {
        this.progressRecords = progressRecords;
    }
}
