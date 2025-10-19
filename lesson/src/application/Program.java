package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    List<Lesson> list = new ArrayList<>();

    System.out.print("Quantas aulas tem o curso? ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
      System.out.println();
      System.out.println("Dados da " + i + "a aula: ");
      System.out.print("Conteúdo ou tarefa (c/t)? ");
      char lesson = sc.next().charAt(0);
      sc.nextLine();
      System.out.print("Titulo: ");
      String titulo = sc.nextLine();

      if (lesson == 'c') {
        System.out.print("URL do vídeo: ");
        String url = sc.nextLine();
        System.out.print("Duração em segundos: ");
        int duracao = sc.nextInt();
        sc.nextLine();
        list.add(new Video(titulo, url, duracao));
      }
      else if (lesson == 't') {
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Quantidade de questões: ");
        int questoes = sc.nextInt();
        sc.nextLine();
        list.add(new Task(titulo, descricao, questoes));
      }   

    }
    
    int duracaoTotal = 0;      

    for (Lesson lesson : list) {      
      duracaoTotal += lesson.duration();      
    }    

    System.out.println();
    System.out.println("DURAÇÃO TOTAL DO CURSO = " + duracaoTotal + " segundos");

    sc.close();

  }

}
