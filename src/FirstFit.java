import java.util.Vector;

public class FirstFit {
    public int ProcessArr_size=15;
    public Process[] Process_arr=new Process[ProcessArr_size];
    public int PartitionArr_size=15;
    public Partition[] Partition_arr=new Partition[PartitionArr_size];
    public Vector<Process> remaning_processes = new Vector<Process>();

    // implementation of First - Fit algorithm
    FirstFit(int partitoin_size,int proccess_size)
    {
        PartitionArr_size=partitoin_size;
        ProcessArr_size=proccess_size;
       // remaning_Process_count=0;
        for (int i = 0; i < partitoin_size; i++)
        {
            Partition_arr[i]=new Partition();
        }
        for (int j = 0; j < proccess_size; j++) {
            Process_arr[j]=new Process();
        }

    }

    public void setFirstFit(Process[] proc_Arr,Partition[] part_Arr)
    {
        for (int i = 0; i < PartitionArr_size; i++) {
            Partition_arr[i]=part_Arr[i];
        }
        for (int i = 0; i < ProcessArr_size; i++) {
            Process_arr[i]=proc_Arr[i];
        }
    }



    public void firstFit() {
        // Stores block id of the
        // block allocated to a process
        int[] allocation = new int[ProcessArr_size];
        //int count=0;
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -2;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < ProcessArr_size; i++) {
            for (int j = 0; j < PartitionArr_size; j++) {
                if (Partition_arr[j].getPsize() >= Process_arr[i].getProcess_size()) {
                    // allocate block j to p[i] process
                    allocation[i] = j;
                    Process_arr[i].setIs_allocated(true);
                    // Reduce available memory in this block.
                    Partition_arr[j].setPsize(Partition_arr[j].getPsize() - Process_arr[i].getProcess_size());
                    break;
                }
            }
            if(allocation[i]==-2)
            {
                //means that process i was not allocated to a block
                //count++;
                remaning_processes.add(Process_arr[i]);
            }
        }
            System.out.println("number of processes not allocated to a block"+remaning_processes.size());
            System.out.println("\nProcess No. \tProcess Size\tBlock no.");
            for (int i = 0; i < ProcessArr_size; i++)
            {//change from n1 to n2
                System.out.print(" " + (i + 1) + " \t\t\t\t" + Process_arr[i].getProcess_size() + "\t\t");// there is problem

                if (allocation[i] != -2)
                    System.out.print("   \t\t" + allocation[i]+"\t\t");
                else
                    System.out.print(" \t\t Not Allocated"+"\t\t");
                System.out.println();
            }


    }

    public void Compact()
    {
        // first for loop to calculate the remaining spaces in all the partitions
        int compaction_Fragment_Size=0;
        for (int i = 0; i < PartitionArr_size; i++)
        {
            compaction_Fragment_Size=compaction_Fragment_Size+Partition_arr[i].getPsize();
        }
        System.out.println("compaction fragment size: "+compaction_Fragment_Size);
       // allocate the compaction fragment to remaining process
        if(remaning_processes.isEmpty())
        {
            System.out.println("there is no need to compaction since all processes are allocated");
        }
        for(int i = 0; i < remaning_processes.size(); i++)
        {
            if(compaction_Fragment_Size>=remaning_processes.get(i).getProcess_size())//deleted condition
            {
                compaction_Fragment_Size-=remaning_processes.get(i).getProcess_size();
                System.out.println("compaction fragment contain: "+remaning_processes.get(i).getProcess_name());
            }
            else if(remaning_processes.isEmpty())
            {
                System.out.println("there is no need to compaction since all processes are allocated");
            }
            else if(compaction_Fragment_Size<remaning_processes.get(i).getProcess_size())
            {
                System.out.println("Sorry no enough space in remaining fragment for Process"+(i+1)+"not allocated");
            }
        }
    }
}








