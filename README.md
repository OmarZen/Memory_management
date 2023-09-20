# Memory Management Simulator

## Description

This Java program simulates memory allocation by allocating variable-sized partitions of memory to a given sequence of process requests. It applies different allocation policies:

1. First-Fit policy.
2. Best-Fit policy.
3. Worst-Fit policy.

The program also includes an option for compaction, which shuffles the memory contents to place all free memory together in one large block.
## Output Example
Partition 0 (15 KB) => Process 1
Partition 6 (30 KB) => Process 3
Partition 8 (45 KB) => External fragment
Partition 1 (20 KB) => External fragment
Partition 2 (5 KB) => External fragment
Partition 3 (30 KB) => External fragment
Partition 4 (90 KB) => Process 2
Partition 7 (30 KB) => External fragment
Partition 5 (80 KB) => External fragment
Process 4 cannot be allocated.
Do you want to compact? 1. yes 2. no
1
Partition 0 (15 KB) => Process 1
Partition 6 (30 KB) => Process 3
Partition 4 (90 KB) => Process 2
Partition 9 (100 KB) => Process 4
Partition 10 (110 KB) => External fragment
## Program Input
Number of partitions
Partition name and its size
Number of process requests
Process name and its size
Selected policy by the user
Program Output
For each scheduler, the program outputs:

Allocation information for each process and partition
External fragmentation information
Compaction option (yes or no)

## Input Example

```plaintext
Enter number of partitions:
6
Partition0 90
Partition1 20
Partition2 5
Partition3 30
Partition4 120
Partition5 80
Enter number of processes:
4
Process1 15
Process2 90
Process3 30
Process4 100
Select the policy you want to apply:
1. First fit
2. Worst fit
3. Best fit
Select policy:
1
