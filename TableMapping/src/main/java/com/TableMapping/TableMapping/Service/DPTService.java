package com.TableMapping.TableMapping.Service;

import com.TableMapping.TableMapping.Entity.DPTEntity;
import com.TableMapping.TableMapping.Entity.EmployeeEntity;
import com.TableMapping.TableMapping.Repository.DepartmentRepository;
import com.TableMapping.TableMapping.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DPTService {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public DPTService(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository=employeeRepository;
    }

    public DPTEntity addEmployee(DPTEntity dptEntity) {

        return departmentRepository.save(dptEntity);

    }

    public DPTEntity AddManager(int dptId, int empId) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(empId);

        Optional<DPTEntity> dptEntity = departmentRepository.findById(dptId);

        return dptEntity.flatMap(
                department ->
                        employeeEntity.map(
                                employeeEntity1 -> {
                                    department.setManager(employeeEntity1);
                                    return departmentRepository.save(department);
                                }
                        )
        ).orElse(null);



    }

    public List<DPTEntity> GetDepartment() {

        return departmentRepository.findAll();

    }
}
