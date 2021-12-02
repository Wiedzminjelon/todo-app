package learning.projects.todoapp.controller;

import learning.projects.todoapp.model.Task;
import learning.projects.todoapp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RepositoryRestController
public class TaskController {
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    public ResponseEntity<List<Task>> readAllTasks() {
        logger.info("Reading all tasks from repository");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> readAllTasks(Pageable pageable) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(taskRepository.findAll(pageable).getContent());
    }
}
