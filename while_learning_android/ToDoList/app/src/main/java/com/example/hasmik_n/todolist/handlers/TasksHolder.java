package com.example.hasmik_n.todolist.handlers;

import java.util.ArrayList;

public class TasksHolder {
    private ArrayList<Task> tasksList = new ArrayList<>();
    private ArrayList<Task> finishedTasksList = new ArrayList<>();
    public TasksHolder() {
        for (int i = 1; i <= 1; i++) {
            Task st = new Task("Task Description - " + i, "Task Due Date - " + i, false);
            finishedTasksList.add(st);
            tasksList.add(st);
        }
    }

    public void addTaskToList(Task task){
        this.tasksList.add(task);
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
