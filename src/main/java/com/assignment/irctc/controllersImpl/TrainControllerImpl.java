import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainControllerImpl implements TrainApiController{
  private final TrainService trainService;

  public TrainControllerImpl(TrainService trainService) {
    this.trainService = trainService;
  }

  @Override
  public ResponseEntity<Train> getTrain(String source, String destination) {
    int availableSeats = trainService.getAvailableSeats(source, destination);
    return ResponseEntity.ok(availableSeats);
  }
}
