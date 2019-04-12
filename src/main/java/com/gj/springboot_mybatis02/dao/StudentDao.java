package com.gj.springboot_mybatis02.dao;

import com.gj.springboot_mybatis02.po.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kuass
 * @create kuass-04-12-17:20
 */
@Mapper
@Repository
public interface StudentDao {
    @Select("select * from stu")
    public List<Student> findAll();
    @Select("select * from stu where id = #{id}")
    public Student findById(int id);
    @Delete("delete from stu where id = #{id}")
    public int delete(int id);
    @Update("update stu set name = #{name},sex = #{sex} where id = #{id}")
    public int update(Student student);
    @Insert("insert into stu (name,sex) values(#{name},#{sex})")
    public int insert(Student student);
}
