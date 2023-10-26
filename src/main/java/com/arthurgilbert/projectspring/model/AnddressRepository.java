package com.arthurgilbert.projectspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnddressRepository extends CrudRepository<Anddress, String> {

}
