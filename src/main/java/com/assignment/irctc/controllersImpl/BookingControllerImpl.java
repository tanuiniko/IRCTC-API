import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingControllerImpl implements BookingApiController{
  private final BookingService bookingService;

  public BookingControllerImpl(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  // @Override
  // public ResponseEntity<List<Booking>> addBooking(String trainId, Integer requiredSeats, User user) {
  //   Booking booking = bookingService.bookTrain(trainId, requiredSeats, user);
  //   if (booking != null) {
  //     return ResponseEntity.ok(booking);
  //   } else {
  //     return ResponseEntity.badRequest().build(); 
  //   }
  // }

  @Override
  public ResponseEntity<Booking> getBookingById(String bookingId) {
    Booking booking = bookingService.getBookingById(bookingId);
    if (booking != null) {
      return ResponseEntity.ok(booking);
    } else {
      return ResponseEntity.notFound().build(); 
    }
  }
}
