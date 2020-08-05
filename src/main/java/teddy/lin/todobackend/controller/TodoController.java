package teddy.lin.todobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import teddy.lin.todobackend.dto.ResponseTodo;
import teddy.lin.todobackend.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ResponseTodo> getAll(){
        return todoService.getAll();
    }

}
