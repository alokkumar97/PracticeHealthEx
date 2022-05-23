package com.Spring.HcE.Service;

import java.util.List;

import com.Spring.HcE.Model.Specialization;

public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);
	public List<Specialization> getAllSpecialization();
	public void updateSpecialization(Specialization spec);
	public void removeSpecialization(Long Id);
	public Specialization getOneSpecialization(Long Id);
}
