//package Criacional.Singleton;

// Classe Singleton para gerenciar logs na aplicação.
public class LoggerSingleton {
    private static LoggerSingleton instance;

    // Construtor privado impede instâncias externas.
    private LoggerSingleton() {
        System.out.println("Logger inicializado.");
    }

    // Método estático para acessar a única instância.
    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    // Método de exemplo para logar mensagens.
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    // Main para testar o padrão Singleton.
    public static void main(String[] args) {
        LoggerSingleton logger1 = LoggerSingleton.getInstance();
        LoggerSingleton logger2 = LoggerSingleton.getInstance();

        logger1.log("Primeira mensagem.");
        logger2.log("Segunda mensagem.");

        System.out.println("Mesma instância? " + (logger1 == logger2));
    }
}
