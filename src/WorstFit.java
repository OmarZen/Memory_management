import java.util.Vector;

public class WorstFit {
    // Java implementation of worst - Fit algorithm


    //15 is just initilization
    public int ProcessArr_size = 15;

    //array of processes
    public Process[] Process_arr = new Process[ProcessArr_size];

    //15 is just initilization
    public int PartitionArr_size = 15;

    //array of partitions
    public Partition[] Partition_arr = new Partition[PartitionArr_size];
    public Vector<Process> remaning_processes = new Vector<Process>();


    // constructor to set the size of both Partition arr & Process arr
    // and initializing both arrays to not give null pointers
    WorstFit(int partitoin_size, int proccess_size) {
        PartitionArr_size = partitoin_size;
        ProcessArr_size = proccess_size;
        for (int i = 0; i < partitoin_size; i++) {
            Partition_arr[i] = new Partition();
        }
        for (int j = 0; j < proccess_size; j++) {
            Process_arr[j] = new Process();
        }
    }

    // after we initialized both arrays ,
    // we set them to values in the main
    public void setWorstFit(Process[] proc_Arr, Partition[] part_Arr) {

        for (int i = 0; i < PartitionArr_size; i++) {
            Partition_arr[i] = part_Arr[i];
        }
        for (int i = 0; i < ProcessArr_size; i++) {
            Process_arr[i] = proc_Arr[i];
        }
    }

     void worstFit() {
        // Stores block id of the block allocated to a process
        int allocation[] = new int[ProcessArr_size ];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < ProcessArr_size ; i++) {
            // Find the best fit block for current process
            int wstIdx = -1;
            for (int j = 0; j < PartitionArr_size; j++) {
                if (Partition_arr[j].getPsize() >= Process_arr[i].getProcess_size()) {
                    if (wstIdx == -1)
                        wstIdx = j;
                    // in the worst fit we choose the biggest partition could be
                    else if (Partition_arr[wstIdx].getPsize() < Partition_arr[j].getPsize())
                        wstIdx = j;
                }
            }

            // If we could find a block for current process
            if (wstIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = wstIdx;

                // Reduce available memory in this block.
                // 3shan e7na a5adn goz2 mn el partition ll process
                Partition_arr[wstIdx].setPsize(Partition_arr[wstIdx].getPsize()-Process_arr[i].getProcess_size());
            }
            if(wstIdx==-1)
            {
                //means that process i was not allocated to a block
                remaning_processes.add(Process_arr[i]);
            }
        }

        System.out.println("\nProcess No.  \tProcess Size  \tBlock no.");
        for (int i = 0; i < ProcessArr_size; i++)
        {
            System.out.print(" " + (i + 1) + "\t\t\t\t" + Process_arr[i].getProcess_size() + " \t\t");
            if (allocation[i] != -1)
                System.out.print("   \t\t "+allocation[i] );
            else
                System.out.print("   \t\tNot Allocated");
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



