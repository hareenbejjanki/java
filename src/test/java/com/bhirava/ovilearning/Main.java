package com.bhirava.ovilearning;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
    public static void main(String[] argv) throws Exception {
        JTextArea textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        JFrame frame = new JFrame();
        frame.add(pane);
        frame.setVisible(true);

        // Listen for value changes in the scroll pane's scrollbars
        AdjustmentListener listener = new MyAdjustmentListener();
        pane.getHorizontalScrollBar().addAdjustmentListener(listener);
        pane.getVerticalScrollBar().addAdjustmentListener(listener);
    }
}

class MyAdjustmentListener implements AdjustmentListener {
    public void adjustmentValueChanged(AdjustmentEvent evt) {
        Adjustable source = evt.getAdjustable();
        if (evt.getValueIsAdjusting()) {
            return;
        }
        int orient = source.getOrientation();
        if (orient == Adjustable.HORIZONTAL) {
            System.out.println("from horizontal scrollbar");
        } else {
            System.out.println("from vertical scrollbar");
        }
        int type = evt.getAdjustmentType();
        switch (type) {
            case AdjustmentEvent.UNIT_INCREMENT:
                System.out.println("Scrollbar was increased by one unit");
                break;
            case AdjustmentEvent.UNIT_DECREMENT:
                System.out.println("Scrollbar was decreased by one unit");
                break;
            case AdjustmentEvent.BLOCK_INCREMENT:
                System.out.println("Scrollbar was increased by one block");
                break;
            case AdjustmentEvent.BLOCK_DECREMENT:
                System.out.println("Scrollbar was decreased by one block");
                break;
            case AdjustmentEvent.TRACK:
                System.out.println("The knob on the scrollbar was dragged");
                break;
        }
        int value = evt.getValue();
        System.out.println("The knob value " + value);
    }
}
