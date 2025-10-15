package in.ashokit.service;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductCategoryDto> getAllCategories();

    public List<ProductDto> getProductsByCategory(Long categoryId);

    public List<ProductDto> getProductsByName(String productName);

    public ProductDto getProductById(Long productId);

}
