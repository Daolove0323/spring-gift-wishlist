package gift.service;

import gift.domain.IdentifiedProductDto;
import gift.domain.UnidentifiedProductDto;
import gift.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<IdentifiedProductDto> findAll() {
        return productRepository.selectAllProducts();
    }

    public IdentifiedProductDto find(Long id) {
        return productRepository.selectProductById(id);
    }

    public IdentifiedProductDto save(UnidentifiedProductDto product) {
        productRepository.insertProduct(product);
        return productRepository.selectProductByAttributes(product);
    }

    public IdentifiedProductDto update(Long id, UnidentifiedProductDto product) {
        productRepository.updateProduct(id, product);
        return find(id);
    }

    public void delete(Long id) {
        productRepository.deleteProductById(id);
    }
}
