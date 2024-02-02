package seminars.first.Shop;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setTitle("apple");
        product1.setCost(100);
        Product product2 = new Product();
        product2.setTitle("orange");
        product2.setCost(50);
        Product product3 = new Product();
        product3.setTitle("cherry");
        product3.setCost(75);

        List<Product> products = List.of(product1, product2, product3);
        Shop shop = new Shop();
        shop.setProducts(products);

        /* 1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
           (правильное количество продуктов, верное содержимое корзины).
         */
        assertThat(shop.getProducts().size()).isEqualTo(3);
        assertThat(shop.getProducts().get(0)).isEqualTo(product1);
        assertThat(shop.getProducts().get(1)).isEqualTo(product2);
        assertThat(shop.getProducts().get(2)).isEqualTo(product3);

        // 2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(product1);

        /* 3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
        (проверьте правильность сортировки).
         */
        assertThat(shop.sortProductsByPrice().get(0)).isEqualTo(product2);
        assertThat(shop.sortProductsByPrice().get(1)).isEqualTo(product3);
        assertThat(shop.sortProductsByPrice().get(2)).isEqualTo(product1);
    }
}