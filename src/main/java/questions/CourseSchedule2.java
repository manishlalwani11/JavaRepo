package questions;


import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.




Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]

Output: [0,1]

Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]

Output: [0,2,1,3]

Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.

So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []

Output: [0]
 */
public class CourseSchedule2 {
    public static void main(String[] args) {

        //[[1,0],[2,0],[3,1],[3,2]]
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1,0});
       /* listOfArrays.add(new int[]{2,0});
        listOfArrays.add(new int[]{3,1});
        listOfArrays.add(new int[]{3,2});*/

        System.out.println(listOfArrays);

        //// [[1,0],[2,0],[3,1],[3,2]]

        // 0 0 1 2 --> ArrLis

        // Map
        //0 -> 1,2
        //1 -> 3
        //2 -> 3

        int[][] prerequisites = {
                {2, 0}, {2, 1}
        };

        int numCourses = 3;
        int[] coursesWithOrder = getCourseOrderUsing2DArrayInput(numCourses, prerequisites);
        // Output
        for(int n: coursesWithOrder) {
            System.out.println("Course order with 2d Array: " + n);
        }


        Set<Integer> courseOrder = getCourseOrder(listOfArrays);
        System.out.println("Course order: " + courseOrder);


    }

    private static int[] getCourseOrderUsing2DArrayInput(int numCourses,
                                                         int[][] prerequisites) {

        //// [[1,0],[2,0],[3,1],[3,2]]

        /* 2D Array
             ---------->>>
           Y 0 1 -->
         X
         |
         |   1 0
         |   2 0
         |   3 1
             3 2

         */


        int[] allPossibleCourses = new int[numCourses];
        int value = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            allPossibleCourses[i] = value;
            value--;
        }

        if (numCourses > 0 && prerequisites.length == 0) {
            return allPossibleCourses;
        }

        Set<Integer> coursesInOrder = new LinkedHashSet<>();
        Set<Integer> ancestors = new HashSet<>();
        Map<Integer, List<Integer>> mapOfAncestorsWithDependents = new HashMap<>();
        // 0 -> 1,2    1 -> 3    2 -> 2

        /*for (int[] prerequisite : prerequisites) {
            for (int y = 0; y < prerequisite.length; y++) {
                if (y == prerequisite.length - 1) {
                    coursesInOrder.add(prerequisite[y]);
                    coursesInOrder.add(prerequisite[0]);
                    ancestors.add(prerequisite[y]);
                }
            }
        }

        // TODO => To handle a circular dependency like => [[1,0], [0,1]] and invalid case
        if (numCourses == ancestors.size()) {
            return new int[]{};
        }

        // check if any courses got left from all possible courses, if yes - then add
        Arrays.stream(allPossibleCourses).forEach(coursesInOrder::add);

        return coursesInOrder.stream().mapToInt(x -> x).toArray();*/

        /*
            [2,1],[3,1],[3,2],[1,0]

             2 -> 1
             3 -> 1,2
             1 -> 0

         */

        for (int x = 0; x < prerequisites.length; x++) {
            for (int y = 0; y < prerequisites[x].length; y++) {
                System.out.println(x + "," + y + " - " + prerequisites[x][y]);

               // totalCourses.add(prerequisites[x][y]);
                /*
                  [2,1],[3,1],[3,2],[1,0]

                 2 -> 1
                 3 -> 1,2
                 1 -> 0
                 */
                if (y == 0) {
                    mapOfAncestorsWithDependents
                            .computeIfAbsent(prerequisites[x][0], k -> new ArrayList<>()).add(prerequisites[x][1]);
                }


                // TODO now we have value like this in map
                /*
                 2 -> 1
                 3 -> 1,2
                 1 -> 0
                 */

/*
                if (y == prerequisites[x].length - 1) {
                    coursesInOrder.push(prerequisites[x][y]);

                    if (mapOfAncestorsWithDependents.containsKey(prerequisites[x][y])) {
                        mapOfAncestorsWithDependents.get(prerequisites[x][y]).add(prerequisites[0][y]);
                    } else {
                        mapOfAncestorsWithDependents.put(prerequisites[x][y], new ArrayList<>(prerequisites[0][y]));
                    }
                }*/
            }
        }

        // TODO => To handle a circular dependency like => [[1,0], [0,1]] and invalid case
        if (numCourses == mapOfAncestorsWithDependents.keySet().size()) {
            return new int[]{};
        }

        /*// 0 -> 1,2    1 -> 3    2 -> 2
        Set<Integer> result = new LinkedHashSet<>();

        while (!coursesInOrder.isEmpty()) {
            int n = coursesInOrder.pop();
            if (mapOfAncestorsWithDependents.containsKey(n)) {
                result.add(n);
                result.addAll(mapOfAncestorsWithDependents.get(n));
                mapOfAncestorsWithDependents.remove(n);
                totalCourses.removeAll(result);
            } else {
                result.add(n);
                totalCourses.remove(n);
            }
        }

        if (!totalCourses.isEmpty()) {
            result.addAll(totalCourses);
        }

        Arrays.stream(allPossibleCourses).forEach(result::add);

        return result.stream().mapToInt(x -> x).toArray();*/
        return null;
    }

    private static Set<Integer> getCourseOrder(List<int[]> listOfArrays) {

        if (listOfArrays.isEmpty()) {
            new LinkedHashSet<>().add(0);
        }

        List<Integer> prerequisites = new ArrayList<>();
        Set<Integer> totalCourses = new HashSet<>();
        Map<Integer, List<Integer>> mapOfPrerequisitesWithDependents = new HashMap<>();

        //// listOfArrays ->  [[1,0],[2,0],[3,1],[3,2]]
        for (int[] nums : listOfArrays) {
            prerequisites.add(nums[1]);
            totalCourses.add(nums[0]);
            totalCourses.add(nums[1]);
            if (mapOfPrerequisitesWithDependents.containsKey(nums[1])) {
                mapOfPrerequisitesWithDependents.get(nums[1]).add(nums[0]);
            } else {
                mapOfPrerequisitesWithDependents.put(nums[1], new ArrayList<>(nums[0]));
            }
        }

        Set<Integer> result = new LinkedHashSet<>();

        for (int n : prerequisites) {
            if (mapOfPrerequisitesWithDependents.containsKey(n)) {
                result.add(n);
                result.addAll(mapOfPrerequisitesWithDependents.get(n));
                totalCourses.removeAll(mapOfPrerequisitesWithDependents.get(n));
                mapOfPrerequisitesWithDependents.remove(n);
            } else {
                result.add(n);
                totalCourses.remove(n);
            }
        }

        if (!totalCourses.isEmpty()) {
            result.addAll(totalCourses);
        }

        return result;
    }
}
