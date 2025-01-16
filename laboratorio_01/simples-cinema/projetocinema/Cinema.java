import entity.*;


public class Cinema {

    public static void main(String[] args) {

        //El anfiteatro tiene 10 filas de 10 asientos cada una.
        Assentos assentos=new Assentos(10, 10);

        Vendedor vendedor=new Vendedor(assentos);
        vendedor.receberPedido();

   }
}