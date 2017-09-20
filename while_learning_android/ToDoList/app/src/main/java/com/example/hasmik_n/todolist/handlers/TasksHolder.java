package com.example.hasmik_n.todolist.handlers;

import java.util.ArrayList;

public class TasksHolder {
    private ArrayList<Task> tasksList = new ArrayList<>();
    private ArrayList<Task> finishedTasksList = new ArrayList<>();
    public TasksHolder() {
        // TODO Should get data from DB
    }

    public ArrayList<Task> getTasksList(){
        return this.tasksList;
    }
    public ArrayList<Task> getFinishedTasksList(){
        return this.finishedTasksList;
    }
    public void addToFinishedTasksList(Task task){
        this.finishedTasksList.add(task);
    }
}
