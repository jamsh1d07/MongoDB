package uz.pdp.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import uz.pdp.mongodb.model.Product;

@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product,String> {

    boolean existsByName(String name);

}
