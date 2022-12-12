package com.cartech.cars.web;

import com.cartech.cars.business.BrandService;
import com.cartech.cars.data.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandRestController {

    private final BrandService brandService;


    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand brandDB = brandService.getBrandByName(brand.getName());
        if (brandDB != null) {
            return new ResponseEntity<>(brandDB, HttpStatus.CONFLICT);
        }
        try {
            brandService.saveBrand(brand);
        } catch (Exception e) {
            return new ResponseEntity<>(brand, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
    }

    @DeleteMapping("/brands/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long brandId) {
        Brand brandToDelete = brandService.getBrandById(brandId);
        brandService.deleteBrand(brandToDelete);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
