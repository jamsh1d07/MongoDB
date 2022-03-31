package uz.pdp.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.mongodb.model.Category;
import uz.pdp.mongodb.payload.ApiResponse;
import uz.pdp.mongodb.service.CategoryService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category){
        ApiResponse apiResponse = categoryService.add(category);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }

    //@PatchMapping("/employees/{id}/{firstName}")
    @PatchMapping("/edit/{id}/{name}")
    public ResponseEntity<?> editName(@PathVariable String id,@PathVariable String name){

        ApiResponse apiResponse = categoryService.edit(id,name);

        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }

    /**
     * hammasi ko'rindi
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> all(){
        ApiResponse apiResponse = categoryService.all();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id){
        ApiResponse apiResponse = categoryService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200:409).body(apiResponse);
    }




    //--------------------------VALIDATION-----------------------
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
