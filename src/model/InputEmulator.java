package model;

public interface InputEmulator {
    /**
     * Sends a given key to be emulated.
     * @param keyCode The virtual keycode of the key.
     * @param release True if the key is to be a key release input.
     */
    void sendKey(int keyCode, boolean release);
}
