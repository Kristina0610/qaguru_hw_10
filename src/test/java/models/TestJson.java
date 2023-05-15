package models;

import java.util.List;

public class TestJson {
  private String name;
  private Integer age;
  private List<PetsItem> pets;

  public List<PetsItem> getPets() {
    return pets;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

}
