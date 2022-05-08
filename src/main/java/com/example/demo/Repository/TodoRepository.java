package com.example.demo.Repository;

import com.example.demo.Model.todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<todo, Long> {
}
