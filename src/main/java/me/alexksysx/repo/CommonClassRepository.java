package me.alexksysx.repo;

import me.alexksysx.model.CommonClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonClassRepository extends CommonClassDAO<CommonClass>, JpaRepository<CommonClass, Long> {
}
