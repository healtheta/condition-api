package org.healtheta.model.condition.repo;

import org.healtheta.model.common.Identifier;
import org.healtheta.model.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepo extends JpaRepository<Condition, Long> {
    public Condition findConditionById(Long id);
    public Condition findConditionByIdentifier(Identifier identifier);
}
