package dio.cloud_rest_api.controller;

import dio.cloud_rest_api.domain.model.Task;
import dio.cloud_rest_api.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        var task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Task> atualizarEstado(@PathVariable Long id, @RequestParam String novoEstado) {
        Task task = taskService.atualizarEstado(id, novoEstado);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/byNome/{nome}")
    public ResponseEntity<Optional<Task>> findByNome(@PathVariable String nome) {
        var task = taskService.findByNome(nome);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> showTasks () {
        List<Task> tasks = taskService.showTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task taskToCreate) {
        var taskCreated = taskService.create(taskToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(taskCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(taskCreated);
    }

}
