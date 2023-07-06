public class ProductManager {
    ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        for (Product product: repo.getProducts()) {
            if (!matches(product, text)) {
                System.out.println(product.name);
                repo.removeById(product.id);
            }
        }
        return repo.getProducts();
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
