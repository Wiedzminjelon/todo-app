package learning.projects.todoapp.repository;

import learning.projects.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Task task);

    @RestResource(path = "done", rel = "done")
    List<Task> findAllByDone(@Param("state") boolean done);

}
