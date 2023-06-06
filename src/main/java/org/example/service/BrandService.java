package org.example.service;

import org.example.entity.Brand;
import org.example.repository.implementation.BrandRepo;
import org.example.util.Valid;

public class BrandService {
    BrandRepo brandRepo= new BrandRepo();

    public void addNewBrand (Brand brand) {
        if (Valid.isWebsite(brand.getWebsite())) {
            brandRepo.addBrand(brand);
        }
    }

    public Brand[] loadAllBrands(){
        return brandRepo.loadAllBrand();
    }

    public void updateNewBrand (Brand brand) {
        brandRepo.updateBrand(brand);
    }

    public void deleteNewBrand (int branId) {
        brandRepo.deleteBrand(branId);
    }
}
