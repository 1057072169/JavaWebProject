package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Pager;
import entity.Student;
import page.Constant;
import util.JdbcUtil;

/**
 * @ClassName: JdbcSqlStudentDaoImpl.java
 * @Description: 使用mysql数据库limit关键字实现分页
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月21日 下午7:48:44
 */
public class JdbcSqlStudentDaoImpl implements StudentDao {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		// 获得输入的姓名
		String stuName = searchModel.getStuName();
		// 获得性别
		int gender = searchModel.getGender();

		StringBuilder sql = new StringBuilder(
				"select * from t_student where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from t_student where 1=1 ");
		// 输入的姓名不为空则增加模糊查询
		if (stuName != null && !stuName.equals("")) {
			sql.append(" and stu_name like ?");
			countSql.append(" and stu_name like ?");
			paramList.add("%" + stuName + "%");
		}
		// 输入的性别不为空则增加模糊查询
		if (gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE) {
			sql.append(" and gender = ?");
			countSql.append(" and gender = ?");
			paramList.add(gender);
		}

		// 起始索引。pageSize:为每页显示多少条记录，pageNum为所在页数
		int fromIndex = pageSize * (pageNum - 1);

		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize);

		// 存放所有查询出的学生对象
		List<Student> studentList = new ArrayList<Student>();
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接

			// 获取总记录数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(
					countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number) countMap.get("totalRecord")).intValue();

			// 获取查询的学生记录
			List<Map<String, Object>> studentResult = jdbcUtil.findResult(
					sql.toString(), paramList);
			if (studentResult != null) {
				for (Map<String, Object> map : studentResult) {
					Student s = new Student(map);
					// 将学生保存到自己定义的列表中
					studentList.add(s);
				}
			}

			// 获取总页数
			int totalPage = totalRecord / pageSize;
			// 如果总记录数除以每页显示的记录条数不等于0的话总页数+1
			if (totalRecord % pageSize != 0) {
				totalPage++;
			}

			// 组装pager对象
			result = new Pager<Student>(pageSize, pageNum, totalRecord,
					totalPage, studentList);

		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return result;
	}

}
