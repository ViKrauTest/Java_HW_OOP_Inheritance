import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(1, "Яма", 500, "Борис Акунин");
    Product product2 = new Smartphone(22, "Samsung Galaxy S23", 100_000, "Samsung Electronics");
    Product product3 = new Smartphone(36, "Samsung Galaxy S22", 60_000, "Samsung Electronics");

    @Test
    public void shoudSaveAndGetProducts() {
        Product[] expected = {product1, product2, product3};
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        repo.removeById(product1.id);
        Product[] actual = repo.getProducts();
        Product[] expected = {product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }



}
