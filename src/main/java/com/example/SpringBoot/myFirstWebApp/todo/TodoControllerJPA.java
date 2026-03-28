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

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    private todoUserRepository todoUserRepository;

    public TodoControllerJPA( todoUserRepository todoUserRepository) {
        super();
        this.todoUserRepository = todoUserRepository;
    }

    @RequestMapping("/todoList")
    public String getTodoList(ModelMap map){
        String userName = getLoggedInUserName();
        List<todoUser> myList = todoUserRepository.findByUserName(userName);
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
        String userName = getLoggedInUserName();
        todoUser.setUserName(userName);
       todoUserRepository.save(todoUser);

        return "redirect:todoList";
    }
    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoUserRepository.deleteById(id);

        return "redirect:todoList";
    }
    @RequestMapping(value="/update-todo",method = RequestMethod.GET)
    public String showUpdatedTodo(@RequestParam int id,ModelMap map){

        todoUser todoUser= todoUserRepository.findById(id).get();
        map.addAttribute("todoUser",todoUser);

        return "todo";
    }
    @RequestMapping(value="/update-todo",method = RequestMethod.POST)
    public String updatedTodo( @Valid todoUser todoUser, BindingResult result){

        if(result.hasErrors()){
            return "todo";
        }
//        todoService.updateTodo(todoUser);
todoUserRepository.save(todoUser);
        return "redirect:todoList";
    }
    private static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        return authentication.getName();
    }
}
