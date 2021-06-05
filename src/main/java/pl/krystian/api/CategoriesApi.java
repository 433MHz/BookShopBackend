package pl.krystian.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class CategoriesApi {
	
	@Autowired
	CategoryOperations operation;

	@PostMapping("/add")
	public String add(@RequestBody CategoryEntity category) {
		return operation.add(category);
	}
	
	@PatchMapping("/update")
	public String edit(@RequestBody CategoryEntity category) {
		return operation.edit(category);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody BookCategoryIdHolder category) {
		return operation.delete(category);
	}
	
	@GetMapping("/getAll")
	public List<CategoryEntity> getAll() {
		return operation.getAll();
	}
	
	@GetMapping("/getById")
	public CategoryEntity getById(@RequestBody Long id) {		
		return operation.getById(id);
	}
	
	@GetMapping("/getByName")
	public CategoryEntity getByName(@RequestBody String name) {
		return operation.getByName(name);
	}
}
