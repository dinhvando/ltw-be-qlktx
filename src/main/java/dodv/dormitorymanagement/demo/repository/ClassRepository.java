package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {

}
