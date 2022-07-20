package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    protected int port;
    protected Todos todos;


    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Starting server at " + port + "...");
            while (true) {
                try (
                        Socket clientsocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

                ) {
                    final String input = in.readLine();

                    Gson gson = new Gson();
                    Message message = gson.fromJson(input, Message.class);
                    if (message.getType().equals("ADD")) {
                        todos.addTask(message.getTask());
                    } else {
                        todos.removeTask(message.getTask());
                    }
                    out.println(todos.getAllTasks());
                }
            }

        } catch (IOException e) {
            System.out.println("Невозможно запустить сервер");
            e.printStackTrace();
        }
    }
}
