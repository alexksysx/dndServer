package me.alexksysx.repo;

import me.alexksysx.model.CommonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommonClassRepository extends CommonClassDAO<CommonClass> {
}
