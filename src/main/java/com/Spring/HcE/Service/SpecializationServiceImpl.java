package com.Spring.HcE.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.HcE.Model.Specialization;
import com.Spring.HcE.Repository.SpecializationRepository;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	SpecializationRepository specRepo;
	
	@Override
	public Long saveSpecialization(Specialization spec) {
		return specRepo.save(spec).getSpecId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		return specRepo.findAll();
	}
	
	@Override
	public void removeSpecialization(Long Id) {
		specRepo.deleteById(Id);
	}
	
	@Override
	public Specialization getOneSpecialization(Long Id) {
		Optional<Specialization> optional= specRepo.findById(Id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public void updateSpecialization(Specialization spec) {
		specRepo.save(spec);
	}

}
