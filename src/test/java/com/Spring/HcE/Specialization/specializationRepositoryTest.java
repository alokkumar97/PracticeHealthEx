package com.Spring.HcE.Specialization;

import static org.assertj.core.api.Assertions.fail;

import java.util.List;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.Spring.HcE.Model.Specialization;
import com.Spring.HcE.Repository.SpecializationRepository;

@DataJpaTest(showSql=true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class specializationRepositoryTest {
	@Autowired
	SpecializationRepository specRepo;
	
	/**
	 * 1. Test Save Operation
	 * */
//	@Disabled
	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec= new Specialization(null, "CDLS", "Cardiologists", "They’re experts on the heart and blood vessels.");
		Specialization specOutPut= specRepo.save(spec);
//		assertNotNull(spec.getSpecId(),"Spec is Not Created");
	}
	@Test
	@Order(2)
	public void testSpecFetchAll() {
		List<Specialization> list= specRepo.findAll();
		if(list.isEmpty()) {
			fail("No data exist");
		}
	}
}
