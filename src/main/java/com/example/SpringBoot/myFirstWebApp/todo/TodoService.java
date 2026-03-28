package com.example.SpringBoot.myFirstWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<todoUser> listOfTodos=new ArrayList<>();
    private static int todoCount=0;

    static {
                listOfTodos.add(new todoUser(
                ++todoCount,
                "jay",
                "my first Todo",
                LocalDate.now().plusYears(1),
                false));

                listOfTodos.add(new todoUser(
                        ++todoCount,
                "jay",
                "my first Todo",
                LocalDate.now().plusYears(1),
                false));

                listOfTodos.add(new todoUser(
                        ++todoCount,
                "jay",
                "my first Todo",
                LocalDate.now().plusYears(1),
                false));
    }
    public List<todoUser> findTodoListByUserName(String userName){
        Predicate<?super todoUser> predicate=
                todoUser -> todoUser.getUserName().equalsIgnoreCase(userName);
        return listOfTodos.stream().filter(predicate).toList();

    }
    public void addNewTodo( String userName,
                               String description,
                               LocalDate localDate,
                               boolean done){
        todoUser newTodo =new todoUser(++todoCount,userName
                ,description,localDate,done);
        listOfTodos.add(newTodo);
    }
    public void deleteById(int id){
        Predicate<?super todoUser> predicate=
                todoUser -> todoUser.getId()==id;
        listOfTodos.removeIf(predicate);
    }

    public todoUser findById(int id) {
        Predicate<?super todoUser> predicate=

                todoUser -> todoUser.getId()==id;
        return listOfTodos.stream().filter(predicate)
                .findFirst().get();


    }

    public void updateTodo(@Valid todoUser todoUser) {
        deleteById(todoUser.getId());
        listOfTodos.add(todoUser);
    }
}
