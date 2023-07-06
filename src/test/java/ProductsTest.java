import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTest {

        Product product1 = new Product(12, "diary", 40);
        Book product2 = new Book(1, "Яма", 500, "Борис Акунин");
        Smartphone product3 = new Smartphone(22, "Samsung Galaxy S23", 100_000, "Samsung Electronics");

    @Test
    public void setGetIDTest() {
        product1.setId(24);
        int expectedID = 24;
        Assertions.assertEquals(expectedID, product1.getId());
    }

    @Test
    public void setGetNameTest() {
        product1.setName("notebook");
        String expectedName = "notebook";
        Assertions.assertEquals(expectedName, product1.getName());
    }

    @Test
    public void setGetPriceTest() {
        product1.setPrice(30);
        int expectedPrice = 30;
        Assertions.assertEquals(expectedPrice, product1.getPrice());
    }

    @Test
    public void setGetAuthorTest() {
        product2.setAuthor("Boris Akunin");
        String expectedAuthor = "Boris Akunin";
        Assertions.assertEquals(expectedAuthor, product2.getAuthor());
    }

    @Test
    public void setGetManufacturerTest() {
        product3.setManufacturer("Samsung");
        String expectedAuthor = "Samsung";
        Assertions.assertEquals(expectedAuthor, product3.getManufacturer());
    }
}
