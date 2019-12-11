/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp.model;

/**
 *
 * @author kcwill1231
 */
public class Task {
    private long datecreated;
    private String description;
    private String task;
    
    public Task() {
    }
    
    public long getDatecreated(){
        return datecreated;
    }
    
    public void setDatecreated(long datecreated){
        this.datecreated = datecreated;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTask() {
        return task;
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    
    
    
    
}
