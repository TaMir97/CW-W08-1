package org.example.service;

import org.example.entity.Category;
import org.example.repository.implementation.CategoryRepo;
public class CategoryService {
    CategoryRepo categoryRepo = new CategoryRepo();

    public void addNewCategory(Category category) {
        categoryRepo.addCategory(category);
    }

    public Category[] loadAllCategories() {
        return categoryRepo.loadAllCategory();
    }

    public void updateNewCategory(Category category) {
        categoryRepo.updateCategory(category);
    }

    public void deleteNewCategory(int categoryID) {
        categoryRepo.deleteCategory(categoryID);
    }
}

