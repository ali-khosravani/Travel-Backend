package com.p3soft.travel.serviceImpl;

import com.p3soft.travel.model.TourPackage;
import com.p3soft.travel.repository.TourPackageRepository;
import com.p3soft.travel.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TourPackageImpl implements TourPackageService {
    private final TourPackageRepository tourPackageRepository;

    @Autowired

    public TourPackageImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public TourPackage createTourPackage(String code, String name) {
        if (!tourPackageRepository.existsById(code)) {
            tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    @Override
    public List<TourPackage> getAllTourPackages() {
        return ((List<TourPackage>) tourPackageRepository.findAll());
    }

    @Override
    public Optional<TourPackage> getTourPackageById(String code) {
        return tourPackageRepository.findById(code);
    }

    @Override
    public Optional<TourPackage> getTourPackageByName(String name )  {
        return tourPackageRepository.findByName(name);
    }
}
