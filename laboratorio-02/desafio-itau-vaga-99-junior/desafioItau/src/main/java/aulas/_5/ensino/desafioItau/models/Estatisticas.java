package aulas._5.ensino.desafioItau.models;

public class Estatisticas {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public Estatisticas(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    // Getters
    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    // Setters (opcional, se você precisar modificar as estatísticas depois de criadas)
    public void setCount(long count) {
        this.count = count;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }
}