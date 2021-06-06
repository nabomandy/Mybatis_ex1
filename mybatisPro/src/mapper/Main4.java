package mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatisjava.Professor;


public class Main4 {

  // 1. �������̺� ��ϵ� ���ڵ��� �Ǽ��� ����ϱ�
  // 2. �������̺� ��ϵ� ��� ������ ����ϱ�
  // 3. ���� �� 101�� �а��� ���� ������ ����ϱ�
  // 4. ���� �� ���� �达�� �ð����� ������ ����ϱ�


  private final static String NS = "professor.";
  private static Map map = new HashMap();

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int x = 0;
    SqlSessionFactory sqlMap = Main1.initMybatis();
    SqlSession session = sqlMap.openSession(); // sql���

    x = (Integer) session.selectOne("professor.count");
    System.out.println("1. professor ���̺��� ���ڵ� ����:" + x);

    System.out.println("2. �������̺� ��ϵ� ��� ������ ����ϱ�");
    List<Professor> list = session.selectList("professor.list");
    for (Professor p : list)
      System.out.println(p);

    System.out.println("3. ���� �� 101�� �а��� ���� ������ ����ϱ�");
    list = session.selectList("professor.selectdeptno", 101);
    for (Professor p : list)
      System.out.println(p);

    System.out.println("4. ������ ���� �达�� �ð����� ������ ����ϱ�");
    Map<String, Object> map = new HashMap<>();
    map.put("name", "��");
    map.put("position", "������");
    list = session.selectList("professor.selectnameposition", map);
    for (Professor p : list)
      System.out.println(p);


  }
}
