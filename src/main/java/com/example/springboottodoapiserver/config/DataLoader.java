package com.example.springboottodoapiserver.config;

import com.example.springboottodoapiserver.models.TodoItem;
import com.example.springboottodoapiserver.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.time.Instant;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception{
        List<TodoItem> todos = (List<TodoItem>) todoItemRepository.findAll();
        if(todos.size() == 0){
            TodoItem todo1 = new TodoItem();

            todo1.setDescription("Hello world");
            todo1.setCreatedDate(Instant.now());

            todoItemRepository.save(todo1);
        }
    }
}
