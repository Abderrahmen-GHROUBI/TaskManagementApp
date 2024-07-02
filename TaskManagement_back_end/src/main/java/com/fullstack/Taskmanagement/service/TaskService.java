package com.fullstack.Taskmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fullstack.Taskmanagement.DTO.CountType;
import com.fullstack.Taskmanagement.Entity.Task;
import com.fullstack.Taskmanagement.repository.Taskrepository;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    private Taskrepository taskRepository;



    @Transactional
    public List<Task> getTasks()
    {
        return taskRepository.getAllTaskByDueDate();
    }
    
    @Transactional
    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }
    
    @Transactional
    public Task save(Task task){
        return taskRepository.saveAndFlush(task);
    }
    
    @Transactional
    public boolean existById(Long id)
    {
        return taskRepository.existsById(id);
    }

    @Transactional
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public List<CountType> getPercentageGroupByType()
    {
        return taskRepository.getPercentageGroupByType();
    }
    


}
