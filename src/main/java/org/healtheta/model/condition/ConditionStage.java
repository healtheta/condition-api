package org.healtheta.model.condition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Reference;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "__ConditionStage")
public class ConditionStage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_summary")
    private CodeableConcept summary;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_assesement")
    private List<Reference> assesment;
}
