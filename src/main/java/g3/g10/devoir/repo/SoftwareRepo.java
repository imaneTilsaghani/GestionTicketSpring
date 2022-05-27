package g3.g10.devoir.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import g3.g10.devoir.models.Software;

public interface SoftwareRepo extends JpaRepository<Software, Integer> {

}
