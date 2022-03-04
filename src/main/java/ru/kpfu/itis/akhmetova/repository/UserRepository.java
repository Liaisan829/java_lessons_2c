package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //нет метода реализованного по поиску по почте, пишем сами
    //дальше парсится и реализацию пишет спринг
    UserDto getUserByEmail(String email);

    //jpql - язык, работает с сущностями, а не таблицами в отличие он sql native
    //они нужны чтоб писать сложные запросы
    @Query("select u from User u where u.name = 'Stepan'")
    List<User> findAllStepan();

    @Query(value = "select u from User u where u.name = :name and u.id = :id")
    User findUserByNameAndId(@Param("name") String name, @Param("id") String id);

    @Query(value = "select * from users u where u.name like ?1", nativeQuery = true)
    List<User> findAllByName(String name);

    //for pagination
    Page<User> findAll(Pageable pageable);

    @Query(value = "select u from User u where u.id in :ids")
    List<User> findAllByIds(@Param("ids") List<Integer> ids);
}
