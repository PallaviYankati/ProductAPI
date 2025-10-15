package in.ashokit.mapper;

import in.ashokit.dto.ProductCategoryDto;
import in.ashokit.entity.ProductCategory;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {

    public static final ModelMapper mapper = new ModelMapper();

    public static ProductCategoryDto convertToDto(ProductCategory productCategoryEntity){
        return mapper.map(productCategoryEntity, ProductCategoryDto.class);
    }

    public static ProductCategory toEntity(ProductCategoryDto categoryDto){
        return mapper.map(categoryDto, ProductCategory.class);
    }
}