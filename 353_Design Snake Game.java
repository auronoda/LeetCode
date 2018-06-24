class SnakeGame {
    Deque<Integer> queue;
    Set<Integer> set;
    int width;
    int height;
    int[][] foods;
    int cur;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        set = new HashSet<>();
        set.add(0);
        this.foods = food;
        this.cur = 0;
        queue = new LinkedList<>();
        queue.addFirst(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        set.remove(queue.peekFirst());
        int r = queue.getLast() / width;
        int c = queue.getLast() % width;
        switch (direction) {
            case "U":
                r--;
                break;
            case "D":
                r++;
                break;
            case "L":
                c--;
                break;
            case "R":
                c++;
                break;
        }
        if (r < 0 || r >= height || c < 0 || c >= width || set.contains(r * width + c)) {
            return -1;
        }
        queue.add(r * width + c);
        if (cur < foods.length && r == foods[cur][0] && c == foods[cur][1]) {
            cur++;  
            set.add(queue.peekFirst());
        }
        else {
            queue.pollFirst();
        }
        set.add(r * width + c);
        return queue.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
