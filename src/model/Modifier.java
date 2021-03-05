package model;

public enum Modifier {
    NONE(0x0000),
    ALT(0x0001),
    CTRL(0x0002),
    /** Prevents key holding triggering multiple hotkey messages. */
    NOREPEAT(0x4000),
    SHIFT(0x0004),
    WIN(0x0008);

    private final int val;

    Modifier(int val) {
        this.val = val;
    }

    /**
     * Returns the Modifier integer value.
     */
    public int val() {
        return val;
    }

    /**
     * Outputs the combined values of two different given modifiers.
     *
     * @return The combined values of the given modifiers.
     * 0 if there are duplicate modifiers.
     */
    public int combine(Modifier m1, Modifier m2) {
        if (m1 == m2)
            return 0;
        else
            return m1.val() + m2.val();
    }

    /**
     * Outputs the combined values of the three different given modifiers.
     * @return The combined values of the given modifiers.
     *         0 if there are duplicate modifiers.
     */
    public int combine(Modifier m1, Modifier m2, Modifier m3) {
        if (m1 == m2 || m1 == m3 || m2 == m3)
            return 0;
        else
            return m1.val() + m2.val() + m3.val();
    }

    /**
     * Outputs the combined values of the four different given modifiers.
     * @return The combined values of the given modifiers.
     *         0 if there are duplicate modifiers.
     */
    public int combine(Modifier m1, Modifier m2, Modifier m3, Modifier m4) {
        if (m1 == m2 || m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4 || m3 == m4)
            return 0;
        else
            return m1.val() + m2.val() + m3.val() + m4.val();
    }

    /**
     * Outputs the combined values of the five different given modifiers.
     * @return The combined values of the given modifiers.
     *         0 if there are duplicate modifiers.
     */
    public int combine(Modifier m1, Modifier m2, Modifier m3, Modifier m4, Modifier m5) {
        if (m1 == m2 || m1 == m3 || m1 == m4 || m1 == m5 || m2 == m3 || m2 == m4 ||
                m2 == m5 || m3 == m4 || m4 == m5)
            return 0;
        else
            return m1.val() + m2.val() + m3.val() + m4.val() + m4.val();
    }
}
