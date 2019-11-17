package me.alexksysx.repo;

import me.alexksysx.model.gameClass.CommonClass;
import me.alexksysx.repo.dao.CommonClassDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommonClassRepository extends CommonClassDao<CommonClass> {
}
