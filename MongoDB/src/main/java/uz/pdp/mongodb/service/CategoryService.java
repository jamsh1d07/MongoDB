package uz.pdp.mongodb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.mongodb.model.Category;
import uz.pdp.mongodb.payload.ApiResponse;
import uz.pdp.mongodb.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public ApiResponse add(Category category) {

        if (!categoryRepository.existsByName(category.getName())) {
            Category save = categoryRepository.save(category);
            return new ApiResponse("added",true,save);
        }
        return new ApiResponse("Something went wrong",false);
    }

    public ApiResponse edit(String id, String name) {
        if (!categoryRepository.existsByName(name)) {
            Optional<Category> optionalCategory = categoryRepository.findById(id);
            if (optionalCategory.isPresent()) {
                Category category = optionalCategory.get();

                category.setName(name);

                Category save = categoryRepository.save(category);

                return new ApiResponse("edited",true,save);
            }
        }
        return new ApiResponse("xato",false);
    }

    public ApiResponse all() {
        List<Category> all = categoryRepository.findAll();
        if (all.isEmpty()) {
            return new ApiResponse("list is empty",true);
        }
            return new ApiResponse("All",true,all);
    }

    public ApiResponse getOne(String id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.map(category -> new ApiResponse("found", true, category))
                .orElseGet(() -> new ApiResponse("not found", false));
    }
}
