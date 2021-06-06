package mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatisjava.Student;

public class Main3 {
  private final static String NS = "student2.";
  private static Map map = new HashMap();

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SqlSessionFactory sqlMap = Main1.initMybatis();
    SqlSession session = sqlMap.openSession(); // sql���


    // ������� StudentMapper2.xml

    System.out.println("�л� ��ü ���ڵ� ��ȸ�ϱ�");
    List<Student> list = session.selectList(NS + "select1");
    for (Student s : list)
      System.out.println(s);

    // map.clear();
    // map.put("grade", 1);
    // System.out.println("1�г� �л� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select2", map);
    // // list = session.selectList(NS + "select_grade", 1);
    // for (Student s : list)
    // System.out.println(s);
    //
    // map.clear();
    // map.put("height", 180);
    // System.out.println("�л� �� Ű�� 180 �̻��� �л� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select2", map);
    // // list = session.selectList(NS + "select_height", 180);
    // for (Student s : list)
    // System.out.println(s);
    //
    // map.clear();
    // map.put("grade", 2);
    // map.put("height", 180);
    // System.out.println("2�г� �л� �� Ű�� 180�̻��� �л��� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select_height_grade", map);
    // for (Student s : list)
    // System.out.println(s);
    //

    // *select3 ���� �Ѳ����� ó���ϴ� ���
    // map.clear();
    // map.put("grade", 1);
    // System.out.println("1�г� �л� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select3", map);
    // for (Student s : list)
    // System.out.println(s);
    //
    // map.clear();
    // map.put("height", 180);
    // System.out.println("�л� �� Ű�� 180 �̻��� �л� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select3", map);
    // for (Student s : list)
    // System.out.println(s);
    //
    // map.clear();
    // map.put("grade", 2);
    // map.put("height", 180);
    // System.out.println("2�г� �л� �� Ű�� 180�̻��� �л��� ���ڵ� ��ȸ�ϱ�");
    // list = session.selectList(NS + "select3", map);
    // for (Student s : list)
    // System.out.println(s);

    map.clear();
    map.put("grade", 1);
    System.out.println("1�г� �л� ���ڵ� ��ȸ�ϱ�");
    list = session.selectList(NS + "select4", map);
    for (Student s : list)
      System.out.println(s);

    map.clear();
    map.put("height", 180);
    System.out.println("�л� �� Ű�� 180 �̻��� �л� ���ڵ� ��ȸ�ϱ�");
    list = session.selectList(NS + "select4", map);
    for (Student s : list)
      System.out.println(s);

    map.clear();
    map.put("grade", 2);
    map.put("height", 180);
    System.out.println("2�г� �л� �� Ű�� 180�̻��� �л��� ���ڵ� ��ȸ�ϱ�");
    list = session.selectList(NS + "select4", map);
    for (Student s : list)
      System.out.println(s);

    // System.out.println("101,201,301�а��� ���� �л��� ���ڵ�");
    // List<Integer> mlist = Arrays.asList(101, 201);
    // map.clear();
    // map.put("column", "deptno1");
    // map.put("datas", mlist);
    // list = session.selectList(NS + "select5", map);
    // for (Student s : list)
    // System.out.println(s);

    System.out.println("�����԰� 72, 70, 82�� �л��� ���ڵ�");
    List<Integer> mlist = Arrays.asList(72, 70, 82);
    map.clear();
    map.put("column", "weight");
    map.put("datas", mlist);
    list = session.selectList(NS + "select5", map);
    for (Student s : list)
      System.out.println(s);



  }

}
