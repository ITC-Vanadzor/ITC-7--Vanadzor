package com.example.hasmik_n.todolist.handlers;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    private String description;
    private String dueDate;
    private Boolean isSelected;

    public Task(String description, String dueDate, Boolean isSelected) {
        this.description = description;
        this.dueDate = dueDate;
        this.isSelected = isSelected;
    }

    public Task(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        public Task[] newArray(int size) {

            return new Task[size];
        }
    };


    public void readFromParcel(Parcel in) {
        description = in.readString();
        dueDate = in.readString();
        isSelected = in.readByte() != 0;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(dueDate);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}