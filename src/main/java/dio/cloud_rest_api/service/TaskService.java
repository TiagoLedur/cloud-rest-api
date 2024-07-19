package dio.cloud_rest_api.service;

import dio.cloud_rest_api.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task findById (Long id);
    Task create (Task taskToCreate);
    List<Task> showTasks ();
    Task atualizarEstado (Long id, String estado);
    Optional<Task> findByNome (String nome);

}
