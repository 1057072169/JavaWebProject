package service.impl;

import java.util.List;

import entity.Category;

public interface BusinessService {

	/**��ӷ���**/
	void addCategory(Category category);

	/**���ҷ���**/
	Category findCategory(String id);

	/**�õ����з���**/
	List<Category> getAllCategory();

}