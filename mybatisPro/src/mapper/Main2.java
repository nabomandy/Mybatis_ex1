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
    System.out.println("Student ���̺� ���ڵ� �߰��ϱ�");
    Student st = new Student();
    st.setStudno(1002);
    st.setName("ȫ�浿");
    st.setGrade(1);
    st.setId("hongkd3");
    st.setJumin("1234561234567");
    st.setMajor1(101);
    // int cnt = session.insert(NS + "insert", st);
    // System.out.println("student ���ڵ� �߰�:" + cnt);
    // session.commit();

    Student dispst = session.selectOne(NS + "selectno", st.getStudno());
    System.out.println(dispst);

    dispst = session.selectOne(NS + "selectnomap", st.getStudno());
    System.out.println(dispst);
    // -> major2 ���� ��� �Ʒ��� �ѹ� �� �׽���

    dispst = session.selectOne(NS + "selectnomap", 9514);
    System.out.println(dispst);
    // -> major2 �� ������ �ѹ� �� ��

    /* 1002�� �л��� �г�-> 2�г����� ������-> 80, Ű->175, ��������-> 1001�� ���� */


    st.setGrade(2);
    st.setWeight(80);
    st.setHeight(175);
    st.setProfno(1001);
    st.setStudno(1002);
    int cnt = session.update(NS + "update", st);
    System.out.println("student ���̺��� ���ڵ� ����:" + cnt);
    session.commit();



    System.out.println("1002�� �л� �����ϱ�");
    cnt = session.delete(NS + "delete", 1002);
    session.commit();



    // Ű�� 180�̻��� �л��� ���� ����ϱ�
    System.out.println("Ű�� 180�̻��� �л��� ���� ����ϱ�");
    map.clear();
    map.put("col", "height");
    map.put("value", 180);
    List<Student> list = session.selectList(NS + "select2", map);
    for (Student s : list)
      System.out.println(s);



  }

}
