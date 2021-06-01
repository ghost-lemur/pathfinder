public class Town
{
	private String[][] map;
	
	public Town()
	{
		map = new String[][]
				{
			{"forest", "forest", "forest", "road", "field", "road", "road", "road", "road", "forest"}, 
			{"forest", "forest", "forest", "road", "field", "field", "field", "road", "market", "forest"}, 
			{"forest", "forest", "forest", "road", "field", "field", "field", "road", "forest", "forest"},
			{"forest", "field", "road", "road", "road", "road", "road", "road", "forest", "forest"},
			{"field", "field", "road", "field", "field", "field", "road", "forest", "forest", "forest"},
			{"field", "field", "road", "field", "field", "field", "road", "forest", "forest", "forest"},
			{"forest", "forest", "road", "road", "road", "road", "road", "road", "forest", "forest"},
			{"forest", "forest", "road", "field", "field", "field", "field", "road", "field", "field"},
			{"forest", "forest", "road", "field", "field", "forest", "forest", "road", "field", "field"},
			{"forest", "forest", "forest", "forest", "forest", "forest", "forest", "road", "field", "field"}
				};
	}
	
	public String[][] getMap()
	{
		return map;
	}
}
