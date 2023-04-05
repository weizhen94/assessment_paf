package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertTask(Task task){

        String insertSQL = "insert into task (description, priority, due_date, usertable_id) values (?, ?, ?, ?)";
        
        jdbcTemplate.update(insertSQL, task.getDescription(), task.getPriority(), task.getDueDate(), task.getUsertableId());
    }
    
}
