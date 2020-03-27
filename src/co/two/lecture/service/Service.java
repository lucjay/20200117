package co.two.lecture.service;

import java.util.List;

import co.two.lecture.dto.LectureDto;

public interface Service {
	public List<LectureDto> allSelect();

	public LectureDto select(LectureDto dto) ;

	public int insert(LectureDto dto);

	public int update(LectureDto dto);

	public int delete(LectureDto dto);

}
