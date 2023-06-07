package bitmyapp.dao;

import java.util.Arrays;
import bitmyapp.vo.Member;

public class MemberDao {
  private static final int SIZE = 100;

  private int count;
  private Member[] members = new Member[SIZE];

  public void insert(Member member) {
    this.members[this.count++] = member;
  }

  public Member[] findAll() {
    return Arrays.copyOf(members, count);
  }

  public Member findByNo(int no) {
    for (int i = 0; i < count; i++) {
      if (this.members[i].getNo() == no) {
        return this.members[i];
      }
    }
    return null;
  }

  public void update(Member member) {
    this.members[this.indexOf(member)] = member;
  }

  public void delete(Member member) {
    for (int i = this.indexOf(member) + 1; i < this.count; i++) {
      this.members[i - 1] = this.members[i];
    }
    this.members[--this.count] = null;
  }

  private int indexOf(Member m) {
    for (int i = 0; i < this.count; i++) {
      if (this.members[i].getNo() == m.getNo()) {
        return 1;
      }
    }
    return -1;
  }
}
