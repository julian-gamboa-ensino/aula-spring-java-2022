package entity;


public class Assentos {

    private Assento[][] assentos;

    //Usar una matriz (array bidimensional) para representar los asientos.
    public Assentos(int filas, int colunas) {
        assentos = new Assento[filas][colunas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < colunas; j++) {
                assentos[i][j] = new Assento(false); // Inicializa com assentos livres
            }
        }
    }

    public int totalLivres() {
        int total = 0;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (!assentos[i][j].ocupado()) {
                    total++;
                }
            }
        }
        return total;
    }


    public boolean lotado() {
        int total = 0;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j].ocupado()) {
                    total++;
                }
            }
        }
        
        return total==(assentos.length*assentos[0].length);
    }

    public int totalReservados() {
        int total = 0;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j].ocupado()) {
                    total++;
                }
            }
        }
        return total;
    }

    public boolean reservarAssento(int fila, int coluna) {
        if (estaDentroDosLimites(fila, coluna) && !assentos[fila][coluna].ocupado()) {
            assentos[fila][coluna] = new Assento(true);
            return true;
        }
        return false;
    }

    public boolean liberarAssento(int fila, int coluna) {
        if (estaDentroDosLimites(fila, coluna) && assentos[fila][coluna].ocupado()) {
            assentos[fila][coluna] = new Assento(false);;
            return true;
        }
        return false;
    }

    public boolean estaOcupado(int fila, int coluna) {
        return estaDentroDosLimites(fila, coluna) && assentos[fila][coluna].ocupado();
    }

    private boolean estaDentroDosLimites(int fila, int coluna) {
        return fila >= 0 && fila < assentos.length && coluna >= 0 && coluna < assentos[0].length;
    }

    // ... outros métodos para gerenciar os assentos
}