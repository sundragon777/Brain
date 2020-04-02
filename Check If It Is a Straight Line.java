class Solution {
    private int MIN = 2;
    
        public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= MIN) return true;
        
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        
        double value = ((double)(y2 - y1)) / ((double)(x2 - x1));
        
        for(int i = MIN; i < coordinates.length; i++) {
            x2 = coordinates[i][0];
            y2 = coordinates[i][1];
            double curr = ((double)(y2 - y1)) / ((double)(x2 - x1));
            
            if(value != curr) return false;
        }
        
        return true;
    }
}
