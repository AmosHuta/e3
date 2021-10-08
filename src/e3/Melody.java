package e3;

import java.util.ArrayList;
//Authors : AMOS HUTA & SILBIANA DEMA
public class Melody {

    private ArrayList<MelodyPart> mel;

    public Melody() {
        mel = new ArrayList<>();
    }

    public void addNote(Notes note, Accidentals accidental, float time) {
        if(note == null || accidental == null || time <= 0)
            throw new IllegalArgumentException();
        else{
            MelodyPart mp = new MelodyPart (note,  accidental,  time);
            mel.add(mp);
        }
    }
    public Notes getNote(int index) {
        if (index < this.getMelody().size())
            return mel.get(index).getNote();
        else
            throw new IllegalArgumentException();
    }
    public Accidentals getAccidental(int index) {
        return  mel.get(index).getAcc();
    }
    public float getTime(int index) {
        return mel.get(index).getTime();

    }
    public int size() {
        return mel.size();

    }
    public float getDuration() {
        float accum = 0;

        for (int i = 0; i < this.size(); i++) {
            accum += getTime(i);
        }
        return accum;

    }
    public ArrayList<MelodyPart> getMelody(){
        return this.mel;
    }

    @Override
    public boolean equals(Object o) {
        Melody melody = (Melody) o;
        ArrayList<MelodyPart> melodyArrayList = melody.getMelody();
        boolean sameNote = false;
        boolean sameTime = false;
        boolean aux = true;

        if (o == null) { return false;}
        if (this == o) { return true; }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        if(this.getMelody().size() != melodyArrayList.size())
            return false;

        for (int i = 0; i < this.getMelody().size() && aux; i++){
            sameNote = this.getMelody().get(i).isSameNoteAcc(melodyArrayList.get(i));
            sameTime = this.getMelody().get(i).isSameTime(melodyArrayList.get(i));
            aux = sameNote && sameTime;
        }
        return aux;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < this.getMelody().size(); i++){
            result = 31 * result + (int) this.getMelody().get(i).getTime();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String noteAcc = "";
        for (int i = 0; i < this.getMelody().size(); i++){
            noteAcc = this.getMelody().get(i).noteString(this.getMelody().get(i).getNote(), this.getMelody().get(i).getAcc());
            str.append(noteAcc).append("(").append(this.getMelody().get(i).getTime()).append(")").append(" ");
        }

        return str.toString().trim();
    }
}

