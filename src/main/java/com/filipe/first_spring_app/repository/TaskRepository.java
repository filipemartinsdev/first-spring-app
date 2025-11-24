package com.filipe.first_spring_app.repository;


import com.filipe.first_spring_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByUserId(long id);

    @Query(value="SELECT * FROM Task t WHERE t.userId = 1;", nativeQuery = true)
    public List<Task> findOfUser1();
}
