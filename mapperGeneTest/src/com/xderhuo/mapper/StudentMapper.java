package mapper;

import domain.Student;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Thu May 24 21:39:51 CST 2018
     */
    @Delete({
        "delete from student",
        "where sid = #{sid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Thu May 24 21:39:51 CST 2018
     */
    @Insert({
        "insert into student (sid, sname, ",
        "cid)",
        "values (#{sid,jdbcType=INTEGER}, #{sname,jdbcType=VARCHAR}, ",
        "#{cid,jdbcType=INTEGER})"
    })
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Thu May 24 21:39:51 CST 2018
     */
    @Select({
        "select",
        "sid, sname, cid",
        "from student",
        "where sid = #{sid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sname", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cid", property="cid", jdbcType=JdbcType.INTEGER)
    })
    Student selectByPrimaryKey(Integer sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Thu May 24 21:39:51 CST 2018
     */
    @Select({
        "select",
        "sid, sname, cid",
        "from student"
    })
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sname", property="sname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cid", property="cid", jdbcType=JdbcType.INTEGER)
    })
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Thu May 24 21:39:51 CST 2018
     */
    @Update({
        "update student",
        "set sname = #{sname,jdbcType=VARCHAR},",
          "cid = #{cid,jdbcType=INTEGER}",
        "where sid = #{sid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}