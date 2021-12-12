package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, String> {
}
