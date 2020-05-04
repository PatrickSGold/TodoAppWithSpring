package com.example.SpringTodoApplication.controller;

import com.example.SpringTodoApplication.model.Todos;
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
        List<Todos> listTodos = service.listAll();
        model.addAttribute("listTodos", listTodos);

        return "index";
     }


    @RequestMapping("/new")
    public String showNewTaskForm(Model model) {
        Todos todos = new Todos();
        model.addAttribute("Todo", todos);
        return "new_task";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("Task") Todos task) {
        service.save(task);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTaskForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_task");

        Todos todo = service.get(id);
        mav.addObject("Todo", todo);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") int id) {
        service.delete(id);

        return "redirect:/";
    }



}
