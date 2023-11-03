import domain.entity.Objective;
import domain.entity.ProgressRecord;
import domain.enums.CompletionStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ServiceProgressTracker;
import service.UserService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ServiceProgressTracker serviceProgressTracker = context.getBean("serviceProgressTracker", ServiceProgressTracker.class);

        Objective objective = new Objective();
        objective.setTitle("Sample Objective");
        objective.setDescription("Sample Description");
        objective.setStart_date(new Date());
        objective.setEnd_date(new Date());
        objective.setCompletion_status(CompletionStatus.NOT_STARTED);
        serviceProgressTracker.assignObjectiveToUser(3, objective);

        serviceProgressTracker.updateProgress(1, 50);

        List<ProgressRecord> progressRecords = serviceProgressTracker.trackAchievements(1);

        for (ProgressRecord record : progressRecords) {
            System.out.println("-------------");
            System.out.println("Progress Record ID: " + record.getRecord_id());
            System.out.println("Date: " + record.getDate());
            System.out.println("Value: " + record.getValue());
            System.out.println("Status: " + record.getObjective().getCompletion_status());
            System.out.println("Objective: " + record.getObjective().getTitle());
            System.out.println("-------------");
        }
    }
}

