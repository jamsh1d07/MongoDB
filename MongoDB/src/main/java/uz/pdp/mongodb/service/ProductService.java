package uz.pdp.mongodb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.mongodb.model.Category;
import uz.pdp.mongodb.model.Product;
import uz.pdp.mongodb.payload.ApiResponse;
import uz.pdp.mongodb.payload.ProductDTO;
import uz.pdp.mongodb.repository.CategoryRepository;
import uz.pdp.mongodb.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;




    //=============================================

    public ApiResponse all() {
        List<Product> all = productRepository.findAll();

        return new ApiResponse("All",true,all);
    }

    public ApiResponse add(ProductDTO dto) {
        // checking :
        if (categoryRepository.existsById(dto.getCategoryId())) {
            Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());
            Category category = optionalCategory.get();

            if (!productRepository.existsByName(dto.getName())){
                Product product = new Product();

                product.setCategory(category);
                product.setPrice(dto.getPrice());
                product.setName(dto.getName());

                Product save = productRepository.save(product);

                return new ApiResponse("saved",true,save);
            }
        }
        return new ApiResponse("Something went wrong",false);
    }
}
