package com.example.ogarkovbook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotesApp extends Application{
    private int noteCount = 1;
    private String username = "Admin";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Записная книжка");

        ObservableList<String> notesList = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(notesList);

        TextField noteInput = new TextField();
        Button addNoteButton = new Button("Добавить заметку");
        Button removeNoteButton = new Button("Удалить заметку");
        Label userLabel = new Label("Пользователь: " + username);

        addNoteButton.setOnAction(e -> {
            String note = noteInput.getText();
            notesList.add(noteCount + ". " + note);
            noteCount++;
            noteInput.clear();
        });

        removeNoteButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                notesList.remove(selectedIndex);
                for (int i = 0; i < notesList.size(); i++) {
                    notesList.set(i, (i+1) + ". " + notesList.get(i).substring(3));
                }
            }
        });

        VBox vBox = new VBox();

        vBox.getChildren().addAll(userLabel, listView, noteInput, addNoteButton, removeNoteButton);
        Scene scene = new Scene(vBox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
