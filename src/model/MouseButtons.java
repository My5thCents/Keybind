package model;

public interface MouseButtons {
    int LEFTDOWN = 0x0002;
    int LEFTUP = 0x0004;
    int RIGHTDOWN = 0x0008;
    int RIGHTUP = 0x0010;
    int MIDDLEDOWN = 0x0020;
    int MIDDLEUP = 0x0040;
    int XDOWN = 0x0080;
    int XUP = 0x0100;
    int XBUTTON1 = 0x0001;
    int XBUTTON2 = 0x0002;

    static int getDown(int id) {
        if (id < 1 || id > 6 || id == 3)
            return -1;

        switch (id) {
            case 1:
                return LEFTDOWN;
            case 2:
                return RIGHTDOWN;
            case 4:
                return MIDDLEDOWN;
            case 5:
            case 6:
                return XDOWN;
            default:
                throw new IllegalStateException("Impossible case reached.");
        }
    }

    static int getUp(int id) {
        if (id < 1 || id > 6 || id == 3)
            return -1;

        switch (id) {
            case 1:
                return LEFTUP;
            case 2:
                return RIGHTUP;
            case 4:
                return MIDDLEUP;
            case 5:
            case 6:
                return XUP;
            default:
                throw new IllegalStateException("Impossible case reached.");
        }
    }

    static int getXButton(int id) {
        if (id == 5) {
            return XBUTTON1;
        }
        else if (id == 6) {
            return XBUTTON2;
        }
        else {
            return -1;
        }
    }
}
