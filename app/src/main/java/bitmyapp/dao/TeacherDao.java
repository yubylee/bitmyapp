package bitmyapp.dao;

import java.util.Date;
import java.util.LinkedList;
import bitmyapp.vo.Teacher;

public class TeacherDao {

  LinkedList list = new LinkedList();

  int lastNo;

  public void insert(Teacher t) {
    t.setNo(++lastNo);
    t.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(t);
  }

  public Teacher[] findAll() {
    Teacher[] teachers = new Teacher[list.size()];
    Object[] arr = list.toArray();
    for (int i = 0; i < teachers.length; i++) {
      teachers[i] = (Teacher) arr[i];
    }
    return teachers;
  }

  public Teacher findByNo(int no) {
    Teacher t = new Teacher();
    t.setNo(no);

    int index = list.indexOf(t);
    if (index == -1) {
      return null;
    }
    return (Teacher) list.get(index);
  }

  public void update (Teacher t) {
    int index = list.indexOf(t);
    list.set(index, t);
  }

  public boolean delete (Teacher t) {
    return list.remove(t);
  }
}
