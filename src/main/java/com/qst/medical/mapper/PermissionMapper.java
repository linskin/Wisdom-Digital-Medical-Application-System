package com.qst.medical.mapper;

import com.qst.medical.model.PermissionModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 权限菜单数据访问接口
 * @author: liulindong
 * @create: 2021/9/2 15:45
 **/
@Component
public interface PermissionMapper {

    List<PermissionModel> getPermission(String roleName);
}
