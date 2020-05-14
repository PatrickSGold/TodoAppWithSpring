package com.example.SpringTodoApplication.controller;

import com.example.SpringTodoApplication.model.Todo;
import com.example.SpringTodoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class TaskController {

    @Autowired
    private TaskService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Todo> listTodos = service.listAll();
        model.addAttribute("listTodos", listTodos);

        return "index";
     }

    @RequestMapping("/new_task")
    public String showNewTaskForm(Model model) {
        Todo todo = new Todo();
        model.addAttribute("Todo", todo);
        return "new_task";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("Task") Todo task) {
        service.save(task);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTaskForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_task");

        Todo todo = service.get(id);
        mav.addObject("Todo", todo);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/";
    }

    @RequestMapping("/go_back/")
    public String goBack() {
        return "redirect:/";
    }




}
