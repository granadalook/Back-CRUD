package com.example.demo.Service;

import com.example.demo.Model.todo;
import com.example.demo.Repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoService {
    TodoRepository todoRepository;

    public ArrayList<todo> gettodos() {
        return (ArrayList<todo>) todoRepository.findAll();
    }

    public todo savetodo(todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<todo> getForID(Long id) {
        return todoRepository.findById(id);
    }

    public boolean deletetodo(Long id) {
        try {
            todoRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
