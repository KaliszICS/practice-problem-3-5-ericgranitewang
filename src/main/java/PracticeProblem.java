public class PracticeProblem {

	public static void main(String args[]) {
		String[][] maze = {
                    { "", "", "", "", "" },
                    { "", "", "", "", "" },
                    { "", "", "", "F", "" },
                    { "S", "", "", "", "" },
            };
		System.out.println(noOfPaths(maze));
	}

	public static int searchMazeMoves(String[][] grid) {
		int row = grid.length-1;
		int col = 0;
		return searchMazeMovesReal(grid, row, col);
	}

	public static int searchMazeMovesReal(String[][] grid, int row, int col) {
		if (row < 0 || col >= grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (grid[row][col].equals("F")) {
			return 0;
		}
		int a = searchMazeMovesReal(grid, row-1, col);
		int b = searchMazeMovesReal(grid, row, col+1);
		if (Math.min(a, b) == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return Math.min(a, b)+1;
	}

	public static int noOfPaths(String[][] grid) {
		int row = grid.length-1;
		int col = 0;
		return noOfPathsReal(grid, row, col);
	}

	public static int noOfPathsReal(String[][] grid, int row, int col) {
		if (row < 0 || col >= grid[0].length) {
			return 0;
		}
		if (grid[row][col].equals("F")) {
			return 1;
		}
		int a = noOfPathsReal(grid, row-1, col);
		int b = noOfPathsReal(grid, row, col+1);
		return a+b;
	}
}
