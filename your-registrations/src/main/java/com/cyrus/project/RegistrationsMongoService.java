package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationsMongoService implements RegistrationsService {

	@Autowired 
	RegistrationsMongoRepository mongoRepository;
	
	@Override
	public void loadData() {
//		Registration Registration1 = new Registration("1", "1", "NSFW");
//		Registration Registration2 = new Registration("2", "2", "PG-13");
//		Registration Registration3 = new Registration("3", "3", "Unrated");
//		mongoRepository.save(Registration1);
//		mongoRepository.save(Registration2);
//		mongoRepository.save(Registration3);
	}
	
	@Override
	public List<Registration> findAllRegistrations() {
		return mongoRepository.findAll();
	}
	
	@Override
	public Optional<Registration> findRegistrationById(String id) {
		return mongoRepository.findById(id);
	}
	
	@Override
	public void deleteRegistrationById(String id) {
		mongoRepository.deleteById(id);
	}
	
	@Override
	public void deleteRegistration(Registration Registration)
	{
		mongoRepository.delete(Registration);
	}
	
	@Override
	public Registration saveOrUpdate(Registration Registration)
	{
		return mongoRepository.save(Registration);
	}
	
}
