import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static enums.category.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Customer luigione = new Customer(2, "Luigione", 2);

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Il signore degli anelli", BOOK, 45.22));
        products.add(new Product(2, "Ciuccio al limone", BABY, 1.20));
        products.add(new Product(3, "Asus 8382832838", BOYS, 999.99));
        products.add(new Product(4, "Come fare i tortellini a mostro", BOOK, 25.00));
        products.add(new Product(5, "Seggiolone", BABY, 24.00));

        List<Product> bookProducts = products.stream().filter(product -> product.getPrice() < 100 && product.getCategory() == BOOK).toList();
        System.out.println(bookProducts);

        List<Order> babyOrders = products.stream().filter(product -> product.getCategory() == BABY).map(product -> new Order(2, "in arrivo", LocalDate.now(), LocalDate.now().plusDays(1), Collections.singletonList(product), luigione)).toList();
        System.out.println(babyOrders);


    }
}