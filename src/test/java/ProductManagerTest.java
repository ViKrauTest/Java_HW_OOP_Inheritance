import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Яма", 500, "Борис Акунин");
    Product product2 = new Smartphone(22, "Samsung Galaxy S23", 100_000, "Samsung Electronics");
    Product product3 = new Smartphone(36, "Samsung Galaxy S22", 60_000, "Samsung Electronics");

    @Test
    public void shouldAdd() {
        Product[] expected = {product1};
        manager.add(product1);
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBy() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        Product[] expected = {product2, product3};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);

    }


}
