package homework;

import homework.annotations.NotNull;
import homework.annotations.PrimaryKey;
import homework.annotations.Unique;
import homework.annotations.Varchar;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SqlGenerator {
  public String generateTable(Class<?> tableClass) {
    String tableName = tableClass.getSimpleName();
    List<String> columns = new ArrayList<>();

    Field[] fields = tableClass.getDeclaredFields();
    for (Field field : fields) {
      String columnName = field.getName();
      String columnType = "VARCHAR(255)"; // По умолчанию тип столбца

      if (field.isAnnotationPresent(Varchar.class)) {
        Varchar varcharAnnotation = field.getAnnotation(Varchar.class);
        columnType = "VARCHAR(" + varcharAnnotation.maxLength() + ")";
      }

      String constraints = "";

      if (field.isAnnotationPresent(PrimaryKey.class)) {
        constraints += " PRIMARY KEY";
      }

      if (field.isAnnotationPresent(Unique.class)) {
        constraints += " UNIQUE";
      }

      if (field.isAnnotationPresent(NotNull.class)) {
        constraints += " NOT NULL";
      }

      columns.add(columnName + " " + columnType + constraints);
    }

    String columnDefinitions = String.join(", ", columns);
    return "CREATE TABLE " + tableName + " (" + columnDefinitions + ");";
  }
}
