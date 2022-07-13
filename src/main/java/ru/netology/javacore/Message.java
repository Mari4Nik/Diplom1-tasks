package ru.netology.javacore;

public class Message {

    String type;
    String task;

    public Message(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}
