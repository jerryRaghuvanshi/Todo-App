package com.example.SpringBoot.myFirstWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("/todoList")
    public String getTodoList(ModelMap map){
        String userName = getLoggedInUserName();
        List<todoUser> myList = todoService.findTodoListByUserName(userName);
        map.addAttribute("todos",myList);


        return "todoList";
    }



    @RequestMapping(value="/add-todo",method = RequestMethod.GET)
    public String showNewTodoList(ModelMap map){
        todoUser todoUser = new todoUser(0,"","",LocalDate.now().plusYears(1),false);
        map.put("todoUser",todoUser);
        return "todo";
    }
    @RequestMapping(value="/add-todo",method = RequestMethod.POST)
    public String addNewTodoList(@Valid todoUser todoUser, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
        todoService.addNewTodo(todoUser.getUserName(),todoUser.getDescription(),
                todoUser.getTargetDate(),false);

        return "redirect:todoList";
    }
    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);

        return "redirect:todoList";
    }
    @RequestMapping(value="/update-todo",method = RequestMethod.GET)
    public String showUpdatedTodo(@RequestParam int id,ModelMap map){

        todoUser todoUser= todoService.findById(id);
        map.addAttribute("todoUser",todoUser);

        return "todo";
    }
    @RequestMapping(value="/update-todo",method = RequestMethod.POST)
    public String updatedTodo( @Valid todoUser todoUser, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
        todoService.updateTodo(todoUser);

        return "redirect:todoList";
    }
    private static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        return authentication.getName();
    }
}
