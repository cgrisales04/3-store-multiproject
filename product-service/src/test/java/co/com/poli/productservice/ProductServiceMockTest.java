package co.com.poli.productservice;

import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.persistence.entity.Product;
import co.com.poli.productservice.persistence.repository.ProductRepository;
import co.com.poli.productservice.service.ProductServices;
import co.com.poli.productservice.service.ProductServicesImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;
    private ProductServices productServices;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.openMocks(this);
        productServices = new ProductServicesImpl(productRepository);

        Product product = Product.builder()
                .id(5L)
                .name("Test")
                .stock(10D)
                .price(10000D)
                .category(Category.builder().id(1L).build())
                .build();
        Mockito.when(productRepository.findById(5L)).thenReturn(Optional.of(product));
    }

    @Test
    public void when_findById_return_Product() {
        Product product = productServices.findById(5L);
        Assertions.assertThat(product.getName()).isEqualTo("Test");
    }

}
