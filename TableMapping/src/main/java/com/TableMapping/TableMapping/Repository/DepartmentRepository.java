package com.TableMapping.TableMapping.Repository;

import com.TableMapping.TableMapping.Entity.DPTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DPTEntity,Integer> {

}
