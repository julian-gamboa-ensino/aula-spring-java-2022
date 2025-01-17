import java.util.regex.Pattern;

public record Cliente(String cpf) {

    // Construtor que inicializa o Cliente com seu CPF e valida o formato
    public Cliente(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    // Método para validar o formato do CPF (simplificado)
    private boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", ""); 

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Expressão regular para verificar alguns padrões comuns de CPFs inválidos
        Pattern pattern = Pattern.compile("(\\d)\\1{10}"); 
        if (pattern.matcher(cpf).matches()) {
            return false;
        }

        // ... (Outras validações mais complexas podem ser adicionadas aqui)

        return true;
    }
}