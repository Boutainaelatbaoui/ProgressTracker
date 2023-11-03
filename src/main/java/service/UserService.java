package service;

import domain.entity.Objective;
import domain.entity.ProgressRecord;
import domain.entity.User;
import repository.ObjectiveRepository;
import repository.ProgressRepository;
import repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private final ObjectiveRepository objectiveRepository;
    private final ProgressRepository progressRepository;

    public UserService(UserRepository userRepository, ObjectiveRepository objectiveRepository, ProgressRepository progressRepository) {
        this.userRepository = userRepository;
        this.objectiveRepository = objectiveRepository;
        this.progressRepository = progressRepository;
    }

    public void assignObjectiveToUser(int userId, Objective objective) {
        User user = userRepository.findById(userId);
        if (user != null) {
            objective.setUser(user);
            objectiveRepository.save(objective);
        }
    }

    public void updateProgress(int processId, int value) {
        Optional<ProgressRecord> optionalProgressRecord = progressRepository.findById(processId);
        if (optionalProgressRecord.isPresent()) {
            ProgressRecord progressRecord = optionalProgressRecord.get();
            progressRecord.setValue(value);
            progressRepository.save(progressRecord);
        }
    }

    public List<ProgressRecord> trackAchievements(int objectiveId) {
        return progressRepository.findByObjectiveId(objectiveId);
    }

}
