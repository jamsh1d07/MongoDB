package uz.pdp.mongodb.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.mongodb.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    @NotEmpty(message = "ismi bo'lishi majburiy")
    @Size(min = 5,max = 45)
    private String name;

    @NotNull(message = "narxi bo'lsin")
    private Double price;

    @NotNull(message = "categorysiz malumot qo'sha olmaymiz")
    private String categoryId;

}
