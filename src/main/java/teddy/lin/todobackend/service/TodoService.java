package teddy.lin.todobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teddy.lin.todobackend.dto.RequestTodo;
import teddy.lin.todobackend.dto.ResponseTodo;
import teddy.lin.todobackend.mapper.TodoMapper;
import teddy.lin.todobackend.model.Todo;
import teddy.lin.todobackend.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    public List<ResponseTodo> getAll() {
        List<Todo> todos = todoRepository.findAll();
        return todoMapper.toResponseTodos(todos);
    }

    public ResponseTodo save(RequestTodo requestTodo) {
        Todo todo = todoMapper.toTodo(requestTodo);
        return todoMapper.toResponseTodo(todoRepository.save(todo));
    }
}
