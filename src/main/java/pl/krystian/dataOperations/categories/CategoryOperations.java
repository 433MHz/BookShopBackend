package pl.krystian.dataOperations.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.entities.CategoryEntity;
import pl.krystian.jpa.repositories.BookRepository;
import pl.krystian.jpa.repositories.CategoryRepository;

@Component
public class CategoryOperations {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private BookRepository bookRepo;
		
	
//	Get all CategoryEntity from database, convert it to Category class and then return
	public List<CategoryEntity> getAll() {
		return categoryRepo.findAll();
	}

	public String edit(CategoryEntity category) {
		
		if(categoryRepo.existsById(category.getId())) {
			categoryRepo.save(category);
			return "Category updated";
		}
		else {
			return "There is not any category with this ID";
		}
	}
	
	public String delete(CategoryEntity category) {
		
		if(categoryRepo.existsById(category.getId())) {
			categoryRepo.deleteById(category.getId());
			return "Category removed";
		}
		else {
			return "There is not any category with this ID";
		}
	}

	public String add(CategoryEntity category) {
		
		if(categoryRepo.findByName(category.getName()) != null) {
			return "There is category with this name already";
		}
		
		else {
			categoryRepo.save(category);
			return "Category saved";
		}
	}

	public CategoryEntity getById(Long id) {
		Optional<CategoryEntity> category = categoryRepo.findById(id);
		
		try {
			return category.get();
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public CategoryEntity getByName(String name) {
				
		CategoryEntity category = categoryRepo.findByName(name);
				
		if(category != null) {
			return category;
		}
		else {
			return null;
		}
	}
}
