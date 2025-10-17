package com.microapp.microp1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microapp.microp1.model.Task;
import com.microapp.microp1.services.TaskServices;

@Controller
// @RequestMapping("/tasks")
public class TaskController {
    private final TaskServices taskServices;
    public TaskController(TaskServices taskServices){
        this.taskServices=taskServices;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks=taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskServices.createTask(title);
        return "redirect:/ ";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskServices.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskServices.toggleTask(id);
        return "redirect:/";
    }
}
