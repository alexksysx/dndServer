package me.alexksysx.repo;

import me.alexksysx.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    Boolean existsSizeByNameAndSpace(String name, String space);
}
