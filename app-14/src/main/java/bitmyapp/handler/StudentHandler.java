package bitmyapp.handler;

import java.util.Date;
import bitmyapp.dao.StudentDao;
import bitmyapp.util.Prompt;
import bitmyapp.vo.Student;

public class StudentHandler {

  private StudentDao studentDao = new StudentDao();
  private String title;

  public StudentHandler(String title) {
    this.title = title;
  }

  private void inputStudent() {
    Student s = new Student();
    s.setNo(Prompt.inputInt("번호? "));
    s.setName(Prompt.inputString("이름? "));
    s.setTel(Prompt.inputString("전화? "));
    s.setPostNo(Prompt.inputString("우편번호? "));
    s.setBasicAddress(Prompt.inputString("주소1? "));
    s.setDetailAddress(Prompt.inputString("주소2? "));
    s.setWorking(Prompt.inputInt("0. 미취업\n1. 재직중\n재직자? ") == 1);
    s.setGender(Prompt.inputInt("0. 남자\n1. 여자\n성별? ") == 0 ? 'M' : 'W');
    s.setLevel((byte) Prompt.inputInt("0. 비전공자\n1. 준전공자\n2. 전공자\n전공? "));
    s.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.studentDao.insert(s);
  }

  private void printStudents() {

    Student[] students = this.studentDao.findAll();

    System.out.println("번호\t이름\t전화\t재직\t전공");

    for (Student s : students) {
      System.out.printf("%d\t%s\t%s\t%s\t%s\n",
          s.getNo(), s.getName(), s.getTel(),
          s.isWorking() ? "예" : "아니오",
              getLevelText(s.getLevel()));
    }
  }

  private void printStudent() {
    int studentNo = Prompt.inputInt("회원번호? ");

    Student s = this.studentDao.findByNo(studentNo);

    if (s == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("    이름: %s\n", s.getName());
    System.out.printf("    전화: %s\n", s.getTel());
    System.out.printf("우편번호: %s\n", s.getNo());
    System.out.printf("기본주소: %s\n", s.getBasicAddress());
    System.out.printf("상세주소: %s\n", s.getDetailAddress());
    System.out.printf("재직여부: %s\n", s.isWorking() ? "예" : "아니오");
    System.out.printf("    성별: %s\n", s.getGender() == 'M' ? "남자" : "여자");
    System.out.printf("    전공: %s\n", getLevelText(s.getLevel()));
    System.out.printf("  등록일: %s\n", s.getCreatedDate());
  }

  // 인스턴스 멤버(필드나 메서드)를 사용하지 않기 때문에
  // 그냥 스태틱 메서드로 두어라!
  private static String getLevelText(int level) {
    switch (level) {
      case 0: return "비전공자";
      case 1: return "준전공자";
      default: return "전공자";
    }
  }

  private void modifyStudent() {
    int memberNo = Prompt.inputInt("회원번호? ");

    Student old = this.studentDao.findByNo(memberNo);

    if (old == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    // 변경할 데이터를 저장할 인스턴스 준비
    Student s = new Student();
    s.setNo(old.getNo());
    s.setCreatedDate(old.getCreatedDate());
    s.setName(Prompt.inputString(String.format("이름(%s)? ", old.getName())));
    s.setTel(Prompt.inputString(String.format("전화(%s)? ", old.getTel())));
    s.setPostNo(Prompt.inputString(String.format("우편번호(%s)? ", old.getPostNo())));
    s.setBasicAddress(Prompt.inputString(String.format("기본주소(%s)? ", old.getBasicAddress())));
    s.setDetailAddress(Prompt.inputString(String.format("상세주소(%s)? ", old.getDetailAddress())));
    s.setWorking(Prompt.inputInt(String.format(
        "0. 미취업\n1. 재직중\n재직여부(%s)? ",
        old.isWorking() ? "재직중" : "미취업")) == 1);
    s.setGender(Prompt.inputInt(String.format(
        "0. 남자\n1. 여자\n성별(%s)? ",
        old.getGender() == 'M' ? "남자" : "여자")) == 0 ? 'M' : 'W');
    s.setLevel((byte) Prompt.inputInt(String.format(
        "0. 비전공자\n1. 준전공자\n2. 전공자\n전공(%s)? ",
        getLevelText(old.getLevel()))));

    String str = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      this.studentDao.update(s);
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }

  }


  private void deleteStudent() {
    int studentNo = Prompt.inputInt("회원번호? ");

    Student s = this.studentDao.findByNo(studentNo);

    if (s == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String str = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!str.equalsIgnoreCase("Y")) {
      System.out.println("삭제 취소했습니다.");
      return;
    }

    studentDao.delete(s);

    System.out.println("삭제했습니다.");

  }

  private void searchStudent() {

    Student[] students = this.studentDao.findAll();

    String name = Prompt.inputString("이름? ");

    System.out.println("번호\t이름\t전화\t재직\t전공");

    for (Student s : students) {
      if (s.getName().equalsIgnoreCase(name)) {
        System.out.printf("%d\t%s\t%s\t%s\t%s\n",
            s.getNo(), s.getName(), s.getTel(),
            s.isWorking() ? "예" : "아니오",
                getLevelText(s.getLevel()));
      }
    }
  }

  public void service() {
    while (true) {
      System.out.printf("[%s]\n", this.title);
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("6. 검색");
      System.out.println("0. 이전");
      int menuNo = Prompt.inputInt(String.format("%s> ", this.title));

      switch (menuNo) {
        case 0: return;
        case 1: this.inputStudent(); break;
        case 2: this.printStudents(); break;
        case 3: this.printStudent(); break;
        case 4: this.modifyStudent(); break;
        case 5: this.deleteStudent(); break;
        case 6: this.searchStudent(); break;
        default:
          System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }
}
