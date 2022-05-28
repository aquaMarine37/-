package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    final String clientTaskJson = in.readLine();

                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Todos todos1 = gson.fromJson(clientTaskJson, Todos.class);
                    System.out.println("type " + todos1.type + " task " + todos1.task);

                    if (todos1.type.equals("ADD")) {
                        todos.addTask(todos1.task);
                    } else {
                        if (todos1.type.equals("REMOVE")) {
                            todos.removeTask(todos1.task);
                        } else {
                        }
                    }
                    out.println(String.format(todos.getAllTasks()));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
