package bitmyapp;

import java.util.Arrays;

public class BoardDao {
  static final int SIZE = 100;

  int count;
  Board[] boards = new Board[SIZE];

  public void insert(Board board) {
    this.boards[this.count++] = board;
  }

  public Board[] findAll() {
    // 배열의 값 복제
    //    Board[] arr = new Board[this.count];
    //    for (int i = 0; i < this.count; i++) {
    //      arr[i] = this.boards[i];
    //    }
    //    return arr;

    // 위와 같다!
    return Arrays.copyOf(boards, count);
  }

  Board findByNo(int no) {
    for (int i = 0; i < count; i++) {
      if (this.boards[i].getNo() == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  public void update(Board board) {
    this.boards[this.indexOf(board)] = board;
  }

  public void delete(Board board) {
    for (int i = this.indexOf(board) + 1; i <this.count; i++) {
      this.boards[--this.count] = null;
    }
  }

  int indexOf(Board b) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].getNo() == b.getNo()) {
        return 1;
      }
    }
    return -1;
  }
}
