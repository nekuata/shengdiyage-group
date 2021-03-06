package com.shengdiyage.dao;

import com.shengdiyage.entity.Admin;

import java.util.List;

/**
 * Created by Akari on 2017/6/27.
 */
public interface AdminDao {
    /**
     * 增加管理员
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 修改密码
     * @param admin
     * @return
     */
    int UpdateAdmin(Admin admin);

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    int deleteAdmin(int adminId);

    /**
     * 管理员列表
     * @return
     */
    List<Admin> queryAdmin();

    /**
     * 通过名字查找管理员
     * @param adminName
     * @return
     */
    Admin queryAdminByName(String adminName);

    /**
     * 管理员登陆验证
     * @return
     */
    boolean verifyAdmin(Admin admin);
}
