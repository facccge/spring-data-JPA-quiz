package com.example.employee.repository;

import com.example.employee.entity.Employee;
import com.example.employee.entity.Company;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //以下所有的*都代表变量

    //1.查询名字是*的第一个employee
    Employee findByName(String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
    Employee findFirstByNameContainingAndSalaryGreaterThan(String name,int salary);

    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
    @Query("select e from Employee e where e.salary=(select max(salary) from Employee where companyId=?1) and e.companyId=?1")
    Employee findByMaxSalaryAndCompanyId(int companyId);

    //4.实现对Employee的分页查询，每页两个数据
    @Override
    Page<Employee> findAll(Pageable pageable);

    //5.查找**的所在的公司的公司名称
    @Query("select c.companyName from Employee e join Company c on e.companyId= c.id where e.name = ?1")
    String findCompanyNameByName(String name);

    //6.将*的名字改成*,输出这次修改影响的行数
    @Modifying
    @Query("update Employee e set e.name = :newName where e.name = :name")
    int updateByName(@Param("name")String name, @Param("newName")String newName);

    //7.删除姓名是*的employee
    @Modifying
    int deleteByName(String name);
}
