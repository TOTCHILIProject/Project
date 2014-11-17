package Tochtli.Tochtli.model.dao;

import java.util.List;

import Tochtli.Tochtli.model.entity.Category;

public interface CategoryDAO {

	public List<Category> findAllCategories();

	public void persistCategory(Category category);

}