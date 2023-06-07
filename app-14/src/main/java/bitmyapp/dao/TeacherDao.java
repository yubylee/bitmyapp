package bitmyapp.dao;

import java.util.Arrays;
import java.util.Date;
import bitmyapp.vo.Teacher;

public class TeacherDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Teacher[] teachers = new Teacher[SIZE];

  public void insert(Teacher teacher) {
    teacher.setNo(++no);
    teacher.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    this.teachers[this.count++] = teacher;
  }

  public Teacher[] findAll() {
    return Arrays.copyOf(teachers, count);
  }

  public Teacher findByNo(int no) {
    for (int i = 0; i < count; i++) {
      if (this.teachers[i].getNo() == no) {
        return this.teachers[i];
      }
    }
    return null;
  }

  public void update(Teacher teacher) {
    this.teachers[this.indexOf(teacher)] = teacher;
  }

  public void delete(Teacher teacher) {
    for (int i = this.indexOf(teacher) + 1; i < this.count; i++) {
      this.teachers[i - 1] = this.teachers[i];
    }
    this.teachers[--this.count] = null;
  }

  private int indexOf(Teacher t) {
    for (int i = 0; i < this.count; i++) {
      if (this.teachers[i].getNo() == t.getNo()) {
        return 1;
      }
    }
    return -1;
  }
}
