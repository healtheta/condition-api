package org.healtheta.model.condition.repo;

import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.Reference;
import org.healtheta.model.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConditionRepo extends JpaRepository<Condition, Long> {
    public Condition findConditionById(Long id);
    public Condition findConditionByIdentifier(Identifier identifier);
    public List<Condition> findConditionBySubject(Reference subject);
    public List<Condition> findConditionByContext(Reference context);
}
