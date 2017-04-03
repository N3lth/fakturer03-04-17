package eu.programisci.Test;

public class OdpowiedzDTO {

    private Integer wynik;
    private String wiadomosc;

    public OdpowiedzDTO() {
    }

    public OdpowiedzDTO(Integer aWynik, String aWiadomosc) {
        wynik = aWynik;
        wiadomosc = aWiadomosc;
    }

    public Integer getWynik() {
        return wynik;
    }

    public void setWynik(Integer aWynik) {
        wynik = aWynik;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String aWiadomosc) {
        wiadomosc = aWiadomosc;
    }
}
