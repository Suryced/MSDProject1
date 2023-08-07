package com.cyrus.project;

import java.util.List;
import java.util.Optional;

public interface RegistrationsService {

	void loadData();

	List<Registration> findAllRegistrations();

	Optional<Registration> findRegistrationById(String id);

	void deleteRegistrationById(String id);

	void deleteRegistration(Registration Registration);

	Registration saveOrUpdate(Registration Registration);

}