package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    public int deleteEmployee(Integer empId) {
        return employeeMapper.deleteEmployee(empId);
    }

    public PageInfo<Employee> getPageEmployee(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        //查询所有员工
        List<Employee> allEmployee = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(allEmployee,5);
        return pageInfo;
    }
}
