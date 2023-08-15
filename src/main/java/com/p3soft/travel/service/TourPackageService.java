package com.p3soft.travel.service;


import com.p3soft.travel.model.TourPackage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TourPackageService {
    TourPackage createTourPackage(String code,String name);
    List<TourPackage> getAllTourPackages();
    Optional<TourPackage> getTourPackageById(String code);
}
