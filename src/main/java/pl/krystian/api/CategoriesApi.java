package pl.krystian.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.dataOperations.categories.CategoryOperations;
import pl.krystian.entities.CategoryEntity;


@RestController
@RequestMapping(path = "/categories")
public class CategoriesApi {
	
	@Autowired
	CategoryOperations operation;

	@PostMapping("/addCategory")
	public String addCategory(@RequestBody CategoryEntity category) {
		return operation.addCategory(category);
	}
	
	@PatchMapping("/updateCategory")
	public String editCategory(@RequestBody CategoryEntity category) {
		return operation.editCategory(category);
	}
	
	@DeleteMapping("/deleteCategory")
	public String deleteCategory(@RequestBody CategoryEntity category) {
		return operation.deleteCategory(category);
	}
	
	@GetMapping("/getAllCategories")
	public List<CategoryEntity> getAllCategories() {
		return operation.getAllCategories();
	}
	
	@GetMapping("/getCategoryById")
	public CategoryEntity getCategoryById(@RequestBody Long id) {		
		return operation.getCategoryById(id);
	}
	
	@GetMapping("/getCategoryByName")
	public CategoryEntity getCategoryByName(@RequestBody String name) {
		return operation.getCategoryByName(name);
	}
}
