package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Гарри Поттер и Философский камень", 500, "Джоан Роулинг");
    Product book2 = new Book(2, "Гарри Поттерр и Тайная комната", 1500, "Джоан Роулингй");
    Product book3 = new Book(3, "Гарри Поттер и Узник Азкабана", 1000, "Джоан Роулинг");
    Product book4 = new Book(4, "Гарри Поттер и Кубок огня", 500, "Джоан Роулинг");
    Product smartphone1 = new Smartphone(5, "Iphone 10", 5000, "Samsung");
    Product smartphone2 = new Smartphone(6, "Iphone 10", 14000, "Xiaomi");
    Product smartphone3 = new Smartphone(7, "Iphone 12", 25000, "Samsung");

    @Test
    public void addNewProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.removeById(4);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchOneProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Гарри Поттерр и Тайная комната");
        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void searchOneProduct2() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Iphone 10");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchNotProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Оля");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchMultiPleProducts() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Iphone 10");
        Assertions.assertArrayEquals(expected, actual);

    }
}




