package org.launchcode.Ch15Lecture.data;

import org.launchcode.Ch15Lecture.models.DinoEgg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinoEggRepository extends CrudRepository<DinoEgg, Integer> {
}
