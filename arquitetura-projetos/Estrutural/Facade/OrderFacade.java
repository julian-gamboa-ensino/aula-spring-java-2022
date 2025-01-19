//package Estrutural.Facade;

// Subsistema 1: Verificação de estoque.
class InventoryService {
    public boolean checkStock(String product) {
        System.out.println("Verificando estoque para: " + product);
        return true;
    }
}

// Subsistema 2: Processamento de pagamento.
class PaymentService {
    public boolean processPayment(String paymentDetails) {
        System.out.println("Processando pagamento com detalhes: " + paymentDetails);
        return true;
    }
}

// Subsistema 3: Envio de pedidos.
class ShippingService {
    public void shipProduct(String product) {
        System.out.println("Produto enviado: " + product);
    }
}

// Fachada para simplificar a interação com o subsistema.
public class OrderFacade {
    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();

    public void placeOrder(String product, String paymentDetails) {
        if (inventoryService.checkStock(product) && paymentService.processPayment(paymentDetails)) {
            shippingService.shipProduct(product);
            System.out.println("Pedido realizado com sucesso!");
        } else {
            System.out.println("Falha ao realizar o pedido.");
        }
    }

    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder("Laptop", "Cartão de Crédito");
    }
}