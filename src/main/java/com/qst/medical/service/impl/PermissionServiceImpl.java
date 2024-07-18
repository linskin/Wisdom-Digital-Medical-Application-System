package com.qst.medical.service.impl;

import com.qst.medical.domain.Permission;
import com.qst.medical.mapper.PermissionMapper;
import com.qst.medical.model.PermissionModel;
import com.qst.medical.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * &#064;description:  权限菜单业务逻辑类
 * &#064;author:  liulindong
 * &#064;create:  2021/9/2 15:57
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 获取所有的权限菜单列表
     * @return
     */
    public List<PermissionModel> getAllPermission(String roleName) {
        String finalRoleName = "ROLE_"+roleName;
        List<PermissionModel> allPermission = permissionMapper.getPermission(finalRoleName.trim());
        List<PermissionModel> finalPermisson = new ArrayList<>();
        for (PermissionModel per:allPermission) {
            if (per.getPid() == 0) {
                finalPermisson.add(selectChildren(per, allPermission,finalRoleName));
            }
        }
        return finalPermisson;
    }


    /**
     * 为父节点添加children
     * @param father
     * @param allPermission
     * @return
     */
    public PermissionModel selectChildren(PermissionModel father, List<PermissionModel> allPermission,String finalRoleName) {
        List<Permission> list = new ArrayList<>();
        allPermission.forEach(item -> {
            if (!finalRoleName.equals("ROLE_1")) {
                String title = item.getMeta().getTitle().replace("管理", "查询");
                item.getMeta().setTitle(title);
            }
            if (father.getId() == item.getPid()) {
                father.setChildren(list);
                father.getChildren().add(selectChildren(item, allPermission,finalRoleName));
            }
        });
        return father;
    }
}
