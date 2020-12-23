package com.vic.mapper;

import com.vic.entity.Student;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Victor
 */
public interface StudentMapper {
	
	/**
	 * 根据用户id查询
	 * @param id
	 * @return
	 */
	Student queryUserById(Long id);

	/**
	 * 新增
	 * @param student
	 */
	int insert(Student student);

	/**
	 * 查询正常学生、姓名模糊匹配
	 * @param s
	 * @return
	 */
	List<Student> findNormalStudentWithNameLike(Student s);

	/**
	 * 测试choose,when,otherwise
	 * @param s
	 * @return
	 */
	List<Student> testChoose(Student s);

	/**
	 * 测试choose,when,otherwise
	 * @param flag
	 * @return
	 */
	List<Student> testChoose2(String flag);

	/**
	 * 测试where
	 * @param s
	 * @return
	 */
	List<Student> testWhere(Student s);

	/**
	 * 使用trim代替where
	 * @param s
	 * @return
	 */
	List<Student> testTrimInsteadOfWhere(Student s);

	/**
	 * 测试set
	 * @param s
	 * @return
	 */
	int testSet(Student s);

	/**
	 * 使用trim代替set
	 * @param s
	 * @return
	 */
	int testTrimInsteadOfSet(Student s);

	/**
	 * 更新用户
	 * @param student
	 */
	Integer updateAnyway(Student student);


	/**
	 * foreach
	 * @param ids
	 * @return
	 */
	List<Student> findStudentIn1(List<Long> ids);

	/**
	 * foreach
	 * @return
	 */
	List<Student> findStudentIn2(List<Long> ids);

	/**
	 * 逻辑删除用户
	 * @param id
	 * @return
	 */
	Integer delete(Long id);

	/**
	 * 使用注解更新
	 * @param s
	 * @return
	 */
	@Update({"</script>",
		"update Student",
		"<set>",
		"	<if test='name != null'>name = #{name},</if>",
		"	<if test='age != null'>age = #{age},</if>",
		"	<if test='birthday != null'>birthday = #{birthday},</if>",
		"	<if test='address != null'>address = #{address}</if>",
		"</set>",
		"where id = #{id}",
	"</script>"})
	int testUpdateWithScriptElement(Student s);

	/**
	 * 测试bind元素
	 * @param s
	 * @return
	 */
	List<Student> testBindElement(Student s);
}
