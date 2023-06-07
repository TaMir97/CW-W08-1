package org.example.service;

import org.example.entity.Brand;
import org.example.repository.implementation.BrandRepo;
import org.example.util.Validations;

public class BrandService {
    BrandRepo brandRepo;

    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    public void addNewBrand(Brand brand) {
        if (Validations.isWebsite(brand.getWebsite())) {
            brandRepo.addBrand(brand);
        }
    }

    public Brand[] loadAllBrands() {
        return brandRepo.loadAllBrand();
    }

    public void updateNewBrand(Brand brand) {
        brandRepo.updateBrand(brand);
    }

    public void deleteNewBrand(int branId) {
        brandRepo.deleteBrand(branId);
    }
}
