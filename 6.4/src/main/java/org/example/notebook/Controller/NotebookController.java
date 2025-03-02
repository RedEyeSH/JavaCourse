package org.example.notebook.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.notebook.Model.Note;
import org.example.notebook.Model.Notebook;

public class NotebookController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<Note> notesListView;

    private Notebook notebook;
    private int selectedIndex = -1; // Tracks selected note index

    @FXML
    private void initialize() {
        notebook = new Notebook();
        editButton.setDisable(true);
        deleteButton.setDisable(true);

        notesListView.setItems(notebook.getNotes());

        notesListView.setOnMouseClicked(this::handleNoteSelection);
    }

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);

            titleField.clear();
            contentArea.clear();
        }
    }

    @FXML
    private void editNote() {
        if (selectedIndex != -1) {
            String newTitle = titleField.getText();
            String newContent = contentArea.getText();

            if (!newTitle.isEmpty() && !newContent.isEmpty()) {
                Note selectedNote = notebook.getNotes().get(selectedIndex);

                selectedNote.setTitle(newTitle);
                selectedNote.setContent(newContent);

                notesListView.refresh();

                clearSelection();
            }
        }
    }

    @FXML
    private void deleteNote() {
        if (selectedIndex != -1) {
             Note selectedNote = notebook.getNotes().get(selectedIndex);
             notebook.removeNote(selectedNote);

            clearSelection();
        }
    }

    private void handleNoteSelection(MouseEvent event) {
        selectedIndex = notesListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {
            Note selectedNote = notesListView.getItems().get(selectedIndex);
            titleField.setText(selectedNote.getTitle());
            contentArea.setText(selectedNote.getContent());

            editButton.setDisable(false);
            deleteButton.setDisable(false);
        }
    }

    public void clearSelection() {
        selectedIndex = -1;
        titleField.clear();
        contentArea.clear();
        editButton.setDisable(true);
        deleteButton.setDisable(true);
    }
}
