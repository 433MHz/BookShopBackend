package pl.krystian.dataOperations.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.api.BookCategoryIdHolder;
import pl.krystian.entities.CategoryEntity;
import pl.krystian.jpa.repositories.CategoryRepository;

@Component
public class CategoryOperations {

	@Autowired
	private CategoryRepository categoryRepo;
		
	
//	Get all CategoryEntity from database, convert it to Category class and then return
	public List<CategoryEntity> getAll() {
		return categoryRepo.findAll();
	}

	public String edit(CategoryEntity category) {
		
		if(categoryRepo.existsById(category.getId())) {
			
				CategoryEntity originalEntity = categoryRepo.getById(category.getId());
				if(category.getName() != null) {
					originalEntity.setName(category.getName());
				}
					
				try {
					categoryRepo.save(originalEntity);
					return "Category edited";
				} catch (Exception e) {
					return "Problem with database";
				}
			}
		else {
			return "There is not any category with this ID";
		}
	}
	
	public String delete(BookCategoryIdHolder category) {
		
		if(categoryRepo.existsById(category.getCategoryID())) {
			try {
				categoryRepo.deleteById(category.getCategoryID());
				return "Category removed";
			} catch (Exception e) {
				return "Problem with database";
			}
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
			try {
				categoryRepo.save(category);
				return "Category saved";
			} catch (Exception e) {
				return "Problem with database";
			}
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
