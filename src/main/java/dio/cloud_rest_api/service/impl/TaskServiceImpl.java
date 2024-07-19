package dio.cloud_rest_api.service.impl;

import dio.cloud_rest_api.domain.model.Task;
import dio.cloud_rest_api.domain.repository.TaskRepository;
import dio.cloud_rest_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task atualizarEstado(Long tarefaId, String novoEstado) {
        Optional<Task> tarefaOpt = taskRepository.findById(tarefaId);

        if (tarefaOpt.isPresent()) {
            Task task = tarefaOpt.get();
            task.setEstado(novoEstado);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
    }

    @Override
    public Optional<Task> findByNome(String nome) {
        return Optional.ofNullable(taskRepository.findByNome(nome)
                .orElseThrow(() -> new NoSuchElementException("Task not found with name " + nome)));
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found with id " + id));
    }

    @Override
    public Task create(Task taskToCreate) {
        if (taskRepository.existsByNome(taskToCreate.getNome())){
            throw new IllegalArgumentException("This task already exists");
        }
        return taskRepository.save(taskToCreate);
    }

    @Override
    public List<Task> showTasks() {
        return taskRepository.findAll();
    }

}
