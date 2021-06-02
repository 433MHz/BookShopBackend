package pl.krystian.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public String editCategory(@RequestBody CategoryEntity category) {
		return operation.editCategory(category);
	}
	
	public String deleteCategory(@RequestBody CategoryEntity category) {
		return operation.deleteCategory(category);
	}
	
	public List<CategoryEntity> getAllCategories() {
		return operation.getAllCategories();
	}
	
	public CategoryEntity getCategoryById(@RequestBody Long id) {
		return operation.getCategoryById(id);
	}
	
	public CategoryEntity getCategoryByName(@RequestBody String name) {
		return operation.getCategoryByName(name);
	}
}
