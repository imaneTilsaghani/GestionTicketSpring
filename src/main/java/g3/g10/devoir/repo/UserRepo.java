package g3.g10.devoir.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import g3.g10.devoir.models.User;

public interface UserRepo<T extends User> extends JpaRepository<T, Integer> {

    Optional<List<T>> findByRole(String role);

    Optional<T> findByEmail(String email);
}

