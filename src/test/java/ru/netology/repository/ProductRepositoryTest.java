package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Гарри Поттер и Философский камень", 500, "Джоан Роулинг");
    Product book2 = new Book(2, "Гарри Поттерр и Тайная комната", 1500, "Джоан Роулингй");
    Product book3 = new Book(3, "Гарри Поттер и Узник Азкабана", 1000, "Джоан Роулинг");
    Product book4 = new Book(4, "Гарри Поттер и Кубок огня", 500, "Джоан Роулинг");
    Product smartphone1 = new Smartphone(5, "Iphone 10", 5000, "Samsung");
    Product smartphone2 = new Smartphone(6, "Iphone 11", 14000, "Xiaomi");
    Product smartphone3 = new Smartphone(7, "Iphone 12", 25000, "Samsung");


    @Test
    void save() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.removeById(4);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindAll() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};

        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

}
