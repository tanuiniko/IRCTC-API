import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
  private final UserRepository UserRepository;

  @Autowired
  public UserService(UserRepository UserRepository){
    this.UserRepository=UserRepository;
  }

  public List<User> addUser(User user){
    UserRepository.save(user);
    return userRepository.findAll();
  }

  public List<User> getAllUsers() { 
    return userRepository.findAll();
  }
}
