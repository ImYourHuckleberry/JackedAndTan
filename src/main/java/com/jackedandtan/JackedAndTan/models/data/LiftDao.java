package com.jackedandtan.JackedAndTan.models.data;

import com.jackedandtan.JackedAndTan.models.Lift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface LiftDao extends CrudRepository<Lift, Integer> {
}
