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
		long time = System.currentTimeMillis();
		List<int[]> path = new ArrayList<int[]> (p.pathfind(8, 2, "market"));
		System.out.println("Approximate Calculation Time: " + (System.currentTimeMillis()-time)+"ms");
		System.out.println("Starting position: (8, 2)");
		for(int[] psn:path)
		{
			System.out.println("("+psn[0]+", "+psn[1]+")");
		}
	}
}
