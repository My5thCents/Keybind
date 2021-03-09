package model;

public class MediaKeys extends Hotkey implements InputEmulator{

    // constant for testing

    // Play/Pause Media Key: 0xB2
    private static int play = Integer.decode("0xB2");
    // Mute Media Key: 0xAD
    private static int mute = Integer.decode("0xAD");
    // Next Media Key: 0xB0
    private static int next = Integer.decode("0xB0");
    // Prev Media Key: 0xB1
    private static int prev = Integer.decode("0xB1");


    /**
     * Constructs a hotkey
     * @param keyCode Virtual keycode
     * @param id id of hotkey
     * @param modifier modifer for keycode
     */
    public MediaKeys (int keyCode, int id, int modifier){
        super(keyCode, id , modifier);
    }



    @Override
    public void sendKey(int keyCode, boolean release){

        if(keyCode == play){
            System.out.println("sending Play keycode" + keyCode);
        }
        else if (keyCode == mute){
            System.out.println("sending mute keycode" + keyCode);
        }
        else if (keyCode == next){
            System.out.println("sending next keycode" + keyCode);
        }
        else if (keyCode == prev){
            System.out.println("sending prev keycode" + keyCode);
        }
    }

    public static void main(String[] args){

        System.out.println("TestCases");

        // with not valid keycode
        MediaKeys test0 = new MediaKeys(0, 0, 0);
        test0.sendKey(test0.getKeyCode(), false);

        // with valid Keycode
        MediaKeys test1 = new MediaKeys(178, 0, 0);
        test1.sendKey(test1.getKeyCode(), false);


    }

}