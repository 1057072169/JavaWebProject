package dao;

import java.util.List;

import entity.Category;

public interface CategoryDao {

	public abstract void add(Category category);

	public abstract Category find(String id);

	public abstract List<Category> getAll();

}