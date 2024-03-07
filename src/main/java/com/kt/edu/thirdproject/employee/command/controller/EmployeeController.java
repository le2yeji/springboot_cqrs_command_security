package com.kt.edu.thirdproject.employee.command.controller;

import com.kt.edu.thirdproject.employee.command.domain.EmployeeEntity;
import com.kt.edu.thirdproject.employee.command.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employee", description = "Employee API")
@RestController
//@RequiredArgsConstructor
@CrossOrigin(origins ="*")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary ="임직원 등록",description="임직원을 등록합니다.")
    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> create(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity createdEntity = employeeService.create(employeeEntity);
        return ResponseEntity.ok(createdEntity);
    }

    @PostMapping("/employees/{id}")
    @Operation(summary ="임직원 수정",description="임직원 정보를  수정합니다.")
    public ResponseEntity<EmployeeEntity> update(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity updatedEntity = employeeService.update(id,employeeEntity);
        return ResponseEntity.ok(updatedEntity);
    }

    @PostMapping("/employee/{id}")
    @Operation(summary ="임직원 정보 삭제",description="임직원 정보를 삭제합니다.")
    public ResponseEntity<EmployeeEntity> delete(@PathVariable Long id) {
        EmployeeEntity deletedEntity = employeeService.delete(id);
        return ResponseEntity.ok(deletedEntity);
    }
}
