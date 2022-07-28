package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getPageEmployee(@PathVariable("pageNum")Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getPageEmployee(pageNum);
        //将分页数据共享到请求域
        model.addAttribute("page",page);
        //跳转到employee_list
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询员工所有的信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到employee_list
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId")Integer empId){
        int i = employeeService.deleteEmployee(empId);
        return "redirect://employee/page/";
    }
}
