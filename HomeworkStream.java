package org.example.hw;
/*

   * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API
   * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API
   *
   * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
   * 1.1 Найти максимальное
   * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
   * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
   *
   * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
   * 2.1 Создать список из 10-20 сотрудников
   * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
   * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
   * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
   * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
   */
 import java.util.ArrayList;
 import java.util.Comparator;
 import java.util.List;
 import java.util.Random;
public class HomeworkStream {
    static Random random = new Random();
    static List<Integer> list = new ArrayList<>(100000);
    static{
        for (int i=0;i<1000;i++){
            list.add(random.nextInt(1_000_000));
        }
    }
    public static void main(String[] args) {

        //* 1.1 Найти максимальное
        int max = list.stream().max(Comparator.naturalOrder()).get();
        // int max = list.stream().mapToInt(x->x).max().getAsInt;
        System.out.println(max);

        // 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        long sum = list.stream().filter(i->i>500_000).mapToLong(i->i*5-150).sum();
        System.out.println(sum);

        // 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long count = list.stream().map(x->x*x).filter(x->x<100_000).count();
        System.out.println(count);

    }
}
