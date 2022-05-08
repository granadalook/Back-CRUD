package com.example.demo.Controller;

import com.example.demo.Model.todo;
import com.example.demo.Service.TodoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Data
@CrossOrigin
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public ArrayList<todo> getTodos() {
        return todoService.gettodos();
    }

    @PutMapping(path = "/save")
    public todo saveTodos(@RequestBody todo todo) {
        return todoService.savetodo(todo);
    }
    @GetMapping(path = "/{id}")
    public Optional<todo> getForID(@PathVariable("id") Long id) {
    return todoService.getForID(id);
    }
    @PutMapping(path = "/actualizar/{id}")
    todo actualizarTodo(@RequestBody todo nuevoTodo, @PathVariable Long id) {

        return todoService.getForID(id)
                .map(todo -> {
                    todo.setNota(nuevoTodo.getNota());
                    todo.setCompletada(nuevoTodo.isCompletada());
                    return saveTodos(todo);
                })
                .orElseGet(() -> extraer(nuevoTodo, id));
    }
    private todo extraer(todo nuevoTodo, Long id) {
        nuevoTodo.setId(id);
        return saveTodos(nuevoTodo);
    }
    @DeleteMapping(path = "delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        boolean ok = this.todoService.deletetodo(id);
        if (ok) {
            return "Se elimino todo " + id;
        } else {
            return "no se elimino todo" + id;
        }
    }
}
