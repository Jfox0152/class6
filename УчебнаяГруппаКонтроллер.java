import java.util.List;
import java.util.Arrays;

class Teacher {
    private int id;
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class УчебнаяГруппа {
    private Teacher преподаватель;
    private List<Student> студенты;

    public УчебнаяГруппа(Teacher преподаватель, List<Student> студенты) {
        this.преподаватель = преподаватель;
        this.студенты = студенты;
    }

    public Teacher getПреподаватель() {
        return преподаватель;
    }

    public List<Student> getСтуденты() {
        return студенты;
    }
}

class УчебнаяГруппаСервис {
    public УчебнаяГруппа createGroup(Teacher преподаватель, List<Student> студенты) {
        return new УчебнаяГруппа(преподаватель, студенты);
    }
}

public class УчебнаяГруппаКонтроллер {
    private УчебнаяГруппаСервис учебнаяГруппаСервис;

    public УчебнаяГруппаКонтроллер() {
        this.учебнаяГруппаСервис = new УчебнаяГруппаСервис();
    }

    public УчебнаяГруппа createGroup(int преподавательId, List<Integer> студентIds) {
        Teacher преподаватель = getПреподавательById(преподавательId);
        List<Student> студенты = getСтудентыByIds(студентIds);
        return учебнаяГруппаСервис.createGroup(преподаватель, студенты);
    }

    private Teacher getПреподавательById(int id) {
        return new Teacher(id, "Пример Имя Преподавателя");
    }

    private List<Student> getСтудентыByIds(List<Integer> ids) {
        return Arrays.asList(
            new Student(ids.get(0), "Пример Имя Студента 1"),
            new Student(ids.get(1), "Пример Имя Студента 2")
        );
    }

    public static void main(String[] args) {
        УчебнаяГруппаКонтроллер контроллер = new УчебнаяГруппаКонтроллер();
        List<Integer> studentIds = Arrays.asList(1, 2);
        УчебнаяГруппа group = контроллер.createGroup(1, studentIds);

        System.out.println("Преподаватель: " + group.getПреподаватель().getName());
        group.getСтуденты().forEach(student -> System.out.println("Студент: " + student.getName()));
    }
}
