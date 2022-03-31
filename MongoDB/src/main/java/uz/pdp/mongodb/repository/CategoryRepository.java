package uz.pdp.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.mongodb.model.Category;

public interface CategoryRepository extends MongoRepository<Category,String> {
    boolean existsByName(String name);
}
