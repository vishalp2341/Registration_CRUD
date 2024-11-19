package com.register.dao;

import com.register.model.Registration;
import java.util.List;

public interface RegistrationDao {
    int save(Registration registration);
    List<Registration> getAll();
    Registration getById(int id);
    int update(Registration registration);
    int delete(int id);
}
