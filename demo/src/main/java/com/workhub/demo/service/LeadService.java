package com.workhub.demo.service;

import com.workhub.demo.model.Lead;

import java.util.List;

public interface LeadService {

    boolean saveLead(Lead lead);
    List<Lead> getLeads();
}
