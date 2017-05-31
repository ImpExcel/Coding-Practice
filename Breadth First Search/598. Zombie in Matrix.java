/*
598. Zombie in Matrix

Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2.

*/

public class Solution {
	class Node {
		public int x, y;
		public int step;
		public Node() {}
		public Node(int x, int y int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	
	public int zombie(int[][] grid) {
		int sum_zombie = 0;
		int sum_wall = 0;
		int n = grid.length;
		int m = grid[0].length;
        Queue<Node> qzombie = new LinkedList<Node>();
		
		// 遍历，统计僵尸数目和墙的数目
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					qzombie.offer(new Node(i, j, 0));
					sum_zombie++;
				}
				if (grid[i][j] == 2) {
					sum_wall++;
				}
			}
		}
		
		int step = 0;
		while (qzombie.peek() != null) {
			Node p = qzombie.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x < 0 || x > n - 1 || y < 0 || y> m - 1) {
					continue;
				}
				if (grid[x][y] == 0) {
					grid[x][y] = 1;
					qzombie.offer(new Node(x, y, p.step + 1));
					sum_zombie++
				} 
			}
			if (qzombie.peek() == null) {
				step = p.step;
			}
		}
		if (sum_zombie + sum_wall != n * m) {
			return -1;
		} else {
			return step;
		}
	}
}





















