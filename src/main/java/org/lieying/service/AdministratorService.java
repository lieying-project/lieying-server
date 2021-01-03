package org.lieying.service;

import org.lieying.bean.Administrator;

public interface AdministratorService {
     Administrator queryAdministratorByUsernameAndPassword(String username, String password);
     Administrator queryDetailAdministratorById(int administratorId);
}
