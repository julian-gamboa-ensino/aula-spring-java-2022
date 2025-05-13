//package Estrutural.Adapter;


interface Target {
    void request();
}


class Adaptee {
    void specificRequest() {
        System.out.println("Chamada específica do Adaptee.");
    }
}


class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}


public class AdapterExample {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}