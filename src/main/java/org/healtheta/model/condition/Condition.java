package org.healtheta.model.condition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.SerializableString;
import org.healtheta.model.common.*;

import java.util.Date;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_Condition")
public class Condition implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_clincalStatus")
    private String clinicalStatus;

    @Column(name = "_verificationStatus")
    private String verificationStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_category")
    private List<CodeableConcept> category;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_severity")
    private Identifier severity;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_bodySite")
    private List<CodeableConcept> bodySite;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_context")
    private Reference context;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_onset")
    private Onset onset;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_abatement")
    private Abatement abatement;

    @Column(name = "_assertedDate")
    private Date assertedDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_asserter")
    private Reference asserter;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_stage")
    private ConditionStage stage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_evidence")
    private List<ConditionEvidence> evidence;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reference")
    private Reference reference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_note")
    private List<Annotation> note;
}
