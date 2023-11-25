package tp06.view;

import tp06.dao.impl.ClientDAOImpl;
import tp06.dao.impl.ProductDAOImpl;
import tp06.entities.Client;
import tp06.entities.Product;
import tp06.service.ClientService;
import tp06.service.ProductService;
import tp06.service.impl.ClientServiceImpl;
import tp06.service.impl.ProductServiceImpl;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl(new ClientDAOImpl());
        ProductService productService = new ProductServiceImpl(new ProductDAOImpl());

        // get all clients
        System.out.println("clients :");
        List<Client> clients = clientService.getAllClients();
        for(Client client:clients)
            System.out.println(client);

        // get all products
        System.out.println("products :");
        List<Product> products = productService.getAllProducts();
        for(Product product:products)
            System.out.println(product);

        /*
        // save client

        Client client1 = new Client("youssef","ghallout","youssef@ghallout@gmail.com","Taza Haut 1455 bp100");
        clientService.addClient(client1);
        Client client2 = new Client("yassin","abkhir","yasin.abk@hotmail.com","Taza Haut 215 bp300");
        clientService.addClient(client1);
        clientService.addClient(client2);

        // save product
        Product product1 = new Product("Lenovo",15000,45);
        Product product2 = new Product("Dell",3200,12);
        productService.addProduct(product2);
        productService.addProduct(product1);
        */

        // search client by query
        String query = "amin";
        List<Client> clients_query = clientService.searchClientByQuery(query);
        System.out.println("clients having : "+query);
        for(Client client:clients_query)
            System.out.println(client);

        // search product by query
        String query2 = "dell";
        List<Product> products_query = productService.searchProductByQuery(query2);
        System.out.println("products having : "+query2);
        for(Product product:products_query)
            System.out.println(product);
    }
}
