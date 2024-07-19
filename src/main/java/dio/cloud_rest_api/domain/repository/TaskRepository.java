package dio.cloud_rest_api.domain.repository;

import dio.cloud_rest_api.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

    boolean existsByNome (String nome);
    Optional<Task> findByNome(String nome);

}
