package com.TableMapping.TableMapping.Service;

import com.TableMapping.TableMapping.Entity.DPTEntity;
import com.TableMapping.TableMapping.Entity.EmployeeEntity;
import com.TableMapping.TableMapping.Repository.DepartmentRepository;
import com.TableMapping.TableMapping.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository=departmentRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {

        return employeeRepository.save(employeeEntity);

    }

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity addWorkers(int empId, int dptId) {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(empId);
        Optional<DPTEntity> departmentRepository1 = departmentRepository.findById(dptId);


        return employeeEntity.flatMap(
                emp->departmentRepository1.map(
                        department->{
                            emp.setWorkerdpt(department);

                            department.getWorkers().add(emp);
                            departmentRepository.save(department);
                            return employeeRepository.save(emp);

                        }
                )
        ).get();

    }
}
