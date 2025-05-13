//package Estrutural.State;


interface State {
    void handle();
}


class ConcreteStateA implements State {
    @Override
    public void handle() {
        System.out.println("Estado A lidando com a solicitação.");
    }
}


class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("Estado B lidando com a solicitação.");
    }
}


class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        if (state != null) {
            state.handle();
        } else {
            System.out.println("Nenhum estado definido.");
        }
    }
}

public class StateExample {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new ConcreteStateA());
        context.request();

        context.setState(new ConcreteStateB());
        context.request();
    }
}