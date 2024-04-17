import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserApiController {
  private final UserService userService;

  public UserControllerImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ResponseEntity<List<User>> addUser(User user) {
    User addedUser = userService.addUser(user);
    return ResponseEntity.ok(addedUser);
  }

}
