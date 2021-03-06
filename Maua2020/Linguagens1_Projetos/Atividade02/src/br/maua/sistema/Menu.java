package br.maua.sistema;

import java.util.ArrayList;
import java.util.Scanner;

import br.maua.enums.SystemTime;
import br.maua.interfaces.MemberApresentacao;
import br.maua.models.BigBrother;
import br.maua.models.HeavyLifter;
import br.maua.models.Member;
import br.maua.models.MobileMember;
import br.maua.models.ScriptGuy;

/**
 * Classe onde realmente ocorre o código
 * Inicia as instâncias dos objetos, sendo que 
 * é nesta classe que o usuário interage com o código.
 * @author André Lebrão A Ribeiro 18.00356-7 - andledrao@gmail.com
 * @author João Guilherme Martins Jatobá 18.01790-8 - jguilhermejatoba@hotmail.com
 * @since 08/06/2000
 * @version 1.0
 */
 

public abstract class Menu implements MemberApresentacao{
    
    private static ArrayList<Member> memberList = new ArrayList<>();
    private static SystemTime sTime = SystemTime.REGULAR;
    
    public static void trocarSystemTime(){
        if (sTime.equals(SystemTime.REGULAR)) {
            sTime = SystemTime.EXTRA;
        } else {
            sTime = SystemTime.REGULAR;
        }
    }
    public static String getSystemTime(){
        if (sTime.equals(SystemTime.REGULAR)) {
            return "Regular";
        } else {
            return "Extra";
        }
    }

    //TODO: encapsular os metodos cadastrar e remover members, mas precisa lidar com o scanner abrindo e fechando
    public static void run(){
        boolean flag = true;
        int option;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Escolha uma opção: \n1 - Cadastrar\n2 - Remover\n3 - Postar Mensagem\n4 - Apresentar\n5 - Trocar Hora de Trabalho\n0 - Sair");
            System.out.printf("Hora de trabalho: %s\n\n",getSystemTime());
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    flag = false;
                    /**
                     * Acaba o código se a escolha for 0
                     */
                    break;
                case 1:
                /**
                 * Case 1 - Cadastro dos membros, com nome, email e cargo
                 */
                    // try {
                            //TODO: colcoar da linha 53 a 75 aqui dentro
                    // } catch (Exception e) {
                    //     //TODO: handle exception
                    // }
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("\nEscolha o cargo:\n1 - Mobile Member\n2 - Heavy Lifter\n3 - Big Brother\n4 - Script Guy\n");
                    int cargo = scanner.nextInt();
                    /**
                     * @param nome Nome do membro
                     * @param email Email do membro
                     * @param cargo Escolha do usuário em colocar
                     * o membro como cargo de escolha.
                     */

                    scanner.nextLine();
                    switch (cargo) {
                        /**
                         * Cada case respresenta uma possível escolha de cargo
                         * Default case impede a criação de cargo que não está na lista
                         */
                        case 1:
                            memberList.add(new MobileMember(nome, email));
                            break;
                        case 2:
                            memberList.add(new HeavyLifter(nome, email));
                            break;
                        case 3:
                            memberList.add(new BigBrother(nome, email));
                            break;
                        case 4:
                            memberList.add(new ScriptGuy(nome, email));
                            break;
                        default:
                            break;
                    }
                    break;
                
                case 2:
                /**
                 * Case 2 - Remoção de um membro da ArrayList principal
                 */
                    System.out.println("Digite o ID do membro a ser retirado: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    memberList.remove(index);
                    break;
                case 3:
                /**
                 * Case 3 - Imprime a assinatura de cada membro da lista
                 */
                    for (Member member : memberList) {
                        member.postarMensagem("", sTime);
                        System.out.println();

                    }
                    break;

                case 4:
                /**
                 * Case 4 - Imprime os dados (ID, Nome, Email e Cargo) de cada membro da lista
                 */
                    int ID = 0;
                    for (Member member : memberList) {
                        System.out.printf("ID: "+ID+"\n");
                        member.apresentar();
                        ID++;
                    }
                    break;
                
                case 5:
                /** 
                 * Case 5 - Troca a hora de trabalho atual
                */
                    trocarSystemTime();
                    break;
                default:
                /**
                 * Default impede cases que não são aceitas
                 */
                    break;
            }
        }

    }
}