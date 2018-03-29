package com.jackedandtan.JackedAndTan.models.data;

import com.jackedandtan.JackedAndTan.models.Lift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional

public interface LiftDao extends CrudRepository<Lift, Integer> {
}
