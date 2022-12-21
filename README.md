## There's Treasure Everywhere

A group of pirates, like Jack Sparrow, Davy Jones and Elizabeth Swann, has somehow landed their hands on some very valuable treasure! And now it is time to decide how this loot is divided among the pirates. Your work is to help this motley crew use software to manage their treasure.

## Task 0: Basic Treasure Allocation

You will primarily have to implement the method `PirateManager.buildPiratesWithTreasure`. This method takes as input an array `treasures` of `Treasure` references and an array `pirateNames` of `String` references. The array of `String` references refers to the names of the pirates. These two arrays, jointly, represent the mapping of treasure to pirates. The pirate at `pirateName[i]` gets `treasures[i]`. You then have to return a `List` of `Pirate`s with each `Pirate` having the appropriate allocation of treasures.

This task involves implementing these methods in the `Pirate` class:

1. the constructor
2. `addTreasure`
3. `getTreasureValue`
4. `getHighestValueTreasure`

This task has been completed for you. So you should start by understanding the provided implementation. *This class has one other method that features later, which you need to implement.*

**Start by looking at the provided tests first!**

## Task 1: Is the Allocation Balanced?

In this task, you have to take the allocation obtained from Task 1, for instance, and determine if the allocation is balanced with some margin for deviation. Suppose there are $N$ pirates and the total value of **all** treasure is $T$, and if the allowed deviation is $p\%$, an allocation is balanced if each pirate gets treasure (of total value) that is in the range $[T/N \times (100 - p)/100, T/N \times (100 + p)/100]$. You have to implement `PirateManager.isBalanced`, which takes the array of treasures, the list of pirates with the treasure allocations (say, from Task 0), and the permitted deviation, and determines if the allocation is balanced. (All the treasure that is up for allocation has to be allocated.)

## Task 2: Software Robustness

You will have to complete three sub-tasks:

1. Ensure that balanced allocation method (Task 1) verifies that the pirates have a balanced allocation of the actual treasure to be distributed and not some ill-gotten treasure previously not known of.
2. Implement the `getTreasures` method in the `Pirate` class, taking care to ensure that you do not accidentally allow mutation of the `Pirate` instance.
3. Ensure that `PirateManager.buildPiratesWithTreasure` throws an `IllegalArgumentException` when the appropriate precondition is not met.