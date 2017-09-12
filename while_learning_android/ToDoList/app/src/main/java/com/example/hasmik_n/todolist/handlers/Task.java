package com.example.hasmik_n.todolist.handlers;

public class Task{
    private String description;
    private String dueDate;
    private Boolean isSelected;

    public Task(String description, String dueDate, Boolean isSelected) {
        this.description = description;
        this.dueDate = dueDate;
        this.isSelected = isSelected;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}