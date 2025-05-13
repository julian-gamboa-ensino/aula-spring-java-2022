package entity.records;

// Record Assento 
public record Assento(boolean ocupado) {

    // Construtor que inicializa o assento como livre
    public Assento() {
        this(false); 
    }

    public boolean reservar() {
        if (!ocupado) {
            return true;
        }
        return false;
    }

    public boolean liberar() {
        if (ocupado) {
            return true;
        }
        return false;
    }
}

