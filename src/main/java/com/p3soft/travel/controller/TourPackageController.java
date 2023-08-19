package com.p3soft.travel.controller;

import com.p3soft.travel.exception.NotFoundResponse;
import com.p3soft.travel.model.TourPackage;
import com.p3soft.travel.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tour-package")
public class TourPackageController {
    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageController(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TourPackage> getAllTourPackage(){
        return (List<TourPackage>) tourPackageRepository.findAll();
    }
    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    public Optional<TourPackage> getTourPackageById(@PathVariable String code){
        return tourPackageRepository.findById(code);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json" , produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourPackage(@RequestBody TourPackage tourPackage){
        if (!tourPackageRepository.existsById(tourPackage.getCode())){
            tourPackageRepository.save(new TourPackage(tourPackage.getCode(),tourPackage.getName()));
        }
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)

    public Optional<TourPackage> getTourPackageByName(@Param("name") String name) throws NotFoundResponse {
        Optional<TourPackage> tourPackage =tourPackageRepository.findByName(name);
        if (tourPackage.isEmpty()){
            throw new NotFoundResponse(500,"Error: Not Found By Ali");
        }
        else {
            return tourPackage;
        }
    }
}
