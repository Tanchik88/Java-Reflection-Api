package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("SqlGenerator is works...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class SqlGeneratorTest {

  private final SqlGenerator sqlGenerator = new SqlGenerator();

  @Test
  void generateTable_for_Staff_class() {
    String expectedSql = "CREATE TABLE Staff (" +
        "id VARCHAR(255) PRIMARY KEY, " +
        "name VARCHAR(255) NOT NULL, " +
        "email VARCHAR(255) UNIQUE NOT NULL);";

    String actualSql = sqlGenerator.generateTable(Staff.class);

    assertEquals(expectedSql, actualSql);
  }

  @Test
  void generateTable_for_Apartment_class() {
    String expectedSql = "CREATE TABLE Apartment (" +
        "id VARCHAR(255) PRIMARY KEY, " +
        "address VARCHAR(255), " +
        "rooms INT NOT NULL);";

    String actualSql = sqlGenerator.generateTable(Apartment.class);

    assertEquals(expectedSql, actualSql);
  }
}
