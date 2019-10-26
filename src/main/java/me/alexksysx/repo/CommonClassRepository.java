package me.alexksysx.repo;

import me.alexksysx.model.CommonClass;
import me.alexksysx.repo.dao.CommonClassDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommonClassRepository extends CommonClassDao<CommonClass> {
}
