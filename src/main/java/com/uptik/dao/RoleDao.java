package com.uptik.dao;

import com.uptik.model.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);
}
