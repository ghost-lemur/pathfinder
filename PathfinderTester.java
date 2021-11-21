import java.util.*;

public class PathfinderTester {
	public static void main(String[] args)
	{
		Town t = new Town();
		String[][] map = t.getMap();
		for(String[] row:map)
		{
			for(String col:row)
			{
				System.out.printf("%-10s", col);
			}
			System.out.println();
		}
		System.out.println();
		//Fields are not traversable
		Pathfinder p = new Pathfinder(map, true);
		long startTime = System.currentTimeMillis();
		List<int[]> path = new ArrayList<int[]> (p.pathfind(8, 2, "market"));
		long deltaTime = System.currentTimeMillis() - startTime;
		System.out.println("Starting position: (8, 2)");
		System.out.println("Objective: pathfind to closest market");
		for(int[] psn:path)
		{
			System.out.println("("+psn[0]+", "+psn[1]+")");
		}
		System.out.println("Approximate Calculation Time: " + deltaTime +"ms");
	}
}
