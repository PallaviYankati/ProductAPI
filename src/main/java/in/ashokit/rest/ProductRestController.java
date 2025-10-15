package in.ashokit.rest;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.dto.ProductDto;
import in.ashokit.exception.NoProductCategoriesFound;
import in.ashokit.exception.NoProductsFoundException;
import in.ashokit.response.ApiResponse;
import in.ashokit.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> productCategories() {
        log.debug("method execution started");
        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();
        List<ProductCategoryDto> allCategories = productService.getAllCategories();
        if (allCategories.isEmpty()) {
           throw new NoProductCategoriesFound("Product Categories Not Found");
        } else {
            response.setStatus(200);
            response.setMessage("Fetched all categories");
            response.setData(allCategories);
            log.debug("method execution completed");
            log.info("Fetched Product Categories successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByCategory(@PathVariable Long categoryId) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
           throw new NoProductsFoundException("No Products Found With Given Category Id");
        } else {
            response.setStatus(200);
            response.setMessage("Fetched all products based on category id");
            response.setData(products);
            log.info("Fetched Products successfully Based on Category Id");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/productsByName/{name}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByCategory(@PathVariable String name) {
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByName(name);
        if (products.isEmpty()) {
            throw new NoProductsFoundException("No Products Found With Given Name");
        } else {
            response.setStatus(200);
            response.setMessage("Fetched all products based on category id");
            response.setData(products);
            log.info("Fetched Products successfully Based Name");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> product(@PathVariable Long productId) {
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto productDto = productService.getProductById(productId);
        if (productDto != null) {
            response.setStatus(200);
            response.setMessage("Fetched product with id");
            response.setData(productDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new NoProductsFoundException("No Products Found With Given ID");
        }
    }

}