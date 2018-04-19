package com.jp.test01;

import java.util.List;
import com.jp.test01.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
     @Select("select * from person")
     List<Person> selectAll();
     
     
    @Select("select * from person  where id = #{id}")
    Person selecPerson(int id);
     
}
