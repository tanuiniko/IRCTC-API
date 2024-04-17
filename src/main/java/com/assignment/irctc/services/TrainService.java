import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
  private final TrainRepository trainRepository;

  @Autowired
  public TrainService(TrainRepository trainRepository) {
    this.trainRepository = trainRepository;
  }

  public Train addTrain(Train train) {
    return trainRepository.save(train);
  }

  public int getAvailableSeats(String source, String destination) {
    Optional<Train> trainOptional = trainRepository.findBySourceAndDestination(source, destination);
    return trainOptional.map(Train::getSeats).orElse(0);
  }

  public void updateSeatsAvailable(String trainId, int seatsAvailable) {
    Optional<Train> trainOptional = trainRepository.findById(trainId);
    trainOptional.ifPresent(train -> {
      train.setSeats(seatsAvailable);
      trainRepository.save(train);
    });
  }
}
