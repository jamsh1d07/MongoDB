package uz.pdp.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "KETMON")
public class Product {
    @Id
    private String objectId;  // default holatda bo'ladi

    @Field(name = "ismi") // database da ko'rinishii
    private String name;

    // qo'ymasa ham bo'ladi
    private double price;

    private Category category;

    private String test;


}
