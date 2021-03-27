package model;

import java.util.ArrayList;

public class ProgramLaunchConverter {

    /**
     * Takes the file path as a string and converts it to an ArrayList<Integer>. the first entry is always 10000, this is to identify it has a launch program hotkey.
     * @param s a string that represents the absolute path to the exe you wish to bind.
     * @return and ArrayList<Integer> of actions.
     */
    public static ArrayList<Integer> StringToInt(String s){
        ArrayList<Integer> actionList = new ArrayList<>();
        // Identifying keycode used to check during preform action if it's a launch program type.
        actionList.add(10000);

        try {
            byte[] bytes = s.getBytes("US-ASCII");
            //System.out.println(Arrays.toString(bytes));

            for(int i = 0; i< bytes.length; i = i +1){
                int p = bytes[i];
                //System.out.println(p);
                actionList.add(p);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return actionList;
    }
}
