package com.mistershorr.synthesizer;

public class Note {
    private int noteId;
    private int delay;
    public static final int WHOLE_NOTE = 1000;

    public Note(int noteId) {
        this.noteId = noteId;
    }

    public Note(int noteId, int delay) {
        this.noteId = noteId;
        this.delay = delay;
    }

    public int getNoteId() {
        return noteId;
    }

    public int getDelay() {
        return this.delay;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public void setDelay() {
        this.delay = WHOLE_NOTE;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", delay=" + delay +
                '}';
    }
}
