package armando.stringsearch.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import armando.stringsearch.model.Strings;

public interface StringRepo extends JpaRepository<Strings, Long> {

    void deleteStringById(Long id);

    Optional<Strings> findStringById(Long id);
    
}
