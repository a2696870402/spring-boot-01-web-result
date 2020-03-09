package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EmyployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询
    @GetMapping("/emps/{id}")
    public String getlist(Model model,@PathVariable("id") Integer id){
        Collection<Employee> employeeDaoAll=new ArrayList<>();
        Employee employee = employeeDao.get(id);
        employeeDaoAll.add(employee);
        //放在请求域中，页面中共享
        model.addAttribute("emps",employeeDaoAll);
        //自动拼串
        return "emp/list";
    }

    //查询员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employeeDaoAll=new ArrayList<>();
        employeeDaoAll =  employeeDao.getAll();
        //放在请求域中，页面中共享
        model.addAttribute("emps",employeeDaoAll);
        //自动拼串
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,我们需要查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加功能
    //SpringMVC自动讲请求参数和入参对象的属性进行一一绑定
    //要求请求参数和类的属性需要一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //数据添加
        System.out.println("保存成功:"+employee);
        //保存员工
        employeeDao.save(employee);
        //处理完成后应该来到员工列表页面
        //redirect:表示重定向到一个地址
        //forward:表示转发到一个地址 /表示当前项目路径
        return "redirect:/emps";
    }
    //来到修改页面
    //先查出员工，然后再回显页面信息
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //回到编译页面(add是修改添加 二 和 一的页面)
        //来到编译页面,我们需要查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //
        return "emp/add";
    }

    //员工修改:需要提交员工id
    @PutMapping("/emp")
    public String updateEmploee(Employee e){
        System.out.println("修改的员工数据:"+e);

        return "redirect:/emps";
    }

    //员工删除
    @PostMapping("/emp/{id}")
    public String deleteEmploee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        //返回员工页面
        return "redirect:/emps";
    }


}
