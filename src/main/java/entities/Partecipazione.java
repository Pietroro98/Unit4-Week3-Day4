package entities;

import jakarta.persistence.*;


@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public enum Stato {
        CONFERMATA, DA_CONFERMARE
    }


    public Partecipazione() {}


    public Partecipazione(Persona persona1, Event event) {}

    public Partecipazione(Persona persona, Event evento,Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }



    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvent() {
        return evento;
    }

    public void setEvent(Event evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
