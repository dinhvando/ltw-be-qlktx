package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
