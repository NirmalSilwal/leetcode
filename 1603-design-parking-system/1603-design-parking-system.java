class ParkingSystem {

    int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[3];
        spaces[0] = big;
        spaces[1] = medium;
        spaces[2] = small;
    }
    
    // carType can be of 3 kinds: big, medium, or small, which are represented by 1, 2, and 3
    public boolean addCar(int carType) {
        if (carType == 1) { // big space required
            if (spaces[0] > 0) {
                spaces[0]--;
                return true;
            }
        } else if (carType == 2) { // medium
            if (spaces[1] > 0) {
                spaces[1]--;
                return true;
            }
        } else {
            if (spaces[2] > 0) { // small
                spaces[2]--;
                return true;
            }
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

 /*
big - 1 -> 0
medium - 1 -> 0
small - 0
 */