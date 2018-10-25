package org.healtheta.model.condition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Reference;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "__ConditionEvidence")
public class ConditionEvidence {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_code")
    private List<CodeableConcept> code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_detail")
    private List<Reference> detail;
}
