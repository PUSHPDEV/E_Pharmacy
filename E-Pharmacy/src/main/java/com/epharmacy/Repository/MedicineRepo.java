package com.epharmacy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epharmacy.Entity.Medicine;

@Repository
public interface MedicineRepo extends CrudRepository<Medicine, Integer>{

}
