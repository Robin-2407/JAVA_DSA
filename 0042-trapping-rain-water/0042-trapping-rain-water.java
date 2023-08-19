class Solution {
    public int trap(int[] height) {
        //calculate the leftMax of array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int trappedRainWater = 0;
        for(int i=0; i<height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedRainWater += waterLevel - height[i];
        }
        return trappedRainWater;
    }
}