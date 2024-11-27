package com.company.model;

import com.company.enums.Priority;
import com.company.enums.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static int idCounter = 1;
    private static int id;

    public static void main(String[] args) {
        boolean proceed = true;
        while (proceed){
            System.out.println("Escolha qual das opções deseja prosseguir: \n1. Adicionar\n2. Listar\n3. Editar\n4. Excluir\n5. Sair");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    proceed = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            if (proceed){
                boolean validAnswer = false;
                while (!validAnswer) {
                    System.out.println("Voltar ao menu anterior? \n1. Sim\n2. Encerrar");
                    int answer = sc.nextInt();
                    if (answer == 1) {
                        validAnswer = true;
                    } else if (answer == 2) {
                        System.out.println("Volte sempre!");
                        proceed = false;
                        validAnswer = true;
                    } else {
                        System.out.println("Você forneceu um número diferente, tente novamente");
                    }
                }
            }
        }
        sc.close();
    }
    public static void add(){
        System.out.println("Adicionar nova tarefa");
        sc.nextLine();
        String title = getInput("- Título:");
        String description = getInput("- Descrição:");
        String maturity = getInput("- Data de vencimento:");
        String priorityInput = getInput("- Prioridade: (alta, média ou baixa)");
        Priority priorityEnum = Priority.fromString(priorityInput);  // Conversão para o Enum
        String statusInput = getInput("- Status (A Fazer, Pendente ou Feito):");
        Status statusEnum = Status.fromString(statusInput);  // Conversão para o Enum
        tasks.add(new Task(idCounter++, title, description, maturity, priorityEnum, statusEnum));
        System.out.println("Tarefa adicionada");
    }

    public static void list(){
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa registrada");
        } else {
            for (Task task : tasks){
                System.out.println(task);
            }
        }
    }

    public static void edit() {
        list();
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa registada");
            return;
        }

        System.out.println("Selecione o ID da tarefa que deseja alterar");
        id = sc.nextInt();
        sc.nextLine();

        Task selectedTask = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                selectedTask = task;
                break;
            }
        }
        if (selectedTask == null) {
            System.out.println("ID inválido. Nenhuma tarefa encontrada");
            return;
        }
        System.out.println("Qual campo deseja alterar? \n1. Título\n 2. Descrição\n 3. Data de Vencimento\n 4. Prioridade\n 5. Status");
        int editField = sc.nextInt();
        sc.nextLine();
        switch (editField) {
            case 1:
                System.out.println("Digite o novo título:");
                selectedTask.setTitle(sc.nextLine());
                break;
            case 2:
                System.out.println("Digite a nova descrição:");
                selectedTask.setDescription(sc.nextLine());
                break;
            case 3:
                System.out.println("Digite a nova data de vencimento:");
                selectedTask.setMaturity(sc.nextLine());
                break;
            case 4:
                System.out.println("Digite a nova prioridade:");
                String priorityInput = sc.nextLine();    // Convertendo para o enum Status
                Priority priorityEnum = Priority.fromString(priorityInput);
                selectedTask.setPriority(priorityEnum);
                break;
            case 5:
                System.out.println("Digite o novo status:");
                String statusInput = sc.nextLine();
                Status statusEnum = Status.fromString(statusInput);
                selectedTask.setStatus(statusEnum);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        System.out.println("Tarefa atualizada");
        System.out.println(selectedTask);
    }

    public static void delete(){
        list();
        if (tasks.isEmpty()){
            System.out.println("Nenhuma tarefa registrada");
        } else{
            System.out.println("Selecione o ID da tarefa que deseja remover");
            id = sc.nextInt();
            if (id > 0 && id <= tasks.size()){
                tasks.remove(id - 1);
            } else {
                System.out.println("ID inválido");
            }
        }
    }

    public static String getInput(String prompt) {
        System.out.print(prompt + " ");
        return sc.nextLine();
    }
}
