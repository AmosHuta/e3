package e3;

public class MelodyPart {
    private Notes note;
    private Accidentals acc;
    private float time;

    public MelodyPart (Notes note, Accidentals acc, float time){
        this.note = note;
        this.acc = acc;
        this.time = time;
    }

    public Notes getNote() {
        return note;
    }

    public void setNote(Notes note) {
        this.note = note;
    }

    public Accidentals getAcc() {
        return acc;
    }

    public void setAcc(Accidentals acc) {
        this.acc = acc;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String noteString(Notes note, Accidentals acc){
        StringBuilder str = new StringBuilder();
        str.append(note.name());
        if (acc == Accidentals.SHARP)
            str.append("#");
        if (acc == Accidentals.FLAT)
            str.append("b");

        return str.toString();
    }

    public boolean isSameTime(MelodyPart mp){
        return this.getTime() == mp.getTime();
    }

    public boolean isSameNoteAcc(MelodyPart mp) {
        String mp1 = this.noteString(this.getNote(), this.getAcc());
        String mp2 = mp.noteString(mp.getNote(), mp.getAcc());

        if (mp1.equals(mp2))
            return true;
        else{
            switch (mp2){
                case "DO#":
                    if(mp1.equals("REb"))
                        return true;
                    break;
                case "RE#":
                    if(mp1.equals("MIb"))
                        return true;
                    break;
                case "MI":
                    if(mp1.equals("FAb"))
                        return true;
                    break;
                case "MI#":
                    if(mp1.equals("FA"))
                        return true;
                    break;
                case "FA#":
                    if(mp1.equals("SOLb"))
                        return true;
                    break;
                case "SOL#":
                    if(mp1.equals("LAb"))
                        return true;
                    break;
                case "LA#":
                    if(mp1.equals("SIb"))
                        return true;
                    break;
                case "SI":
                    if(mp1.equals("DOb"))
                        return true;
                    break;
                case "SI#":
                    if(mp1.equals("DO"))
                        return true;
                    break;
                case "REb":
                    if(mp1.equals("DO#"))
                        return true;
                    break;
                case "MIb":
                    if(mp1.equals("RE#"))
                        return true;
                    break;
                case "FAb":
                    if(mp1.equals("MI"))
                        return true;
                    break;
                case "FA":
                    if(mp1.equals("MI#"))
                        return true;
                    break;
                case "SOLb":
                    if(mp1.equals("FA#"))
                        return true;
                    break;
                case "LAb":
                    if(mp1.equals("SOL#"))
                        return true;
                    break;
                case "SIb":
                    if(mp1.equals("LA#"))
                        return true;
                    break;
                case "DOb":
                    if(mp1.equals("SI"))
                        return true;
                    break;
                case "DO":
                    if(mp1.equals("SI#"))
                        return true;

            }
        }
        return false;
    }
}

