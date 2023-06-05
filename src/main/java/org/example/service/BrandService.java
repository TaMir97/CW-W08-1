package org.example.service;

import org.example.entity.Brand;
import org.example.entity.User;
import org.example.repository.implementation.BrandRepo;
import org.example.application.ui.Validation.Valid;

public class BrandService {
    UserService userService = new UserService();
    BrandRepo brandRepo= new BrandRepo();

    public void addNewBrand (Brand brand, User user) {
        if (userService.isExist(user.getUsername()) && Valid.isWebsite(brand.getWebsite())) {
            brandRepo.addBrand(brand);
        }
    }

    public void updateNewBrand (Brand brand) {
        brandRepo.updateBrand(brand);
    }

    public void deleteNewBrand (int branId) {
        brandRepo.deleteBrand(branId);
    }
}
