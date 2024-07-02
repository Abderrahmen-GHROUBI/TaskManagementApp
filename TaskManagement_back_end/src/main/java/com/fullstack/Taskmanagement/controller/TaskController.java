package com.fullstack.Taskmanagement.controller;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.Taskmanagement.DTO.CountType;
import com.fullstack.Taskmanagement.Entity.Task;
import com.fullstack.Taskmanagement.service.TaskService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class TaskController {

    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTasks(){
        
        return taskService.getTasks();
    }


    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id)
    {
         return taskService.getTaskById(id).
         orElseThrow(
            ()-> new EntityNotFoundException("Requested task not found")
         );
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskService.save(task);

    }
    @Transactional
    @GetMapping("/task/vData/percentCountType")
    List<CountType> getPercentageGroupByType()
    {
        return taskService.getPercentageGroupByType();
    }

    @Transactional
    @PutMapping("task/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task task, @PathVariable Long id  )
    {
        if (taskService.existById(id))
        {
            Task task1 = taskService.getTaskById(id).orElseThrow
            (
                ()->new EntityNotFoundException("Requested task not found")
            );
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setDueDate(task.getDueDate());
            task1.setType(task.getType());
            taskService.save(task1);
            //returned type Task
            return ResponseEntity.ok().body(task1);

        }
        else
        {

            HashMap<String,String> message = new HashMap<>();
            message.put("message",id +" task not found or matched");
            //return type hashmap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }


        
    }
    @DeleteMapping("task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id)
    {
        if(taskService.existById(id))
        {
            taskService.deleteTask(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message ", "Task with id "+id+" delete successfully.");
            //returned type hashmap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        }
        else
        {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id +" task not found or matched");
            //returned type hashmap
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    

     
}
