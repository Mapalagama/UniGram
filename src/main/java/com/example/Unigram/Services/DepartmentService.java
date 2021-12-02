package com.example.Unigram.Services;

import com.example.Unigram.Models.Department;
import com.example.Unigram.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartment(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
