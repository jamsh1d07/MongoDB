package uz.pdp.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(value = "categories")
public class Category {
    @Id
    private String objectId;

    @NotNull
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
