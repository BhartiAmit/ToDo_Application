package com.app.ToDoApp.service;

import com.app.ToDoApp.models.Task;
import com.app.ToDoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);

    }

    public void toggleTask(long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invallid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
