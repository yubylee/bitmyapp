package bitmyapp.dao;

import java.util.Arrays;
import bitmyapp.vo.Student;

public class StudentDao {
  private static final int SIZE = 100;

  private int count;
  private Student[] students = new Student[SIZE];

  public void insert(Student student) {
    this.students[this.count++] = student;
  }

  public Student[] findAll() {
    return Arrays.copyOf(students, count);
  }

  public Student findByNo(int no) {
    for (int i = 0; i < count; i++) {
      if (this.students[i].getNo() == no) {
        return this.students[i];
      }
    }
    return null;
  }

  public void update(Student student) {
    this.students[this.indexOf(student)] = student;
  }

  public void delete(Student student) {
    for (int i = this.indexOf(student) + 1; i < this.count; i++) {
      this.students[i - 1] = this.students[i];
    }
    this.students[--this.count] = null;
  }

  private int indexOf(Student s) {
    for (int i = 0; i < this.count; i++) {
      if (this.students[i].getNo() == s.getNo()) {
        return 1;
      }
    }
    return -1;
  }
}
