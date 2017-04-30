package iics.ust.com.usturista;

import java.io.Serializable;

/**
 * Created by Marvin on 29/04/2017.
 */

public class ProgressTracker implements Serializable {
    public static double progress= 0.00;

    public static boolean albertus= false, chapel= false, arch= false,
    library=false, garden=false, park=false;

    public ProgressTracker() {
    }

    public static double getProgress() {
        return progress;
    }

    public static void setProgress(double progress) {
        ProgressTracker.progress = progress;
    }

    public static boolean isAlbertus() {
        return albertus;
    }

    public static void setAlbertus(boolean albertus) {
        ProgressTracker.albertus = albertus;
    }

    public static boolean isChapel() {
        return chapel;
    }

    public static void setChapel(boolean chapel) {
        ProgressTracker.chapel = chapel;
    }

    public static boolean isArch() {
        return arch;
    }

    public static void setArch(boolean arch) {
        ProgressTracker.arch = arch;
    }

    public static boolean isLibrary() {
        return library;
    }

    public static void setLibrary(boolean library) {
        ProgressTracker.library = library;
    }

    public static boolean isGarden() {
        return garden;
    }

    public static void setGarden(boolean garden) {
        ProgressTracker.garden = garden;
    }

    public static boolean isPark() {
        return park;
    }

    public static void setPark(boolean park) {
        ProgressTracker.park = park;
    }

    public void changeStatus(String place){
        switch(place){
            case "Albertus Magnus":
                if(albertus == false){
                    progress = progress + 16.7;
                    albertus = true;
                }
                break;
            case "UST Chapel":
                if(chapel == false){
                    progress = progress + 16.7;
                    chapel = true;
                }
                break;
            case "Arch of the Centuries":
                if(arch == false){
                    progress = progress + 16.7;
                    arch = true;
                }
                break;
             case "Miguel de Benavides Library":
                 if(library == false){
                     progress = progress + 16.7;
                     library = true;
                 }
                break;
            case "Botanical Garden":
                if(garden == false){
                    progress = progress + 16.7;
                    garden = true;
                }
                break;
            case "Quadricentennial Park Fountain":
                if(park == false){
                    progress = progress + 16.5;
                    park = true;
                }
                break;
        }
    }

}
