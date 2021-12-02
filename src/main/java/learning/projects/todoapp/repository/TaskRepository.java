package learning.projects.todoapp.repository;

import learning.projects.todoapp.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task entity);

    Page<Task> findAll(Pageable pageable);

    List<Task> findByDone(@Param("state") boolean done);
}
