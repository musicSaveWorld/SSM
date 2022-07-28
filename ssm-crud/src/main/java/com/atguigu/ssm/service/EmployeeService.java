package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询所有的员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 删除员工信息
     */
    int deleteEmployee(@Param("empId") Integer empId);

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getPageEmployee(Integer pageNum);
}
