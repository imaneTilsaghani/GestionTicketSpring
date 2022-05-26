package emsi.ma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import emsi.ma.models.Software;

public interface SoftwareRepo extends JpaRepository<Software, Integer> {

}
