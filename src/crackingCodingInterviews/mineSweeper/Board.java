package crackingCodingInterviews.mineSweeper;

public class Board {
	private Cell[][] grid;
	private int size;
	
	public Board(int size) {
		this.size = size;
	}
	
	public void initialise() {
		clear();
		int bombCount = 20*(size*size)/100; //30% of map will be bombs
		spawnBombs(bombCount);
		spawnNeighbours();
	}
	
	public boolean isBomb(int x, int y) {
		grid[x][y].reveal();
		for(Cell c: getNeighbours(x,y)) {
			if(c!=null)
				if(c.value==0)
					c.reveal();
		}
		if(grid[x][y].value==-1) return true;
		return false;
	}
	
	private void clear() {
		grid = new Cell[size][size];
		for(int i=0; i<size; i++) 
			for(int j=0; j<size; j++)
				grid[i][j] = null;
	}
	
	private void spawnBombs(int count) {
		for(int i=0;i<count;i++) {
			int x = randomInRange(0,size-1);
			int y = randomInRange(0,size-1);
			grid[x][y] = new Cell(x,y,-1);
		}
	}
	
	private void spawnNeighbours() {
		for(int i=0; i<size; i++) {
			for(int j=0;j<size;j++) {
				if(grid[i][j]==null)
					grid[i][j]=new Cell(i,j,countBombs(i,j));
			}
		}
	}
	
	private int countBombs(int x, int y) {
		int count = 0;
		for(Cell c: getNeighbours(x,y))
			if(c!=null)
				count += c.value == -1 ? 1 : 0;
		return count;
	}
	
	private Cell[] getNeighbours(int x, int y) {
		
		Cell topLeft = x-1>=0 && y-1>=0 ? grid[x-1][y-1] : null;
		Cell topMid = y-1>=0 ? grid[x][y-1] : null;
		Cell topRight = x+1<size && y-1>=0 ? grid[x+1][y-1] : null;
		
		Cell midLeft = x-1>=0 ? grid[x-1][y] : null;
		Cell midRight = x+1<size ? grid[x+1][y] : null;
		
		Cell botLeft = x-1>=0 && y+1<size ? grid[x-1][y+1] : null;
		Cell botMid = y+1<size ? grid[x][y+1] : null;
		Cell botRight = x+1<size && y+1<size ? grid[x+1][y+1] : null;
		
		Cell[] neighbours = {topLeft, topMid, topRight, midLeft, midRight, botLeft, botMid, botRight};
		
		return neighbours; 
	} 
	
	private int randomInRange(int min, int max) {
		return (int) ((Math.random()*max)+min);
	}

	public void display() {
		displayDivider();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				grid[i][j].display();
			}
			System.out.println();
			displayDivider();
		}
	}
	
	private void displayDivider() {
		for(int i=0;i<size;i++) {
			System.out.print(" - ");
		}
		System.out.println();
	}
}
