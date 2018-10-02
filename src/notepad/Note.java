package notepad;

public class Note extends Record {
    private String noteSubject;
    private String noteBody;

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() +
                ", noteSubject='" + noteSubject + '\'' +
                ", noteBody='" + noteBody + '\'' +
                '}';
    }

    @Override
    public boolean hasSubString(String str) {
        return noteSubject.contains(str)
                || noteBody.contains(str);
    }
}
