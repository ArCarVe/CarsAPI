package com.cartech.cars.business;

import com.cartech.cars.data.entity.Brand;
import com.cartech.cars.data.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;


    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void saveBrand(Brand brand){
        getBrandRepository().save(brand);
    }

    public List<Brand> getAllBrands(){
        return getBrandRepository().findAll();
    }

    public void deleteBrand(Brand brand){
        getBrandRepository().delete(brand);
    }

    public BrandRepository getBrandRepository() {
        return brandRepository;
    }
}
