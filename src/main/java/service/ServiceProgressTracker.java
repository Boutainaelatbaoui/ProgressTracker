package service;

import domain.entity.Objective;
import domain.entity.ProgressRecord;
import domain.entity.Team;
import domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class ServiceProgressTracker {

    private UserService userService;
    private Objective objective;
    private ProgressRecord progressRecord;

    public ServiceProgressTracker(UserService userService) {
        this.userService = userService;
    }

    public void assignObjectiveToUser(int userId, Objective objective) {
        userService.assignObjectiveToUser(userId, objective);
    }

    public void updateProgress(int processId, int value) {
        userService.updateProgress(processId, value);
    }

    public List<ProgressRecord> trackAchievements(int objectiveId) {
        return userService.trackAchievements(objectiveId);
    }
}

