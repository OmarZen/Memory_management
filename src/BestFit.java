import java.util.Vector;

public class BestFit {
    // Java implementation of Best - Fit algorithm
    public int ProcessArr_size = 15;
    public Process[] Process_arr = new Process[ProcessArr_size];
    public int PartitionArr_size = 15;
    public Partition[] Partition_arr = new Partition[PartitionArr_size];
    // the vector to store the processes dont allocated to a Partition
    //to be added to the compaction fragment
    public Vector<Process> remaning_processes = new Vector<Process>();

    // constructor to set the size of both Partition arr & Process arr
    // and initializing both arrays to not give null pointers
    BestFit(int partitoin_size, int proccess_size) {
        PartitionArr_size = partitoin_size;
        ProcessArr_size = proccess_size;
        for (int i = 0; i < partitoin_size; i++) {
            Partition_arr[i] = new Partition();
        }
        for (int j = 0; j < proccess_size; j++) {
            Process_arr[j] = new Process();
        }
    }

    public void setBestFit(Process[] proc_Arr, Partition[] part_Arr) {
        for (int i = 0; i < PartitionArr_size; i++) {
            Partition_arr[i] = part_Arr[i];
        }
        for (int i = 0; i < ProcessArr_size; i++) {
            Process_arr[i] = proc_Arr[i];
        }
    }

    void bestFit() {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[ProcessArr_size];

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < ProcessArr_size; i++) {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j = 0; j < PartitionArr_size; j++) {
                if (Partition_arr[j].getPsize() >= Process_arr[i].getProcess_size()) {
                    if (bestIdx == -1)// awel mara bne3mlo store fe awel mkan yenasbo
                        bestIdx = j;  // el iteration ely b3dha bndawar 3la mkan tany monaseb aktar
                    else if (Partition_arr[bestIdx].getPsize() > Partition_arr[j].getPsize())
                        bestIdx = j;
                }
            }

            // If we could find a block for current process
            if (bestIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;

                // Reduce available memory in this block.
                Partition_arr[bestIdx].setPsize(Partition_arr[bestIdx].getPsize() - Process_arr[i].getProcess_size());
            }
            //if we did not find a block for current process
            if(bestIdx==-1)
            {
                //means that process i was not allocated to a block
                remaning_processes.add(Process_arr[i]);
            }
        }

        System.out.println("\nProcess No.  \tProcess Size  \tBlock no.");
        for (int i = 0; i < ProcessArr_size; i++) {
            System.out.print(" " + (i + 1) + "\t\t \t\t" + Process_arr[i].getProcess_size() + "\t\t");
            if (allocation[i] != -1)
                System.out.print("   \t\t"+allocation[i]);
            else
                System.out.print("\t\tNot Allocated");
            System.out.println();
        }
    }

    public void Compact()
    {
        int compaction_Fragment_Size=0;
        for (int i = 0; i < PartitionArr_size; i++)
        {
            compaction_Fragment_Size=compaction_Fragment_Size+Partition_arr[i].getPsize();
        }
        System.out.println("compaction fragment size: "+compaction_Fragment_Size);
        // if(Remaining_Processes[i]=="DNA")
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

