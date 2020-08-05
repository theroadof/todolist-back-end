package teddy.lin.todobackend.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import teddy.lin.todobackend.dto.ResponseTodo;
import teddy.lin.todobackend.mapper.TodoMapper;
import teddy.lin.todobackend.model.Todo;
import teddy.lin.todobackend.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private TodoMapper todoMapper;

    @InjectMocks
    private TodoService todoService;

    @Test
    void should_return_all_todos_when_get_all_given_none() {
        //given
        Todo todo = new Todo(1,"first todo",true);
        List<Todo> todos = singletonList(todo);
        List<ResponseTodo> responseTodoList = singletonList(new ResponseTodo(1,"first todo",true));
        when(todoRepository.findAll()).thenReturn(todos);
        when(todoMapper.toResponseTodos(todos)).thenReturn(responseTodoList);

        //when
        List<ResponseTodo> responseTodos = todoService.getAll();

        //then
        assertEquals(1,responseTodos.size());
        assertEquals(responseTodoList.get(0).getId(),responseTodos.get(0).getId());
    }
}
