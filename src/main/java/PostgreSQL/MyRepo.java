package PostgreSQL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<Emp, Integer> {

}

