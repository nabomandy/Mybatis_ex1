package mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatisjava.Professor;

public class Main6 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SqlSessionFactory sqlmap = Main1.initMybatis();
    SqlSession session = sqlmap.openSession();

    System.out.println("1. ��� �������� ��ȸ�ϱ�");
    List<Professor> list = session.selectList("professor.select", null);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("2. 101 �а� �������� ��ȸ�ϱ�");
    Map<String, Object> map = new HashMap<>();
    map.put("deptno", 101);
    list = session.selectList("professor.select", map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("3. ������ȣ�� 1001���� �������� ��ȸ�ϱ�");
    map.clear();
    map.put("profno", 1001);
    list = session.selectList("professor.select", map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("4. ���������� ��ȸ�ϱ�");
    map.clear();
    map.put("position", "������");
    list = session.selectList("professor.select", map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("5. 101�а��� ���������� ��ȸ�ϱ�");
    map.clear();
    map.put("deptno", 101);
    list = session.selectList("professor.select", map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("6. 101,201 �а��� �������� ��ȸ�ϱ�");
    map.clear();
    map.put("datas", Arrays.asList(101, 201));
    list = session.selectList("professor.select", map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("7. 101,201�а� ������ ���� ��ȸ�ϱ�");
    map.clear();
    map.put("datas", Arrays.asList(101, 201));
    map.put("position", "������");
    for (Professor s : list)
      System.out.println(s);

  }

}
