package mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatisjava.Student;

public class Main2 {
  private final static String NS = "student.";
  private static Map map = new HashMap();

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SqlSessionFactory sqlmap = Main1.initMybatis();
    SqlSession session = sqlmap.openSession();
    System.out.println("Student 테이블에 레코드 추가하기");
    Student st = new Student();
    st.setStudno(1002);
    st.setName("홍길동");
    st.setGrade(1);
    st.setId("hongkd3");
    st.setJumin("1234561234567");
    st.setMajor1(101);
    // int cnt = session.insert(NS + "insert", st);
    // System.out.println("student 레코드 추가:" + cnt);
    // session.commit();

    Student dispst = session.selectOne(NS + "selectno", st.getStudno());
    System.out.println(dispst);

    dispst = session.selectOne(NS + "selectnomap", st.getStudno());
    System.out.println(dispst);
    // -> major2 값이 없어서 아래에 한번 더 테스팅

    dispst = session.selectOne(NS + "selectnomap", 9514);
    System.out.println(dispst);
    // -> major2 값 보려고 한번 더 함

    /* 1002번 학생의 학년-> 2학년으로 몸무게-> 80, 키->175, 지도교수-> 1001로 수정 */


    st.setGrade(2);
    st.setWeight(80);
    st.setHeight(175);
    st.setProfno(1001);
    st.setStudno(1002);
    int cnt = session.update(NS + "update", st);
    System.out.println("student 테이블의 레코드 수정:" + cnt);
    session.commit();



    System.out.println("1002번 학생 삭제하기");
    cnt = session.delete(NS + "delete", 1002);
    session.commit();



    // 키가 180이상인 학생의 정보 출력하기
    System.out.println("키가 180이상인 학생의 정보 출력하기");
    map.clear();
    map.put("col", "height");
    map.put("value", 180);
    List<Student> list = session.selectList(NS + "select2", map);
    for (Student s : list)
      System.out.println(s);



  }

}
