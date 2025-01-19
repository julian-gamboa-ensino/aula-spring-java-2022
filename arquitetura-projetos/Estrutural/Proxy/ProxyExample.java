
//package Estrutural.Proxy;

interface Service {
    void operation();
}


class RealService implements Service {
    @Override
    public void operation() {
        System.out.println("RealService: Executando a operação principal.");
    }
}


class ProxyService implements Service {
    private RealService realService;

    @Override
    public void operation() {
        if (realService == null) {
            realService = new RealService();
        }
        System.out.println("ProxyService: Antes de delegar ao RealService.");
        realService.operation();
        System.out.println("ProxyService: Depois de delegar ao RealService.");
    }
}


public class ProxyExample {
    public static void main(String[] args) {
        Service proxy = new ProxyService();
        proxy.operation();
    }
}
