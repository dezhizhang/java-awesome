package shop.xiaozhicloud.demeter;


import java.util.ArrayList;
import java.util.List;

public class Demeter {
    public static void main(String[] args) {
    }
}

// 学校总部员工类
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeEmployee {

}


class CollegeManager {
    // 返回学校的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            list.add(collegeEmployee);
        }
        return list;
    }

    public void printEmployee() {
        List<CollegeEmployee> list = getAllEmployee();
        System.out.println("---------学院员工-------");
        for (CollegeEmployee collegeEmployee : list) {
            System.out.println(collegeEmployee);
        }
    }
}




