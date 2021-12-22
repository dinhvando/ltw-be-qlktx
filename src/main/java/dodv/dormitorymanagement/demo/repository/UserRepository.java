package dodv.dormitorymanagement.demo.repository;

import dodv.dormitorymanagement.demo.entity.Student;
import dodv.dormitorymanagement.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByStudent(Student student);
}
