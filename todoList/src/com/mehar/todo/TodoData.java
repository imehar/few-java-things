package com.mehar.todo;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItem.txt";

    private List<TodoItem> todoItem;
    private DateTimeFormatter formatter;

    public static TodoData getInstance (){
        return instance;
    }

    public TodoData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<TodoItem> getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(List<TodoItem> todoItem) {
        this.todoItem = todoItem;
    }

    public void loadTodoItems() throws IOException{
        todoItem = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try{
            while ( (input = br.readLine()) != null){
                String[] itempeices = input.split("\t");

                String shortDesc = itempeices[0];
                String details = itempeices[1];
                String datetime = itempeices[2];

                LocalDate date = LocalDate.parse(datetime, formatter);

                TodoItem item = new TodoItem(shortDesc, details, date);

                todoItem.add(item);
            }
        }finally {
            if (br != null){
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {

            Iterator<TodoItem> iter = todoItem.iterator();

            while ( iter.hasNext() ){
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }


        } finally {
            if (bw != null){
                bw.close();
            }
        }
    }
}
