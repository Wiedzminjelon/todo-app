package learning.projects.todoapp.repository;

import learning.projects.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Long> {
}
