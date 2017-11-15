package service;

import java.util.List;

import entity.Students;

/**
 * @ClassName: StudentsDAO.java
 * @Description: 学生业务逻辑接口
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午8:25:28
 */
public interface StudentsDAO {
	
	//查询所有学生资料
	public List<Students> queryAllStudents();
	
	//根据学生编号查询学生资料
	public Students queryStudentsBySid(String sid);
	
	//添加学生资料
	public boolean addStudents(Students s);
	
	//修改学生资料
	public boolean updateStudent(Students s);
	
	//删除学生资料
	public boolean deleteStudent(String sid);
	
}
