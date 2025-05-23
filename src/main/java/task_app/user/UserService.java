package task_app.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<UserModel> allUsers() {
    return repository.findAll();
  }

  public String create(String name, String email, String password, LocalDate birthDate) {
    UserModel user = new UserModel();
    if (name == null && email == null && password == null && birthDate == null) {
      return "todos os campos precisam ser preenchidos";
    }
    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);
    user.setBirthDate(birthDate);
    repository.save(user);
    return "Usuário criado com sucesso";
  }

}
