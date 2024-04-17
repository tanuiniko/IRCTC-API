import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class BookingService {
  private final BookingRepository bookingRepository;
    private final TrainRepository trainRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, TrainRepository trainRepository) {
      this.bookingRepository = bookingRepository;
      this.trainRepository = trainRepository;
    }

    public List<Booking> addBooking(String trainId, Integer requiredSeats, User user) {
      Optional<Train> trainOptional = trainRepository.findById(trainId);
      if (trainOptional.isPresent()) {
        Train train = trainOptional.get();
        if (train.getSeats() >= requiredSeats) {
          train.setSeats(train.getSeats() - requiredSeats);
          trainRepository.save(train);

          Booking booking = new Booking();
          booking.setUser(user);
          booking.setTrain(train);
          booking.setSeats(requiredSeats);
          booking.setStatus(Booking.StatusEnum.COMPLETED);
          bookingRepository.save(booking);
          return bookingRepository.findAll();
        }
      }
      return null;
    }

    public Booking getBookingById(String bookingId) {
      Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
      return bookingOptional.orElse(null); 
    }

}
