package me.alexksysx.repo.dao;

import me.alexksysx.model.gameClass.CommonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonClassDao<EntityType extends CommonClass> extends JpaRepository<EntityType, Long> {

//    @Query("select e from #{#entityName} e")
//    List<EntityType> findTheAll();
}
