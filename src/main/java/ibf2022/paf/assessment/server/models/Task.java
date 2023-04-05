package ibf2022.paf.assessment.server.models;

import java.util.Date; 

// TODO: Task 4

public class Task {

    private Integer taskId; 
    private String description; 
    private Integer priority; 
    private Date dueDate; 
    private String usertableId; 

    public String getUsertableId() {
        return usertableId;
    }
    public void setUsertableId(String usertableId) {
        this.usertableId = usertableId;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date date) {
        this.dueDate = date;
    }
    public Integer getTaskId() {
        return taskId;
    }
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 
}
