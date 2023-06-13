package bitmyapp.dao;

import java.util.Date;
import java.util.LinkedList;
import bitmyapp.vo.Student;

public class StudentDao {

  LinkedList list = new LinkedList();

  int lastNo;

  public void insert(Student s) {
    s.setNo(++lastNo);
    s.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(s);
  }

  public Student[] findAll() {
    Student[] students = new Student[list.size()];
    Object[] arr = list.toArray();
    for (int i = 0; i < students.length; i++) {
      students[i] = (Student) arr[i];
    }
    return students;
  }

  public Student findByNo(int no) {
    Student s = new Student();
    s.setNo(no);

    int index = list.indexOf(s);
    if (index == -1) {
      return null;
    }
    return (Student) list.get(index);
  }

  public void update (Student s) {
    int index = list.indexOf(s);
    list.set(index, s);
  }

  public boolean delete (Student s) {
    return list.remove(s);
  }
}
