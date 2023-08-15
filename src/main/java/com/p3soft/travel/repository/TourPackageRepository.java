package com.p3soft.travel.repository;

import com.p3soft.travel.model.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryRestResource(exported = false)
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {

}
