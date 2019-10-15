package me.alexksysx.repo;

import me.alexksysx.model.CommonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CommonClassDAO<EntityType extends CommonClass> extends JpaRepository<EntityType, Long> {

//    @Query("select e from #{#entityName} e")
//    List<EntityType> findTheAll();
}
