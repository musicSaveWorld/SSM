package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 删除员工信息
     */
    int deleteEmployee(@Param("id")Integer id);

}
