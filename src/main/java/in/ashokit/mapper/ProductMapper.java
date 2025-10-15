package in.ashokit.mapper;

import in.ashokit.dto.ProductDto;
import in.ashokit.entity.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static final ModelMapper mapper = new ModelMapper();

    public static ProductDto convertToDto(Product productEntity){
        return mapper.map(productEntity, ProductDto.class);
    }

    public static Product toEntity(ProductDto productDto){
        return mapper.map(productDto, Product.class);
    }
}