package src.Payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

public class PayrollAdd extends JInternalFrame implements ActionListener {
    private JLabel titleLabel, staffIDLabel, monthLabel, yearLabel, totalAllowanceLabel,
				   totalOvertimePayLabel, totalEPFLabel, totalSOCSOLabel;
	private JTextField staffIDField;
	private JFormattedTextField totalAllowanceField, totalOvertimePayField,
                                totalEPFField, totalSOCSOField;
	private JComboBox<String> monthComboBox;
	private JSpinner yearSpinner;
	private JButton createPayrollButton;

    public PayrollAdd() {
        setClosable(false);
        setSize(825, 535);
        setMinimumSize(new Dimension(825, 535));
        setMaximumSize(new Dimension(825, 535));
        setLocation(175, 85);        
        getContentPane().setLayout(null);
        setFrameIcon(null);

        titleLabel = new JLabel();
		staffIDLabel = new JLabel();
		staffIDField = new JTextField();
		monthLabel = new JLabel();
		monthComboBox = new JComboBox<>();
		yearLabel = new JLabel();
		yearSpinner = new JSpinner();
		totalAllowanceLabel = new JLabel();
		totalAllowanceField = new JFormattedTextField();
		totalOvertimePayLabel = new JLabel();
		totalOvertimePayField = new JFormattedTextField();
		totalEPFLabel = new JLabel();
		totalEPFField = new JFormattedTextField();
		totalSOCSOLabel = new JLabel();
		totalSOCSOField = new JFormattedTextField();
		createPayrollButton = new JButton();
        
        titleLabel.setText("Add Staff Payroll");
		titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | Font.BOLD, titleLabel.getFont().getSize() + 20f));
		titleLabel.setBounds(110, 30, 265, titleLabel.getPreferredSize().height);
		getContentPane().add(titleLabel);

		staffIDLabel.setText("Staff ID : ");
		staffIDLabel.setFont(staffIDLabel.getFont().deriveFont(staffIDLabel.getFont().getSize() + 5f));
		staffIDLabel.setBounds(110, 120, 100, 30);
		getContentPane().add(staffIDLabel);

		staffIDField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		staffIDField.setBounds(110, 150, 105, 30);
		getContentPane().add(staffIDField);

		monthLabel.setText("Month : ");
		monthLabel.setFont(monthLabel.getFont().deriveFont(monthLabel.getFont().getSize() + 5f));
		monthLabel.setBounds(355, 120, 100, 30);
		getContentPane().add(monthLabel);

		monthComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		monthComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		}));
		monthComboBox.setBounds(355, 150, 115, 30);
		getContentPane().add(monthComboBox);

		yearLabel.setText("Year : ");
		yearLabel.setFont(yearLabel.getFont().deriveFont(yearLabel.getFont().getSize() + 5f));
		yearLabel.setBounds(480, 120, 65, 30);
		getContentPane().add(yearLabel);

		yearSpinner.setModel(new SpinnerNumberModel(2024, 1924, 2124, 1));
		yearSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		yearSpinner.setBounds(480, 150, 85, 30);
		getContentPane().add(yearSpinner);

		totalAllowanceLabel.setText("Allowance : ");
		totalAllowanceLabel.setFont(totalAllowanceLabel.getFont().deriveFont(totalAllowanceLabel.getFont().getSize() + 5f));
		totalAllowanceLabel.setBounds(110, 225, 100, 30);
		getContentPane().add(totalAllowanceLabel);

		totalAllowanceField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalAllowanceField.setBounds(110, 255, 210, 30);
		getContentPane().add(totalAllowanceField);

		totalOvertimePayLabel.setText("Overtime : ");
		totalOvertimePayLabel.setFont(totalOvertimePayLabel.getFont().deriveFont(totalOvertimePayLabel.getFont().getSize() + 5f));
		totalOvertimePayLabel.setBounds(110, 300, 100, 30);
		getContentPane().add(totalOvertimePayLabel);

		totalOvertimePayField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalOvertimePayField.setBounds(110, 330, 210, 30);
		getContentPane().add(totalOvertimePayField);

		totalEPFLabel.setText("EPF : ");
		totalEPFLabel.setFont(totalEPFLabel.getFont().deriveFont(totalEPFLabel.getFont().getSize() + 5f));
		totalEPFLabel.setBounds(355, 225, 90, 30);
		getContentPane().add(totalEPFLabel);

		totalEPFField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalEPFField.setBounds(355, 255, 210, 30);
		getContentPane().add(totalEPFField);

		totalSOCSOLabel.setText("SOCSO : ");
		totalSOCSOLabel.setFont(totalSOCSOLabel.getFont().deriveFont(totalSOCSOLabel.getFont().getSize() + 5f));
		totalSOCSOLabel.setBounds(355, 300, 110, 30);
		getContentPane().add(totalSOCSOLabel);

		totalSOCSOField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		totalSOCSOField.setBounds(355, 330, 210, 30);
		getContentPane().add(totalSOCSOField);

		createPayrollButton.setText("Add Payroll");
		createPayrollButton.setBackground(new Color(0x00db00));
		createPayrollButton.setForeground(Color.white);
		createPayrollButton.setFont(createPayrollButton.getFont().deriveFont(createPayrollButton.getFont().getStyle() | Font.BOLD, createPayrollButton.getFont().getSize() + 5f));
		createPayrollButton.addActionListener(this);
		createPayrollButton.setBounds(435, 435, 130, createPayrollButton.getPreferredSize().height);
		getContentPane().add(createPayrollButton);

        setVisible(true);
    }

    private JFormattedTextField createDoubleNumTextField() {
        NumberFormat format = new DecimalFormat("#0.00");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(1000000.0);

        JFormattedTextField textField = new JFormattedTextField(formatter);
        textField.setColumns(10);

        return textField;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Payroll")){
            double allowance = Double.parseDouble(totalAllowanceField.getText());
            double overtimePay = Double.parseDouble(totalOvertimePayField.getText());
            double EPF = Double.parseDouble(totalEPFField.getText());
            double SOCSO = Double.parseDouble(totalSOCSOField.getText());

            if(Payroll.addPayroll(staffIDField.getText(), allowance, overtimePay, EPF, SOCSO)){
                JOptionPane.showMessageDialog(null, "Payslip Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Staff ID does not exist in system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
