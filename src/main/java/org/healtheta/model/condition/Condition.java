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

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getClinicalStatus() {
        return clinicalStatus;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public Identifier getSeverity() {
        return severity;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public List<CodeableConcept> getBodySite() {
        return bodySite;
    }

    public Reference getSubject() {
        return subject;
    }

    public Reference getContext() {
        return context;
    }

    public Onset getOnset() {
        return onset;
    }

    public Abatement getAbatement() {
        return abatement;
    }

    public Date getAssertedDate() {
        return assertedDate;
    }

    public Reference getAsserter() {
        return asserter;
    }

    public ConditionStage getStage() {
        return stage;
    }

    public List<ConditionEvidence> getEvidence() {
        return evidence;
    }

    public Reference getReference() {
        return reference;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setClinicalStatus(String clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
    }

    public void setSeverity(Identifier severity) {
        this.severity = severity;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public void setBodySite(List<CodeableConcept> bodySite) {
        this.bodySite = bodySite;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public void setContext(Reference context) {
        this.context = context;
    }

    public void setOnset(Onset onset) {
        this.onset = onset;
    }

    public void setAbatement(Abatement abatement) {
        this.abatement = abatement;
    }

    public void setAssertedDate(Date assertedDate) {
        this.assertedDate = assertedDate;
    }

    public void setAsserter(Reference asserter) {
        this.asserter = asserter;
    }

    public void setStage(ConditionStage stage) {
        this.stage = stage;
    }

    public void setEvidence(List<ConditionEvidence> evidence) {
        this.evidence = evidence;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }
}
