package com.workhub.demo.service;
import com.workhub.demo.model.Lead;
import com.workhub.demo.repo.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;

    @Override
    public boolean saveLead(Lead lead) {
        try {
            Lead saveLead = leadRepository.save(lead);
            if(saveLead != null) {
                return true;
            }else {
                return false;
            }
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public List<Lead> getLeads() {
        return leadRepository.findAll();
    }
}
