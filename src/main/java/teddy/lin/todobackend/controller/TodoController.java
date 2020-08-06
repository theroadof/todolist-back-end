package teddy.lin.todobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import teddy.lin.todobackend.dto.RequestTodo;
import teddy.lin.todobackend.dto.ResponseTodo;
import teddy.lin.todobackend.model.Todo;
import teddy.lin.todobackend.service.TodoService;

import java.util.List;

import static java.util.Objects.isNull;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseTodo add(@RequestBody RequestTodo requestTodo){
        if (isNull(requestTodo)){

        }
        return todoService.save(requestTodo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseTodo update(@PathVariable Integer id,@RequestBody RequestTodo requestTodo){
        return todoService.update(id,requestTodo);
    }
}
