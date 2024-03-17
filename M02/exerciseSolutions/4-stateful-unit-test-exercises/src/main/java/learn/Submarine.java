package learn;

/**
 * An underwater, submersible vehicle.
 * Includes two behaviors.
 * dive: go down a little deeper under water to a maximum depth
 * surface: come up a little shallower to a minimum depth of sea level
 * <p>
 * The submarine's current depth and pressure are available via getters.
 */
public class Submarine {

    private final double maxDepth;
    private double depthInMeters;

    public Submarine(double maxDepth) {
        this.maxDepth = maxDepth;
    }

    public double getDepthInMeters() {
        return depthInMeters;
    }

    public void dive() {
        // 1. Each dive should increase the depth by 3 meters.
        // Depth cannot exceed maxDepth.
        if(depthInMeters + 3 <= maxDepth){
            depthInMeters += 3;
        }else{
            depthInMeters += 0;
            System.out.println("Can't exceed " + maxDepth + " meters");
        }
    }

    public void surface() {
        // 2. Each surface should decrease the depth by 5 meters.
        // Minimum depth is 0.0 (sea level).
        if(depthInMeters - 5 >= 0){
            depthInMeters -= 5;
        }else{
            depthInMeters -= 0;
            System.out.println("Can't go above 0 meters");
        }
    }

    public double getPressureInAtmospheres() {
        // 3. At sea level, pressure is 1 atmosphere.
        // Pressure increases by 1 atmosphere for every 10 meters.
        return depthInMeters / 10 + 1;
    }

}
