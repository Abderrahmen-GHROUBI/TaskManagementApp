package com.fullstack.Taskmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fullstack.Taskmanagement.DTO.CountType;
import com.fullstack.Taskmanagement.Entity.Task;

public interface Taskrepository extends JpaRepository<Task,Long> {
    
    @Query(value = "select * from task order by due_date desc",nativeQuery = true)
    public List<Task> getAllTaskByDueDate();


    @Query(value = "select new com.fullstack.Taskmanagement.DTO.CountType(COUNT(*)/(Select COUNT(*) from Task)*100, type) from Task GROUP BY type")
    public List<CountType> getPercentageGroupByType();
}
