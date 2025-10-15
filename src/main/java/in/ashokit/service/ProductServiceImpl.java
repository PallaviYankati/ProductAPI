package in.ashokit.service;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.dto.ProductDto;
import in.ashokit.mapper.ProductCategoryMapper;
import in.ashokit.mapper.ProductMapper;
import in.ashokit.repo.ProductCategoryRepo;
import in.ashokit.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductCategoryDto> getAllCategories() {

        /*
        List<ProductCategoryDto> dtoList = new ArrayList<>();

        List<ProductCategory> entities = categoryRepo.findAll();
        entities.forEach(pc -> {
            ProductCategoryDto productCategoryDto = ProductCategoryMapper.convertToDto(pc);
            dtoList.add(productCategoryDto);
        });
        return dtoList;
         */

        return categoryRepo.findAll()
                        .stream()
                        .map(ProductCategoryMapper::convertToDto)
                        .toList();
    }

    @Override
    public List<ProductDto> getProductsByCategory(Long categoryId) {
          return productRepo.findByCategoryCategoryId(categoryId)
                            .stream()
                            .map(ProductMapper::convertToDto)
                            .toList();
    }

    @Override
    public List<ProductDto> getProductsByName(String productName) {
        return productRepo.findByNameContainingIgnoreCase(productName)
                .stream()
                .map(ProductMapper::convertToDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Long productId) {
       return productRepo.findById(productId)
               .map(ProductMapper::convertToDto)
               .orElse(null);
    }
}
