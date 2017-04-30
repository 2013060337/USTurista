package iics.ust.com.usturista;

/**
 * Created by Marvin on 26/04/2017.
 */

public class LandmarkBaseAdapter {

    public int landmark_image;
    public String landmark_name;

    public LandmarkBaseAdapter(int landmark_image, String landmark_name) {
        this.landmark_image = landmark_image;
        this.landmark_name = landmark_name;
    }
}
