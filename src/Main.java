import java.util.*;

public  class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t\t\t         Wellcome to memory allocation simulator          \t|");
        System.out.println("-----------------------------------------------------------------------");

        System.out.println();
        int numberOfPartitions;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of partitions: ");
        numberOfPartitions = input.nextInt();
        int numberOfProcesses;
        // initialize partitions array
        Partition[] partitions=new Partition[numberOfPartitions];
        for (int i = 0; i < numberOfPartitions; i++)
        {
            partitions[i]=new Partition();
        }

        System.out.println("Enter number of processes: ");
        numberOfProcesses = input.nextInt();
        //initialize processes array
        Process[] processes=new Process[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++)
        {
            processes[i]=new Process();
        }

        int choice;
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        System.out.println();
        System.out.println("1. First-Fit policy ");
        System.out.println("2. Best-Fit policy ");
        System.out.println("3. Worst-Fit policy ");
        System.out.println("5. Exit ");
        do {
            System.out.println();
            System.out.println();
            System.out.println("   SELECT POLICY or EXIT(5):   ");
            choice = input.nextInt();
            System.out.println();
            if(choice==5) {
                System.out.println("    EXIT SUCCESSFULLY  ");
                break;
            }
            switch (choice) {
                case 1: {
                    FirstFit obj1=new FirstFit(numberOfPartitions,numberOfProcesses);
                    System.out.println("NOW FOR PARTITIONS: ");
                    for (int i = 0; i < numberOfPartitions; i++) {
                        System.out.println("Enter partition name: ");
                        partitions[i].setPname( input.next());
                        System.out.println("Enter partition size: ");
                        partitions[i].setPsize( input.nextInt());
                    }
                    System.out.println("NOW FOR PROCESSES : ");
                    for (int i = 0; i < numberOfProcesses; i++) {
                        System.out.println("Enter process name: ");
                        processes[i].setProcess_name( input.next());
                        System.out.println("Enter process size: ");
                        processes[i].setProcess_size(input.nextInt());
                    }
                     obj1.setFirstFit(processes,partitions);
                     obj1.firstFit();
                    System.out.println("1. compact ");
                    System.out.println("2. do not compact ");
                    int choice1= input.nextInt();
                    System.out.println();
                    if(choice1==1 )
                    {
                        obj1.Compact();
                    }
                    else if(choice1==2){
                        System.out.println("done ");
                        break;
                    }
                }
                break;
                case 2: {
                    BestFit obj2=new BestFit(numberOfPartitions,numberOfProcesses);
                    System.out.println("NOW FOR PARTITIONS: ");
                    for (int i = 0; i < numberOfPartitions; i++) {
                        System.out.println("Enter partition name: ");
                        partitions[i].setPname( input.next());
                        System.out.println("Enter partition size: ");
                        partitions[i].setPsize( input.nextInt());
                    }
                    System.out.println("NOW FOR PROCESSES : ");
                    for (int i = 0; i < numberOfProcesses; i++) {
                        System.out.println("Enter process name: ");
                        processes[i].setProcess_name( input.next());
                        System.out.println("Enter process size: ");
                        processes[i].setProcess_size(input.nextInt());
                    }
                    obj2.setBestFit(processes,partitions);
                    obj2.bestFit();
                    System.out.println("1. compact ");
                    System.out.println("2. do not compact ");
                    int choice1= input.nextInt();
                    System.out.println();
                    if(choice1==1 )
                    {
                        obj2.Compact();
                    }
                    else if(choice1==2){
                        System.out.println("done ");
                        break;
                    }


                }
                break;
                case 3:
                {
                    WorstFit obj3=new WorstFit(numberOfPartitions,numberOfProcesses);
                    System.out.println("NOW FOR PARTITIONS: ");
                    for (int i = 0; i < numberOfPartitions; i++) {
                        System.out.println("Enter partition name: ");
                        partitions[i].setPname( input.next());
                        System.out.println("Enter partition size: ");
                        partitions[i].setPsize( input.nextInt());
                    }
                    System.out.println("NOW FOR PROCESSES : ");
                    for (int i = 0; i < numberOfProcesses; i++) {
                        System.out.println("Enter process name: ");
                        processes[i].setProcess_name( input.next());
                        System.out.println("Enter process size: ");
                        processes[i].setProcess_size(input.nextInt());
                    }
                    obj3.setWorstFit(processes,partitions);
                    obj3.worstFit();
                    System.out.println("1. compact ");
                    System.out.println("2. do not compact ");
                    int choice1= input.nextInt();
                    System.out.println();
                    if(choice1==1 )
                    {
                        obj3.Compact();
                    }
                    else if(choice1==2){
                        System.out.println("done ");
                        break;
                    }

                }
                break;
                default: {
                    System.out.println(" SORRY WRONG ENTRY ");
                    break;
                }

            }

        }while(choice!=5);
    }
}