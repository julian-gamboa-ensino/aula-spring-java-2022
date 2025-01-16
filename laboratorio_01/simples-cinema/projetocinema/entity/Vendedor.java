package entity;

import java.util.Scanner;

public class Vendedor {

    Assentos assentos;

    public Vendedor(Assentos assentos) {
        this.assentos=assentos;
        System.out.println("Bem-vindo ao Cinema!");
        System.out.println(" O vendedor pode vender:  " + assentos.totalLivres() + " assentos livres");
    }

    public void receberPedido() {
        
        if (this.assentos.lotado()) {
            System.out.println("(LOTADO)  não posso lhe vender nada");
        }
        else{
            Scanner scanner = new Scanner(System.in);

            System.out.println("vamos tomar seu pedido");
            
            System.out.print("Digite o número de ingressos: ");
            
            int numIngressos = scanner.nextInt();
            scanner.close();
            
            if ((this.assentos.totalLivres() < numIngressos) || numIngressos==0) {
                System.out.println("(QUANTIDADE não vendidvel)  não posso lhe vender essa quantidade de assentos");
            }
            else{

            }

        }

    }
    // ... outros métodos para gerenciar os assentos

}

