package Übungsblatt5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ColorRunLabel extends JLabel implements Runnable {
    private boolean running = false;
    private Thread thread;

    public ColorRunLabel(Color color) {
        setBackground(color);
        setOpaque(true);
        setFont(new Font("Arial", Font.BOLD, 50));
        setHorizontalAlignment(JLabel.CENTER);
        setText("0");
        setPreferredSize(new Dimension(100, 100));
    }

    public void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            int randomValue = (int)(Math.random() * 10);
            setText(String.valueOf(randomValue));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StartStopButton extends JButton {
    public StartStopButton(Color color) {
        setBackground(color);
        setFont(new Font("Arial", Font.PLAIN, 25));
        setText("START");
        setPreferredSize(new Dimension(100, 50));
    }

    public boolean isStart() {
        return getText().equals("START");
    }

    public void switchText() {
        if (isStart()) {
            setText("STOP");
        } else {
            setText("START");
        }
    }
}

public class Aufgabe17 extends JFrame {
    private ColorRunLabel label1, label2, label3;
    private StartStopButton button1, button2, button3;

    public Aufgabe17() {
        super("Spielautomat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3, 10, 10));

        label1 = new ColorRunLabel(Color.RED);
        label2 = new ColorRunLabel(Color.YELLOW);
        label3 = new ColorRunLabel(Color.GREEN);

        button1 = new StartStopButton(Color.RED);
        button2 = new StartStopButton(Color.YELLOW);
        button3 = new StartStopButton(Color.GREEN);

        button1.addActionListener(new ButtonListener(button1, label1));
        button2.addActionListener(new ButtonListener(button2, label2));
        button3.addActionListener(new ButtonListener(button3, label3));

        add(label1);
        add(label2);
        add(label3);
        add(button1);
        add(button2);
        add(button3);

        setSize(350, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        private StartStopButton button;
        private ColorRunLabel label;

        public ButtonListener(StartStopButton button, ColorRunLabel label) {
            this.button = button;
            this.label = label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (button.isStart()) {
                label.start();
            } else {
                label.stop();
            }
            button.switchText();
        }
    }

}