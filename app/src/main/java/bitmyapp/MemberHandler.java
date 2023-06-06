package bitmyapp;

import java.util.Date;

public class MemberHandler {

  static final int SIZE = 100;
  static int count = 0;

  static int[] no = new int[SIZE];
  static String[] name = new String[SIZE];
  static String[] tel= new String[SIZE];
  static String[] postNo = new String[SIZE];
  static String[] basicAddress = new String[SIZE];
  static String[] detailAddress = new String[SIZE];
  static boolean[] working = new boolean[SIZE];
  static char[] gender = new char[SIZE];
  static byte[] level = new byte[SIZE];
  static String[] createdDate = new String[SIZE];

  static void inputMembers() {
    for (int i = 0; i < SIZE; i++) {

      no[i] = Prompt.inputInt("번호? ");
      name[i] = Prompt.inputString("이름? ");
      tel[i] = Prompt.inputString("전화? ");
      postNo[i] = Prompt.inputString("우편번호? ");
      basicAddress[i] = Prompt.inputString("주소1? ");
      detailAddress[i] = Prompt.inputString("주소2? ");

      String title = "0. 미취업\n1. 재직중\n재직자? ";
      working[i] = Prompt.inputInt(title) == 1;

      title = "0. 남자\n1. 여자\n성별? ";
      gender[i] = Prompt.inputInt(title) == 0 ? 'M' : 'W';

      title = "0. 비전공자\n1. 준전공자\n2. 전공자\n전공?";
      level[i] = (byte) Prompt.inputInt(title);

      Date today = new Date(System.currentTimeMillis());
      createdDate[i] = today.toString();

      count++;

      String str = Prompt.inputString("계속 입력하시겠습니까?(Y/n)");
      if(!str.equalsIgnoreCase("Y") && str.length() != 0) {
        break;
      }
    }

    Prompt.close();
  }

  static void printMembers() {
    for (int i = 0; i < count; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("전화: %s\n", tel[i]);
      System.out.printf("우편번호: %s\n", postNo[i]);
      System.out.printf("주소1: %s\n", basicAddress[i]);
      System.out.printf("주소2: %s\n", detailAddress[i]);
      System.out.printf("재직자: %s\n", working[i] ? "예" : "아니오");
      System.out.printf("성별: %s\n", gender[i] == 'M' ? "남자" : "여자");

      String levelTitle;
      switch(level[i]) {
        case 0: levelTitle = "비전공자"; break;
        case 1: levelTitle = "준전공자"; break;
        default: levelTitle = "전공자";
      }
      System.out.printf("전공: %s\n", levelTitle);

      System.out.printf("가입일: %s\n", createdDate[i]);

      System.out.println("--------------------------------");
    }
  }

}
