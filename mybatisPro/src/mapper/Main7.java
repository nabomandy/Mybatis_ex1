package mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatisjava.Professor;

public class Main7 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SqlSessionFactory sqlmap = Main1.initMybatis();
    SqlSession session = sqlmap.openSession();

    System.out.println("1. 모든 교수정보 조회하기");
    List<Professor> list = session.getMapper(ProfessorMapper_IF.class).select(null);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("2. 101 학과 교수정보 조회하기");
    Map<String, Object> map = new HashMap<>();
    map.put("deptno", 101);
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("3. 교수번호가 1001번인 교수정보 조회하기");
    map.clear();
    map.put("profno", 1001);
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("4. 정교수정보 조회하기");
    map.clear();
    map.put("position", "정교수");
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("5. 101학과의 정교수정보 조회하기");
    map.clear();
    map.put("deptno", 101);
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("6. 101,201 학과의 교수정보 조회하기");
    map.clear();
    map.put("datas", Arrays.asList(101, 201));
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

    System.out.println("7. 101,201학과 조교수 정보 조회하기");
    map.clear();
    map.put("datas", Arrays.asList(101, 201));
    map.put("position", "조교수");
    list = session.getMapper(ProfessorMapper_IF.class).select(map);
    for (Professor s : list)
      System.out.println(s);

  }
}
