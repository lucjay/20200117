package co.two.lecture.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.two.lecture.dto.LectureDto;
import co.two.lecture.dto.serviceImpl.LectureServiceImpl;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	LectureServiceImpl lecture = new LectureServiceImpl();
	LectureDto dto = new LectureDto();

	public void menu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("┌──────────MENU──────────┐");
			System.out.println("        1. 강좌관리                  ");
			System.out.println("        2. 종      료                 ");
			System.out.println("└────────────────────────┘");
			System.out.println("   원하는 메뉴번호를 입력하세요.  ");
			System.out.print("입력=>");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				lectureMenu();
				break;
			case 2:
				b = false;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			}
		} while (b);
	}

	public void lectureMenu() {
		int choice; // 숫자로 입력받을것이기때문에 int
		boolean b = true;
		do {
			System.out.println("┌────────────MENU─────────────┐");
			System.out.println("         1. 강좌등록                           "); // Insert
			System.out.println("         2. 강좌수정                           ");// Update
			System.out.println("         3. 강좌조회                           ");// Select
			System.out.println("         4. 강좌삭제                           ");// Delete
			System.out.println("         5. 강좌전체조회                     "); // all_select
			System.out.println("         6. 돌아가기                           ");
			System.out.println("└─────────────────────────────┘ ");
			System.out.println("     원하는 메뉴번호를 입력하세요.");
			System.out.print("입력=>");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:// 1.강좌등록 "); //Insert *이빈우
				insert();
				break;

			case 2: // 2.강좌수정 ");//Update *윤현수
				update();
				break;

			case 3:
				// 3.강좌조회 ");//Select *신치수
				dto = new LectureDto();
				System.out.println("강좌 조회하는 화면입니다.");
				System.out.println("조회할 강좌 코드를 입력하세요.");
				dto.setCourse_id(sc.nextInt());
				dto = lecture.select(dto);
				searchLectureDto(dto);
				System.out.println();
				break;

			case 4:
				// 4.강좌삭제 ");//Delete *하재선
				delete();
				break;

			case 5:
				// 강좌전체조회 "); //all_select *이빈우
				allSelect();
				break;
			case 6:
				b = false;
				break;
			}
		} while (b);
	}

	private void update() {
		dto = new LectureDto();
		String range = "1000";
		String range1 = "1001";
		String range2 = "1002";
		String range3 = "1003";
		String range4 = "1004";
		String range5 = "1005";
		String range6 = "1006";
		String range7 = "1007";
		String range8 = "1008";
		String range9 = "1009";
//	      String[] r_array = { "1000", "1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009" };

		boolean b = true;
		do {
			System.out.println("업데이트 할 강의번호를 입력해 주세요");
			int key = sc.nextInt();
			sc.nextLine();
			dto.setCourse_id(key);

			boolean chk = lecture.isCheckId(key);
			if (chk) {
				System.out.println("데이터가 존재하지 않습니다.");
			} else
				break;
		} while (b);
		System.out.println("변경 할 과목 코드를 입력해 주세요");
		dto.setSubject_code(sc.nextLine());
		if (dto.getSubject_code().length() > 4) {
			System.out.println("과목 코드는 4자리가 최대입니다.");
			return;
		}

		if (dto.getSubject_code().equals(range)) {

		} else if (dto.getSubject_code().equals(range1)) {

		} else if (dto.getSubject_code().equals(range2)) {

		} else if (dto.getSubject_code().equals(range3)) {

		} else if (dto.getSubject_code().equals(range4)) {

		} else if (dto.getSubject_code().equals(range5)) {

		} else if (dto.getSubject_code().equals(range6)) {

		} else if (dto.getSubject_code().equals(range7)) {

		} else if (dto.getSubject_code().equals(range8)) {

		} else if (dto.getSubject_code().equals(range9)) {

		} else {
			System.out.println("과목코드 범위가 아닙니다.");
			return;
		}

		System.out.println("변경 할 교수명 코드를 입력해 주세요");
		dto.setProfessor_code(sc.nextLine());
		if (dto.getProfessor_code().length() > 4) {
			System.out.println("교수 코드는 4자리가 최대입니다.");
			return;
		}
		if (dto.getProfessor_code().equals(range1)) {

		} else if (dto.getProfessor_code().equals(range2)) {

		} else if (dto.getProfessor_code().equals(range3)) {

		} else {
			System.out.println("교수코드 범위가 아닙니다.");
			return;
		}

		System.out.println("변경 할 강의실 코드를 입력해 주세요");
		dto.setLacture_room(sc.nextLine());
		if (dto.getLacture_room().length() > 4) {
			System.out.println("강의실 코드는 4자리가 최대입니다.");
			return;
		}

		int i;
		i = lecture.update(dto);
		if (i != 0)
			System.out.println("정상적으로 변경 되었습니다.!");
		else
			System.out.println("변경되지 않았습니다.");
	}

	private void allSelect() {
		List<LectureDto> list = new ArrayList<LectureDto>();
		list = lecture.allSelect();
		for (LectureDto dto : list) {
			System.out.print("강의번호 : " + dto.getCourse_id() + " | ");
			System.out.print("교수명 : " + dto.getProfessor_name() + " | ");
			System.out.print("과목명 : " + dto.getSubject_name() + " | ");
			System.out.println("강의실 : " + dto.getLacture_room() + " | ");
		}
	}

	private void insert() {
		LectureDto dto = new LectureDto();
		boolean b;
		do {
			System.out.println("*강의 정보를 입력해 주세요*");
			System.out.println("강의 번호 : ");
			dto.setCourse_id(sc.nextInt());
			b = lecture.isCheckId(dto.getCourse_id());
			if (!b) {
				System.out.println("!!!이미 존재하는 강의 입니다!!!");
				b = true;
			} else {
				System.out.println("사용 가능한 번호 입니다.");
				break;
			}
		} while (true); // 무한 반복
		sc.nextLine();
		boolean pro;
		do {
			System.out.println("교수코드 : ");
			dto.setProfessor_code(sc.nextLine());
			pro = lecture.isCheckProfessor(dto.getProfessor_code());
			if (pro) {
				System.out.println("존재 하지 않는 교수 코드 입니다. 다시 입력해 주세요.");
				pro = false;
			} else {
				System.out.println("가능한 교수 코드 입니다.");
				break;
			}
		} while (true);
		boolean subject;
		do {
			System.out.println("과목코드 : ");
			dto.setSubject_code(sc.nextLine());
			subject = lecture.isCheckSubject(dto.getSubject_code());
			if (subject) {
				System.out.println("존재하지 않는 과목 코드 입니다. 다시 입력해 주세요.");
				subject = false;
			} else {
				System.out.println("가능한 과목 코드 입니다.");
				break;
			}
		} while (true); // 무한 반복
		System.out.println("강의실 : ");
		dto.setLacture_room(sc.nextLine());
		if (dto.getLacture_room().length() > 4) {
			System.out.println("강의실 코드는 4자리가 최대입니다. 다시 입력 해 주세요.");
			dto.setLacture_room(sc.nextLine());
		}
		int n;
		n = lecture.insert(dto);
		if (n != 0) {
			System.out.println("성공적으로 등록 되었습니다.!");
			allSelect();
		} else {
			System.out.println("입력에 실패 하였습니다.");
		}
	}

	private void delete() {
		dto = new LectureDto();
		System.out.println(" *_강좌 삭제하는 화면입니다_* ");
		System.out.println(" *_삭제 할 강좌ID를 입력하세요_* ");
		System.out.print("입력=>");
		int n = sc.nextInt();
		sc.nextLine();
		dto.setCourse_id(n);
		System.out.println(" *_ 정말 삭제하시겠습니까 ? _* ");
		System.out.println(" ***!! 한번 삭제하시면 다시 되돌릴수 없습니다 !!*** ");
		System.out.println(" (삭제하시려면 아무키나 입력해주세요.) ");
		System.out.print("입력=>");
		String str = sc.nextLine();
		if (str != null)
			System.out.println(" 정상적으로 삭제되었습니다.");
		int m = lecture.delete(dto);
	}

	private void searchLectureDto(LectureDto dto) {
		System.out.print("강의번호 : " + dto.getCourse_id() + " | ");
		System.out.print("교수명 : " + dto.getProfessor_name() + " | ");
		System.out.print("과목명 : " + dto.getSubject_name() + " | ");
		System.out.print("강의실 : " + dto.getLacture_room() + " | ");

	}

}
