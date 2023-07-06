public class ProductManager {
    ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        for (Product product : repo.getProducts()) {
            if (!matches(product, text)) {
                System.out.println(product.name);
                repo.removeById(product.id);
            }
        }
        return repo.getProducts();
    }

   /* Реализация таким образом, дает ошибку ArrayIndexOutOfBoundsException ,когда я пытаюсь присвоить нулевому элементу какое-то значение в строке 28
   * Подскажите, как тогда реализовать этот метод, изначально создав пустой массив?
   *
   public Product[] searchBy1(String text) {
       Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
       int i=0;
        for (Product product: repo.getProducts()) {
            if (matches(product, text)) {
                result[i] = product;
                i++;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }*/

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
