package co.two.lecture.dto.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.two.lecture.dto.LectureDto;
import co.two.lecture.service.DAO;
import co.two.lecture.service.Service;

public class LectureServiceImpl extends DAO implements Service {
	Scanner sc = new Scanner(System.in);
	private final String SELECT_ALL = "select course_id, professor_name, subject_name, lacture_room from course join professor on course.professor_code = professor.professor_code join subject on course.subject_code = subject.subject_code ORDER BY course_id";
	private final String SELECT = "SELECT course_id, professor_name, subject_name, lacture_room " + "FROM course "
			+ "JOIN professor ON course.professor_code = professor.professor_code "
			+ "JOIN subject ON course.subject_code = subject.subject_code " + "WHERE course_id = ?";
	private final String INSERT = "INSERT INTO COURSE VALUES (?,?,?,?)";
	private final String UPDATE = "UPDATE COURSE SET SUBJECT_CODE = ?, PROFESSOR_CODE = ?, LACTURE_ROOM = ? WHERE COURSE_ID = ?";
	private final String DELETE = "DELETE FROM course WHERE course_id = ?";

	@Override
	public List<LectureDto> allSelect() {
		List<LectureDto> list = new ArrayList<LectureDto>();
		LectureDto dto;
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new LectureDto();
				dto.setCourse_id(rs.getInt("course_id"));
				dto.setProfessor_name(rs.getString("professor_name"));
				dto.setSubject_name(rs.getString("subject_name"));
				dto.setLacture_room(rs.getString("lacture_room"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public LectureDto select(LectureDto dto) {
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setInt(1, dto.getCourse_id());
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setCourse_id(rs.getInt("course_id"));
				dto.setProfessor_name(rs.getString("professor_name"));
				dto.setSubject_name(rs.getString("subject_name"));
				dto.setLacture_room(rs.getString("lacture_room"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(LectureDto dto) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setInt(1, dto.getCourse_id());
			psmt.setString(2, dto.getProfessor_code());
			psmt.setString(3, dto.getSubject_code());
			psmt.setString(4, dto.getLacture_room());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int update(LectureDto dto) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(UPDATE);
			psmt.setString(1, dto.getSubject_code());
			psmt.setString(2, dto.getProfessor_code());
			psmt.setString(3, dto.getLacture_room());
			psmt.setInt(4, dto.getCourse_id());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int delete(LectureDto dto) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(DELETE);
			psmt.setInt(1, dto.getCourse_id());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;

	}

	public boolean isCheckId(int id) {
		boolean b = true;
		String sql = "select * from course where course_id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b; // 존재하면 false 그렇지 않으면 true를 돌려줌
	}

	public boolean isCheckSubject(String id) {
		boolean b = true;
		String sql = "select * from subject where subject_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean isCheckProfessor(String id) {
		boolean b = true;
		String sql = "select * from professor where professor_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
