package com.brevitaz.ProjectManagementModule.model;

/**
 * @author dhvanan on 8/2/18 Thursday
 * @project ProjectManagementModule
 **/
public class TeamLeader {

   String id;
   String name;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "TeamLeader{" +
              "id='" + id + '\'' +
              ", name='" + name + '\'' +
              '}';
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      TeamLeader that = (TeamLeader) o;

      if (id != null ? !id.equals(that.id) : that.id != null) return false;
      return name != null ? name.equals(that.name) : that.name == null;
   }


}
