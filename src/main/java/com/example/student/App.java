package com.example.student;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    System.out.println("Git 实践：测试修改代码");
    System.out.println("分支：改变搜索");

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 设置控制台输出编码为 GBK（适用于 Windows 控制台）
        System.setOut(new PrintStream(System.out, true, "UTF-8"));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 学生管理系统 ===");
            System.out.println("1. 添加学生");
            System.out.println("2. 查看所有学生");
            System.out.println("3. 查询学生");
            System.out.println("4. 退出");
            System.out.print("请选择：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 清空输入缓冲

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    System.out.println("退出系统！");
                    return;
                default:
                    System.out.println("无效的选项！");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 清空输入缓冲
        System.out.print("输入学生学号：");
        String id = scanner.nextLine();

        students.add(new Student(name, age, id));
        System.out.println("学生添加成功！");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息！");
        } else {
            System.out.println("=== 所有学生信息 ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("输入要查询的学生姓名：");
        String name = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("未找到该学生的信息！");
        }
    }
}
