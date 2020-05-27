package com.todo.app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TodoDataAccessService {

    private final JdbcTemplate databaseRef;

    @Autowired
    public TodoDataAccessService(JdbcTemplate databaseRef){
        this.databaseRef = databaseRef;
    }

    List<Todo> getAllTodo () {
        String sql = "SELECT id, title, description FROM todo";

        return databaseRef.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");

            return new Todo(id, title, description);
        });
    }

    public Todo getItemById (UUID itemId) {
        String sql = "SELECT id, title, description FROM todo WHERE id = ?";

        return databaseRef.queryForObject(sql, new Object[]{itemId},(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");

            return new Todo(id, title, description);
        });
    }

    public int insertTodoItem(UUID id, Todo item){
        String sql = "INSERT INTO todo VALUES (?,?,?)";
        return databaseRef.update(sql, id, item.getTitle(), item.getDescription());
    }

    public int deleteItemById(UUID id) {
        String sql = "DELETE FROM todo where id = ?";
        return databaseRef.update(sql, id);
    }

    int updateTodoItem(UUID id, Todo item){
        String sql = "UPDATE todo SET title=?, description=? WHERE id = ?";
        return databaseRef.update(sql, item.getTitle(), item.getDescription(), id);
    }



}
