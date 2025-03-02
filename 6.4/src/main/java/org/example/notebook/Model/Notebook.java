package org.example.notebook.Model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    private ObservableList<Note> notes;

    public Notebook() {
        this.notes = FXCollections.observableArrayList();
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(Note note) {
        notes.remove(note)  ;
    }
}
