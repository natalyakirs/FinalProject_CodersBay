package com.workhub.demo.controller;
import com.workhub.demo.model.Lead;
import com.workhub.demo.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/lead")
public class LeadController {

    @Autowired
    LeadService leadService;


    @CrossOrigin// to get rid of error during response
    @PostMapping(path = "/save")
    public ResponseEntity<String> saveLead(@RequestBody Lead lead) {
        if(leadService.saveLead(lead)) {
            return new ResponseEntity<>("Lead saved", HttpStatus.OK);
        } else
            return new ResponseEntity<>("Lead failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @CrossOrigin
    @GetMapping(path = "/getLeads")
    public ResponseEntity<List<Lead>> getLeads() {
        return new ResponseEntity<>(leadService.getLeads(), HttpStatus.OK);
    }






}
