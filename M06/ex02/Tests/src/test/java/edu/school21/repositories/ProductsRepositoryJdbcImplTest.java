package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class ProductsRepositoryJdbcImplTest {

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "ApplePie", 110),
            new Product(1L, "FishAndChips", 560),
            new Product(2L, "Pudding", 50),
            new Product(3L, "Tea", 20),
            new Product(4L, "Ham", 900)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(3L, "Tea", 20);
    final Product EXPECTED_SAVE_PRODUCT = new Product(5L, "Coffee", 200);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(4L, "HamHam", 999);
    final Product EXPECTED_AFTER_DELETE_PRODUCT = new Product(4L, "Ham", 900);

    private EmbeddedDatabase datab;
    private ProductsRepositoryJdbcImpl product;

    @BeforeEach
    void init() {
        datab = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        product = new ProductsRepositoryJdbcImpl(datab);
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(product.findById(3L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        product.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(product.findById(4L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        product.save(EXPECTED_SAVE_PRODUCT);
        Assertions.assertEquals(product.findById(5L).get(), EXPECTED_SAVE_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        product.delete(3L);
        Assertions.assertEquals(product.findById(4L).get(), EXPECTED_AFTER_DELETE_PRODUCT);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(product.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }

    @AfterEach
    void close() {
        datab.shutdown();
    }
}
