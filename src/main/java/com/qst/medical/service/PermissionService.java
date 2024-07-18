package com.qst.medical.service;

import com.qst.medical.model.PermissionModel;

import java.util.List;

public interface PermissionService {

    List<PermissionModel> getAllPermission(String roleName);

    PermissionModel selectChildren(PermissionModel father, List<PermissionModel> allPermission, String finalRoleName);
}
