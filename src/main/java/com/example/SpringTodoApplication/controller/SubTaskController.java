package com.example.SpringTodoApplication.controller;

import com.example.SpringTodoApplication.model.SubTask;
import com.example.SpringTodoApplication.model.Todo;
import com.example.SpringTodoApplication.service.SubTaskService;
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
public class SubTaskController {

    @Autowired
    SubTaskService subTaskService;

    @Autowired
    TaskService taskService;


    @RequestMapping("/subtasks/{id}")
    public String viewSubtasks(@PathVariable(name = "id") Long id, Model model) {
        List<SubTask> listOfSubTasks = taskService.get(id).getSubTasks();

        model.addAttribute("listOfSubTasks", listOfSubTasks);
        model.addAttribute("todoId", id);

        return "subtasks";
    }

    @RequestMapping("/new_subtask/{id}")
    public String newSubtask(@PathVariable(name = "id") Long id, Model model) {
        SubTask subTask = new SubTask();
        subTask.setTodo_id(id);

        model.addAttribute("Subtask", subTask);

        return "new_subtask";
    }

    @RequestMapping(value = "/save_subtask", method = RequestMethod.POST)
    public String saveSubtask(@ModelAttribute("Subtask") SubTask subTask) {
        subTaskService.save(subTask);
        Long id = subTask.getTodo_id();

        return "redirect:/subtasks/" + id;
    }

    @RequestMapping("/edit_subtask/{id}")
    public ModelAndView editSubtask(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_subtask");

        SubTask subTask = subTaskService.get(id);
        mav.addObject("Subtask", subTask);

        return mav;
    }

    @RequestMapping("/delete_subtask/{id}")
    public String deleteSubtask(@PathVariable(name = "id") Long id) {
        Long todoId = subTaskService.get(id).getTodo_id();
        subTaskService.delete(id);

        return "redirect:/subtasks/" + todoId;
    }








}


