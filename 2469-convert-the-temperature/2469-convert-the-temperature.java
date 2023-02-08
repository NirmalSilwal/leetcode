class Solution {
    public double[] convertTemperature1(double celsius) {
        
        double[] ans = new double[2];

        ans[0] = celsius + 273.15; // kelvin
        ans[1] = celsius * 1.80 + 32.00; // farenheight

        return ans;
    }
    
    public double[] convertTemperature(double celsius) {
        
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};   
    }
    
}