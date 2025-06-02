package task_app.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> allUsers() {
    return repository.findAll();
  }

  public Optional<User> findUserById(UUID id) {
    return repository.findById(id);
  }

  public String create(String name, String email, String password, LocalDate birthDate) {
    User user = new User();
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

  public String update(UUID id, String name, String email, String password, LocalDate birthDate) {
    Optional<User> update = this.findUserById(id);
    if (update.isEmpty()) {
      return "Usuário não encontrado";
    }
    User user = update.get();

    if (name != null && !name.equals(user.getName())) {
      user.setName(name);
    }

    if (email != null && !email.equals(user.getEmail())) {
      user.setEmail(email);
    }

    if (password != null && !password.equals(user.getPassword())) {
      user.setPassword(password);
    }

    if (birthDate != null && !birthDate.equals(user.getBirthDate())) {
      user.setBirthDate(birthDate);
    }

    this.repository.save(user);

    return "Usuário atualizado com sucesso";
  }

  public String deleteUser(UUID id) {
    if (id == null) {
      return "Usuário não encontrada.";
    }
    repository.deleteById(id);
    return "Usuário deletada com sucesso";

  }

}
