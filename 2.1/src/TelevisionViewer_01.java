// 2.1 - Task 01

public class TelevisionViewer_01 {
    public static void main(String[] args) {
        Television myTV = new Television();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0) {
                    tired = true;
                }
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}

class Television {
    private int channel;
    private boolean isOn;

    public Television() {
        this.channel = 1;
        this.isOn = false;
    }

    public void setChannel(int channel) {
        if (channel > 10) {
            channel = 1;
        }
        this.channel = channel;
    }

    public boolean isOn() {
        return isOn;
    }

    public void pressOnOff() {
        isOn = !isOn;
    }

    public int getChannel() {
        return channel;
    }
}
