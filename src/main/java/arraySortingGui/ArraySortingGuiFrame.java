package arraySortingGui;

import utils.Utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ArraySortingGuiFrame extends JFrame implements ActionListener {

    JPanel inputPanel;
    JPanel sortingPanel;
    JLabel userInputLabel;
    JTextField userArrayInput;
    JButton arraySubmitBtn;
    JButton sortArrayBtn;
    JLabel submissionStatusLabel;
    JComboBox<String> sortingAlgoPicker;
    JLabel sortingStatusLabel;

    double[] resultArray;

    public ArraySortingGuiFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Sorting algorithm example");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.lightGray);
        this.setLayout(new GridLayout(4, 1));

        inputPanel = new JPanel();

        userInputLabel = new JLabel("Input array to sort (comma-separated list):");

        userArrayInput = new JTextField(24);
        userArrayInput.setToolTipText("comma-separated list");

        arraySubmitBtn = new JButton("Submit");
        arraySubmitBtn.addActionListener(this);

        inputPanel.add(userInputLabel);
        inputPanel.add(userArrayInput);
        inputPanel.add(arraySubmitBtn);


        sortingPanel = new JPanel();

        submissionStatusLabel = new JLabel("Submitted array will show up here");

        sortingAlgoPicker = new JComboBox<>();
        sortingAlgoPicker.addItem("quickSort");

        sortArrayBtn = new JButton("Sort");
        sortArrayBtn.addActionListener(this);

        sortingStatusLabel = new JLabel("Result of sorting will be here");

        sortingPanel.add(sortingAlgoPicker);
        sortingPanel.add(sortArrayBtn);


        this.add(inputPanel);
        this.add(submissionStatusLabel);
        this.add(sortingPanel);
        this.add(sortingStatusLabel);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == arraySubmitBtn) {
            String userText = userArrayInput.getText();
            System.out.println("Submitted string: " + userText);
            try {
                resultArray = Utils.parseArrayFromString(userText);
            } catch (NullPointerException exc) {
                submissionStatusLabel.setText("Provided empty string");
                this.pack();
                return;
            } catch (NumberFormatException exc) {
                submissionStatusLabel.setText("Failed to parse your array :(");
                this.pack();
                return;
            }

            submissionStatusLabel.setText(Arrays.toString(resultArray));
            this.pack();
        } else if (e.getSource() == sortArrayBtn) {
            String sortingAlgo = (String) sortingAlgoPicker.getSelectedItem();

            if (sortingAlgo == null) {
                sortingStatusLabel.setText("No sorting algorithm is chosen");
                return;
            }

            if (resultArray == null) {
                sortingStatusLabel.setText("Submit array first!");
                return;
            }

            if (sortingAlgo.equals("quickSort")) {
                Utils.quickSort(resultArray, 0, resultArray.length-1);
                sortingStatusLabel.setText(Arrays.toString(resultArray));
            } else {
                sortingStatusLabel.setText("This sorting algorithm is not implemented :(");
            }
        }
    }
}
