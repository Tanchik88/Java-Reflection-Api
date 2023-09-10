package homework;


public class Main {
  public static void main(String[] args) {
    SqlGenerator sqlGenerator = new SqlGenerator();
    String sqlString = sqlGenerator.generateTable(Apartment.class);

    System.out.println(sqlString);
  }
}
