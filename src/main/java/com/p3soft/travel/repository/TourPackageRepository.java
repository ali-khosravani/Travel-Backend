package com.p3soft.travel.repository;

import com.p3soft.travel.model.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//@RepositoryRestResource(exported = false)
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
    Optional<TourPackage> findByName(@Param("name") String name);
}
