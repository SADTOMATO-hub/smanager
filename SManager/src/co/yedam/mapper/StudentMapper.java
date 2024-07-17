package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.StudentVo;

public interface StudentMapper {
	//목록반환
	List<StudentVo> studentList();
	//insert, update, delete = > 변경처리된 건수가 반환값으로 지정.
	int insertStudent(StudentVo love);
	int updateStudent(StudentVo love);
	int deleteStudent(StudentVo love);
}
