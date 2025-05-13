//package Criacional.Abstract_Factory;

// Produto abstrato 1.
interface Button {
    void render();
}

// Produto abstrato 2.
interface Checkbox {
    void render();
}

// Produtos concretos para Windows.
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão estilo Windows.");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Renderizando checkbox estilo Windows.");
    }
}

// Produtos concretos para Mac.
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão estilo Mac.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Renderizando checkbox estilo Mac.");
    }
}

// Fábrica abstrata.
interface GuiFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Fábricas concretas.
class WindowsFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Main para testar o padrão Abstract Factory.
public class GuiFactoryExample {
    public static void main(String[] args) {
        GuiFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();

        factory = new MacFactory();
        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
