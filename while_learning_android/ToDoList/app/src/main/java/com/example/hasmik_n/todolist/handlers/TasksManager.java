package com.example.hasmik_n.todolist.handlers;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is not used
 */
public class TasksManager {
    private List<Task> tasksList;
    private List<Task> finishedTasksList;

    public TasksManager() {
        tasksList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Task st = new Task("Task Description - " + i, "Task Due Date - " + i, false);
            tasksList.add(st);
        }
    }

    public void addTaskToList(Task task){
        this.tasksList.add(task);
    }

    public List<Task> getTasksList(){
        return this.tasksList;
    }


}

