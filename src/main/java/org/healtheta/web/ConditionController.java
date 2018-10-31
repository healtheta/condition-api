package org.healtheta.web;

import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.OperationOutcome;
import org.healtheta.model.common.Reference;
import org.healtheta.model.common.repos.IdentifierRepo;
import org.healtheta.model.common.repos.ReferenceRepo;
import org.healtheta.model.condition.Condition;
import org.healtheta.model.condition.repo.ConditionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ConditionController {
    @Autowired
    ConditionRepo conditionRepo;
    @Autowired
    private IdentifierRepo identifierRepo;
    @Autowired
    private ReferenceRepo referenceRepo;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Condition condition){
        Identifier tmp = condition.getIdentifier();
        if(tmp.getValue() == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InvalidParameter(),
                                                                                        HttpStatus.OK);
        }

        if(identifierRepo.findIdentifierByValue(tmp.getValue()) != null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordExists(),
                                                                                HttpStatus.OK);
        }

        try{
            Condition tmpCondition = new Condition();
            tmpCondition = conditionRepo.save(tmpCondition);
            condition.setId(tmpCondition.getId());

            Reference ref = new Reference();
            ref.setIdentifier(condition.getIdentifier());
            ref.setDisplay("condition-reference");
            condition.setReference(ref);
            condition = conditionRepo.save(condition);
            return new ResponseEntity<Condition>(condition, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                                                                                HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String id){
        try{
            Long lId = Long.parseLong(id);
            Condition condition = conditionRepo.findConditionById(lId);
            if(condition != null){
                return new ResponseEntity<Condition>(condition, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                                                                        HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Condition condition){
        Long id = condition.getId();
        Condition tmpPatient = conditionRepo.findConditionById(id);
        if ( tmpPatient != null){
            //record exists let;s update.
            //reference are not to be updated.
            condition.setReference(tmpPatient.getReference());
            condition = conditionRepo.save(condition);
            return new ResponseEntity<Condition>(condition, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> delete(String id) {
        return null;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "subject", required=false) Long subject,
                                    @RequestParam(value = "context", required=false) Long context){
        if(subject != null){
            Reference ref = referenceRepo.findReferenceById(subject);
            List<Condition> conditionList = conditionRepo.findConditionBySubject(ref);
            return new ResponseEntity<List>(conditionList, HttpStatus.OK);
        }else if ( context != null){
            Reference ref = referenceRepo.findReferenceById(subject);
            List<Condition> conditionList = conditionRepo.findConditionBySubject(ref);
            return new ResponseEntity<List>(conditionList, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.OperationNotSupported(),
                                                                                        HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/format",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> format(){
        Condition condition =  new Condition();
        Identifier identifier = new Identifier();
        identifier.setValue("0000000000");
        condition.setIdentifier(identifier);
        return new ResponseEntity<Condition>(condition, HttpStatus.OK);
    }
}
