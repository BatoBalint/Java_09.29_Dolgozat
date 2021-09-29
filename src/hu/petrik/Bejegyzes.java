package hu.petrik;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Formatter;


public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    //<editor-fold desc="Getter/Setter">
    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        szerkesztve = LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like() {
        likeok++;
    }
    //</editor-fold>

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = this.letrejott;
    }

    @Override
    public String toString() {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        if (szerkesztve != letrejott) {
            return String.format("%s - %d - %s\nSzerkesztve: %s\n%s", szerzo, likeok, dt.format(letrejott), dt.format(szerkesztve), tartalom);
        } else return String.format("%s - %d - %s\n%s", szerzo, likeok, dt.format(letrejott), tartalom);
    }

    public String toFileFormat() {
        return String.format("%s;%s\n", this.szerzo, this.tartalom);
    }
}
