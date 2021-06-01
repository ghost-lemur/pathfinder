import java.util.*;
public class Pathfinder
{
	private String[][] map;
	private boolean[][] isClosedMap;
	
	public Pathfinder(String[][] map, boolean onlyRoadsOpen)
	{
		this.map = map;
		isClosedMap = new boolean[map.length][map[0].length];
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if(onlyRoadsOpen)
				{
					isClosedMap[i][j] = !(map[i][j].equals("road") || 
							map[i][j].equals("market"));
				}
				else
				{
					isClosedMap[i][j] = !(map[i][j].equals("road") ||
							map[i][j].equals("field") ||
							map[i][j].equals("market"));
				}
			}
		}
	}
	
	public List<int[]> pathfind(int startRow, int startCol, int targetRow, int targetCol)
	{
		List<List<int[]>> paths = new ArrayList<List<int[]>>();
		
		paths.add(new ArrayList<int[]>(Arrays.asList(new int[][] {{startRow, startCol}})));
		if(startRow==targetRow && startCol==targetCol)
		{
			return paths.get(0);
		}
		isClosedMap[startRow][startCol] = true;
		int p=0;
		while(paths.size()>0)
		{
			
			List<int[]> path = paths.get(p);
			List<int[]> posJumps = getJumps(path.get(path.size()-1)[0],
					path.get(path.size()-1)[1]);
			int firstJump = -1;
			for(int i=0; i<4; i++)
			{
				if(posJumps.get(i)!=null)
				{
					if(posJumps.get(i)[0]==targetRow &&
							posJumps.get(i)[1]==targetCol)
					{
						path.add(posJumps.get(i));
						return path;
					}
					if(firstJump==-1)
					{
						firstJump = i;
					}
					else
					{
						paths.add(new ArrayList<int[]>(path));
						paths.get(paths.size()-1).add(posJumps.get(i));
					}
				}
			}
			if(firstJump==-1)
			{
				paths.remove(p);
				p--;
			}
			else
			{
				path.add(posJumps.get(firstJump));
			}
			p++;
			if(p>=paths.size())
			{
				p=0;
			}
		}
		return null;
	} 
	public List<int[]> pathfind(int startRow, int startCol, String target)
	{
		List<int[]> targets = new ArrayList<int[]>();
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if(map[i][j].equals(target))
				{
					targets.add(new int[] {i, j});
				}
			}
		}
		
		List<List<int[]>> paths = new ArrayList<List<int[]>>();
		
		paths.add(new ArrayList<int[]>(Arrays.asList(new int[][] {{startRow, startCol}})));
		
		for(int[] t:targets)
		{
			if(Arrays.equals(t, new int[] {startRow, startCol}))
			{
				return paths.get(0);
			}
		}
		
		isClosedMap[startRow][startCol] = true;
		int p=0;
		while(paths.size()>0)
		{
			
			List<int[]> path = paths.get(p);
			List<int[]> posJumps = getJumps(path.get(path.size()-1)[0],
					path.get(path.size()-1)[1]);
			int firstJump = -1;
			for(int i=0; i<4; i++)
			{
				if(posJumps.get(i)!=null)
				{
					for(int[] t:targets)
					{
						if(Arrays.equals(posJumps.get(i), t))
						{
							path.add(posJumps.get(i));
							return path;
						}
					}
					if(firstJump==-1)
					{
						firstJump = i;
					}
					else
					{
						paths.add(new ArrayList<int[]>(path));
						paths.get(paths.size()-1).add(posJumps.get(i));
					}
				}
			}
			if(firstJump==-1)
			{
				paths.remove(p);
				p--;
			}
			else
			{
				path.add(posJumps.get(firstJump));
			}
			p++;
			if(p>=paths.size())
			{
				p=0;
			}
		}
		return null;
	}
	
	public void reset(boolean onlyRoadsOpen)
	{
		isClosedMap = new boolean[map.length][map[0].length];
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				if(onlyRoadsOpen)
				{
					isClosedMap[i][j] = !(map[i][j].equals("road") ||
							map[i][j].equals("market"));
				}
				else
				{
					isClosedMap[i][j] = !(map[i][j].equals("road") ||
							map[i][j].equals("field") ||
							map[i][j].equals("market"));
				}
			}
		}
	}
	
	/*
	 * gets all valid spaces adjacent to the given space 
	 */
	public List<int[]> getJumps(int row, int col)
	{
		
		List<int[]> jumps = new ArrayList<int[]>();
		
		if(0<=row-1 && !isClosedMap[row-1][col])
		{
			jumps.add(new int[] {row-1, col});
			isClosedMap[row-1][col]=true;
		}
		else
		{
			jumps.add(null);
		}
		
		if(col+1<map[row].length && !isClosedMap[row][col+1])
		{
			jumps.add(new int[] {row, col+1});
			isClosedMap[row][col+1]=true;
		}
		else
		{
			jumps.add(null);
		}
		
		if(row+1<map.length && !isClosedMap[row+1][col])
		{
			jumps.add(new int[] {row+1, col});
			isClosedMap[row+1][col]=true;
		}
		else
		{
			jumps.add(null);
		}
		
		if(0<=col-1 && !isClosedMap[row][col-1])
		{
			jumps.add(new int[] {row, col-1});
			isClosedMap[row][col-1]=true;
		}
		else
		{
			jumps.add(null);
		}
		
		return jumps;
	}
	
	public boolean[][] getMap()
	{
		return isClosedMap;
	}
}
