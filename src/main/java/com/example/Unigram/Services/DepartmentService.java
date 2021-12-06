package com.example.Unigram.Services;

import com.example.Unigram.Models.Department;
import com.example.Unigram.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public Department updateDepartment(Department department,Integer departmentId) {
        Optional<Department> department1 = departmentRepository.findById(departmentId);
        Department department2 = department1.get();
        department.setId(department2.getId());
        department.setFaculty(department2.getFaculty());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
