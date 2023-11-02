package domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProgressRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int record_id;

    private Date date;
    private int value;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
