// CommandExample.java
//package Estrutural.Command;

import java.util.Stack;

// Interface Command
interface Command {
    void execute();
    void undo();
}

// Receptor que realiza operações de texto
class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void appendText(String newText) {
        text.append(newText);
    }

    public void deleteText(int length) {
        int start = text.length() - length;
        if (start >= 0) {
            text.delete(start, text.length());
        }
    }

    public String getText() {
        return text.toString();
    }
}

// Comando concreto para adicionar texto
class AddTextCommand implements Command {
    private TextEditor editor;
    private String textToAdd;

    public AddTextCommand(TextEditor editor, String textToAdd) {
        this.editor = editor;
        this.textToAdd = textToAdd;
    }

    @Override
    public void execute() {
        editor.appendText(textToAdd);
    }

    @Override
    public void undo() {
        editor.deleteText(textToAdd.length());
    }
}

// Invoker que armazena e executa comandos
class CommandInvoker {
    private Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }
}

public class CommandExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CommandInvoker invoker = new CommandInvoker();

        // Adiciona texto
        Command addHello = new AddTextCommand(editor, "Olá, ");
        invoker.executeCommand(addHello);
        System.out.println("Texto atual: " + editor.getText());

        // Adiciona mais texto
        Command addWorld = new AddTextCommand(editor, "mundo!");
        invoker.executeCommand(addWorld);
        System.out.println("Texto atual: " + editor.getText());

        // Desfaz a última ação
        invoker.undoLastCommand();
        System.out.println("Após desfazer: " + editor.getText());

        // Desfaz novamente
        invoker.undoLastCommand();
        System.out.println("Após desfazer novamente: " + editor.getText());
    }
}
