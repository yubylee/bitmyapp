package bitmyapp.handler;

import bitmyapp.dao.TeacherDao;
import bitmyapp.util.Prompt;
import bitmyapp.vo.Teacher;

public class TeacherHandler {

  private TeacherDao teacherDao = new TeacherDao();
  private String title;

  public TeacherHandler(String title) {
    this.title = title;
  }

  private void inputTeacher() {
    Teacher t = new Teacher();
    t.setNo(Prompt.inputInt("번호? "));
    t.setName(Prompt.inputString("이름? "));
    t.setTel(Prompt.inputString("전화? "));
    t.setEmail(Prompt.inputString("이메일? "));
    t.setDegree(Prompt.inputInt("1. 고졸\n2. 전문학사\n3. 학사\n4. 석사\n5. 박사\n0. 기타\n학위? "));
    t.setSchool(Prompt.inputString("학교? "));
    t.setMajor(Prompt.inputString("전공? "));
    t.setWage(Prompt.inputInt("강의료(시급)? "));

    this.teacherDao.insert(t);
  }

  private void printTeachers() {

    Teacher[] teachers = this.teacherDao.findAll();

    System.out.println("번호\t이름\t전화\t학위\t전공\t시강료");

    for (Teacher t : teachers) {
      System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\n",
          t.getNo(), t.getName(), t.getTel(),
          getDegreeText(t.getDegree()), t.getMajor(), t.getWage());
    }
  }

  private void printTeacher() {
    int teacherNo = Prompt.inputInt("강사번호? ");

    Teacher t = this.teacherDao.findByNo(teacherNo);

    if (t == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("    이름: %s\n", t.getName());
    System.out.printf("    전화: %s\n", t.getTel());
    System.out.printf("   이메일: %s\n", t.getEmail());
    System.out.printf("    학위: %s\n", getDegreeText(t.getDegree()));
    System.out.printf("    학교: %s\n", t.getSchool());
    System.out.printf("    전공: %s\n", t.getMajor());
    System.out.printf("   강의료: %s\n", t.getWage());
    System.out.printf("  등록일: %s\n", t.getCreatedDate());
  }

  private static String getDegreeText(int degree) {
    switch (degree) {
      case 1: return "고졸";
      case 2: return "전문학사";
      case 3: return "학사";
      case 4: return "석사";
      case 5: return "박사";
      default: return "기타";
    }
  }

  private void modifyTeacher() {
    int teacherNo = Prompt.inputInt("강사번호? ");

    Teacher old = this.teacherDao.findByNo(teacherNo);

    if (old == null) {
      System.out.println("해당 번호의 강사가 없습니다.");
      return;
    }

    // 변경할 데이터를 저장할 인스턴스 준비
    Teacher t = new Teacher();
    t.setNo(old.getNo());
    t.setCreatedDate(old.getCreatedDate());
    t.setName(Prompt.inputString(String.format("이름(%s)? ", old.getName())));
    t.setTel(Prompt.inputString(String.format("전화(%s)? ", old.getTel())));
    t.setEmail(Prompt.inputString(String.format("이메일(%s)? ", old.getEmail())));
    t.setDegree(Prompt.inputInt(String.format(
        "1. 고졸\\n2. 전문학사\\n3. 학사\\n4. 석사\\n5. 박사\\n0. 기타\\n학위(%s)? ",
        getDegreeText(old.getDegree()))));
    t.setSchool(Prompt.inputString(String.format("학교(%s)? ", old.getSchool())));
    t.setMajor(Prompt.inputString(String.format("전공(%s)? ", old.getMajor())));
    t.setWage(Prompt.inputInt(String.format("강의료(시급)(%s)? ", old.getWage())));


    String str = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      this.teacherDao.update(t);
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }

  }


  private void deleteTeacher() {
    int teacherNo = Prompt.inputInt("강사번호? ");

    Teacher t = this.teacherDao.findByNo(teacherNo);

    if (t == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String str = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!str.equalsIgnoreCase("Y")) {
      System.out.println("삭제 취소했습니다.");
      return;
    }

    teacherDao.delete(t);

    System.out.println("삭제했습니다.");

  }


  public void service() {
    while (true) {
      System.out.printf("[%s]\n", this.title);
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전");
      int menuNo = Prompt.inputInt(String.format("%s> ", this.title));

      switch (menuNo) {
        case 0: return;
        case 1: this.inputTeacher(); break;
        case 2: this.printTeachers(); break;
        case 3: this.printTeacher(); break;
        case 4: this.modifyTeacher(); break;
        case 5: this.deleteTeacher(); break;
        default:
          System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }
}
