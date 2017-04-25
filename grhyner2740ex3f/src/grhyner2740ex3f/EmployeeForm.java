package grhyner2740ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField postionTextField;
	private JList employeeList;
	private DefaultListModel employeeListModel;
	private JComboBox deptComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("GRhyner Ex2F: Overloaded Constructors ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 141);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel(); // added manually
		//employeeList = new JList();
		employeeList = new JList(employeeListModel);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(20, 166, 94, 14);
		contentPane.add(lblEmployeeId);
		
		empIdTextField = new JTextField();
		lblEmployeeId.setLabelFor(empIdTextField);
		empIdTextField.setText("101");
		empIdTextField.setBounds(124, 163, 64, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(20, 191, 107, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(20, 216, 93, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(20, 241, 93, 14);
		contentPane.add(lblPosition);
		
		empNameTextField = new JTextField();
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setText("Gage Rhyner");
		empNameTextField.setColumns(10);
		empNameTextField.setBounds(124, 188, 107, 20);
		contentPane.add(empNameTextField);
		
		postionTextField = new JTextField();
		lblPosition.setLabelFor(postionTextField);
		postionTextField.setText("Programmer");
		postionTextField.setColumns(10);
		postionTextField.setBounds(124, 238, 107, 20);
		contentPane.add(postionTextField);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(124, 213, 156, 20);
		contentPane.add(deptComboBox);
		
		JButton noArgConstructorButton = new JButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(89, 274, 89, 23);
		contentPane.add(noArgConstructorButton);
		
		JButton twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(188, 274, 89, 23);
		contentPane.add(twoArgConstructorButton);
		
		JButton fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(290, 274, 89, 23);
		contentPane.add(fourArgConstructorButton);
	}
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		Employee emp = new Employee();
		employeeListModel.addElement(emp);
	}
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(empIdTextField.getText());
		Employee emp = new Employee(id, empNameTextField.getText());
		employeeListModel.addElement(emp);
	}
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(empIdTextField.getText());
		String dept = (String)deptComboBox.getSelectedItem();
		Employee emp = new Employee(id, empNameTextField.getText(), dept, postionTextField.getText());
		employeeListModel.addElement(emp);
	}
}
