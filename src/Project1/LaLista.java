package Project1;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class LaLista extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> finalList = new DefaultListModel<>();  		
	private JList<String> list = new JList<String>(finalList);
	private DefaultListModel<Food> l1 = new DefaultListModel<>();  
	private ArrayList<Food> carnes = new ArrayList<>();
	private ArrayList<Food> dairy = new ArrayList<>();
	private ArrayList<Food> crops = new ArrayList<>();
	private ArrayList<Food> bebidas = new ArrayList<>();
	private ArrayList<Food> spices = new ArrayList<>();
	private ArrayList<Food> bread = new ArrayList<>();
	private ArrayList<Food> pasta = new ArrayList<>();
	private ArrayList<Food> sauces = new ArrayList<>();
	private ArrayList<Food> misc = new ArrayList<>();
	private ArrayList<Food> general = new ArrayList<>();
	private ArrayList<Food> addLater = new ArrayList<>();
	private JList<Food> textArea = new JList<Food>(l1); 
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	private JComboBox comboBox_1 = new JComboBox();
	private ArrayList<Food>  finalListObject = new ArrayList<>();
	private final JButton otherButton = new JButton("Otro\r\n");
	private JTextField otherText;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JButton load = new JButton("Bajar");
	
	//launcher
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaLista frame = new LaLista();
					frame.setVisible(true);
					frame.setTitle("LaLista");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void dataStructures()
	{
		try
		{
			Scanner in = new Scanner(new File("Carnes.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				carnes.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Dairy.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				dairy.add(y);
				general.add(y);
			}
			in = new Scanner(new File("FrutasyVerduras.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				crops.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Spices.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				spices.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Bread.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				bread.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Pasta.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				pasta.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Sauces.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				sauces.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Misc.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				misc.add(y);
				general.add(y);
			}
			in = new Scanner(new File("Bebidas.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				bebidas.add(y);
				general.add(y);
			}
			in = new Scanner(new File("AddMe.txt"));
			while(in.hasNextLine())
			{
				String x[] = in.nextLine().split("~"); //name and date
				Food y = new Food(x[0].trim(), x[1].trim());
				addLater.add(y);
				general.add(y);
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
	}

	//Main Function
	public LaLista() {
		//Read text documents (Categories of foods) and create lists for each one
		dataStructures();
		
		//Frame details
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 1034, 884);
		
		//General panel details
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ComboBox of categories details and actionListener to change list object being shown
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBackground(new Color(255, 250, 250));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Carnes"))
				{
					l1.clear();
					for (Food x : carnes)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Dairy"))
				{
					l1.clear();
					for (Food x : dairy)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Frutas y Verduras"))
				{
					l1.clear();
					for (Food x : crops)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Bebidas"))
				{
					l1.clear();
					for (Food x : bebidas)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Misc"))
				{
					l1.clear();
					for (Food x : misc)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Especies"))
				{
					l1.clear();
					for (Food x : spices)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Pan"))
				{
					l1.clear();
					for (Food x : bread)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Pasta"))
				{
					l1.clear();
					for (Food x : pasta)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("Salsa"))
				{
					l1.clear();
					for (Food x : sauces)
					{
						l1.addElement(x);
					}
				}
				if (comboBox.getSelectedItem().equals("1 Semana"))
				{
					l1.clear();
					for (Food x : general)
					{
						if (x.differ(new SimpleDateFormat("dd/MM/yyyy").format(new Date())) > 6){
							l1.addElement(x);
						}
					}
				}
				if (comboBox.getSelectedItem().equals("2 Semanas"))
				{
					l1.clear();
					for (Food x : general)
					{
						if (x.differ(new SimpleDateFormat("dd/MM/yyyy").format(new Date())) > 13){
							l1.addElement(x);
						}
					}
				}
			}
		});
		comboBox.setBounds(682, 64, 209, 41);
		comboBox.addItem("Carnes");
		comboBox.addItem("Frutas y Verduras");
		comboBox.addItem("Dairy");
		comboBox.addItem("Bebidas");
		comboBox.addItem("Especies");
		comboBox.addItem("Pan");
		comboBox.addItem("Pasta");
		comboBox.addItem("Salsa");
		comboBox.addItem("Misc");
		comboBox.addItem("1 Semana");
		comboBox.addItem("2 Semanas");
		contentPane.add(comboBox);
		scrollPane_1.setBounds(582, 127, 407, 611);
		
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(textArea);
		
		//Details for jlist textArea along with mouseListener to add object to finalList
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!finalListObject.contains(textArea.getSelectedValue()))
				{
					finalListObject.add(textArea.getSelectedValue());
					finalList.addElement(textField.getText()+ " " + comboBox_1.getSelectedItem()+ " de " + textArea.getSelectedValue());
				}
			}
		});
		
		
		//Big Label
		JLabel lblNewLabel = new JLabel("La Lista");
		lblNewLabel.setBounds(22, 11, 303, 71);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 70));
		comboBox_1.setBackground(new Color(255, 250, 250));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//ComboBox_1 details
		comboBox_1.setBounds(489, 297, 83, 41);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("lb(s)");
		comboBox_1.addItem("$");
		comboBox_1.addItem("kg(s)");
		comboBox_1.addItem("lata(s)");
		
		//TextField for amount details
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(461, 245, 111, 41);
		textField.setText("1");
		contentPane.add(textField);
		textField.setColumns(10);
		
		//ScrollPane details for jlist list
		scrollPane.setBounds(37, 217, 418, 583);		
		contentPane.add(scrollPane);
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(list);		
		JLabel lblNewLabel_1 = new JLabel("Lista Final");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 25));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		//Save button which writes final List to a new text and updates the dates of last time produce was bought
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			        FileWriter myWriter = new FileWriter("FinalList.txt");
			        int count = 0;
			        for (Food x : finalListObject) {
			        	myWriter.write(finalList.get(count) + "\n");
			        	count++;
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Carnes.txt");
			        for (int a = 0; a < carnes.size(); a++)
			        {
			        	if (finalListObject.contains(carnes.get(a)))
			        	{
		        			carnes.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));			        		
			        	}
			        	myWriter.write(carnes.get(a).getName() + " ~ " + carnes.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Dairy.txt");
			        for (int a = 0; a < dairy.size(); a++)
			        {
			        	if (finalListObject.contains(dairy.get(a)))
			        	{
			        		dairy.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(dairy.get(a).getName() + " ~ " + dairy.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("FrutasyVerduras.txt");
			        for (int a = 0; a < crops.size(); a++)
			        {
			        	if (finalListObject.contains(crops.get(a)))
			        	{
			        		crops.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(crops.get(a).getName() + " ~ " + crops.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Bebidas.txt");
			        for (int a = 0; a < bebidas.size(); a++)
			        {
			        	if (finalListObject.contains(bebidas.get(a)))
			        	{
			        		bebidas.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(bebidas.get(a).getName() + " ~ " + bebidas.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Spices.txt");
			        for (int a = 0; a < spices.size(); a++)
			        {
			        	if (finalListObject.contains(spices.get(a)))
			        	{
			        		spices.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(spices.get(a).getName() + " ~ " + spices.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Bread.txt");
			        for (int a = 0; a < bread.size(); a++)
			        {
			        	if (finalListObject.contains(bread.get(a)))
			        	{
			        		bread.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(bread.get(a).getName() + " ~ " + bread.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Pasta.txt");
			        for (int a = 0; a < pasta.size(); a++)
			        {
			        	if (finalListObject.contains(pasta.get(a)))
			        	{
			        		pasta.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(pasta.get(a).getName() + " ~ " + pasta.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Sauces.txt");
			        for (int a = 0; a < sauces.size(); a++)
			        {
			        	if (finalListObject.contains(sauces.get(a)))
			        	{
			        		sauces.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(sauces.get(a).getName() + " ~ " + sauces.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("Misc.txt");
			        for (int a = 0; a < misc.size(); a++)
			        {
			        	if (finalListObject.contains(misc.get(a)))
			        	{
			        		misc.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(misc.get(a).getName() + " ~ " + misc.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        myWriter = new FileWriter("AddMe.txt");
			        for (int a = 0; a < addLater.size(); a++)
			        {
			        	if (finalListObject.contains(addLater.get(a)))
			        	{
			        		addLater.get(a).updateDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			           	}
			        	myWriter.write(addLater.get(a).getName() + " ~ " + addLater.get(a).getDate() + "\n");
			        }
			        myWriter.close();
			        System.out.println("Successfully wrote to the file.");
					Process p = Runtime.getRuntime().exec("python src/Project1/emailAttempt.py");
			        System.out.println("Successfully sent the file.");
			        
			      } 
			    catch (IOException x) {
			        System.out.println("An error occurred.");
			        x.printStackTrace();
			      }
			}
		});
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
		btnNewButton.setBounds(22, 131, 185, 49);
		contentPane.add(btnNewButton);
		
		//Other button which processes otherText to go to the final list
		otherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!otherText.getText().isBlank() && !finalListObject.contains(new Food(otherText.getText().trim(), "")))
				{
					addLater.add(new Food(otherText.getText(), new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
					finalListObject.add(new Food(otherText.getText(), new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
					finalList.addElement(textField.getText() + comboBox_1.getSelectedItem() + " de " + otherText.getText());
				}
			}
		});
		otherButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		otherButton.setBounds(877, 759, 97, 41);
		contentPane.add(otherButton);
		
		//TextField in case a produce is not in the general catalog
		otherText = new JTextField();
		otherText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		otherText.setBounds(592, 765, 275, 35);
		contentPane.add(otherText);
		otherText.setColumns(10);
		
		JButton save = new JButton("Guardar");
		save.setBackground(new Color(255, 250, 250));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        FileWriter myWriter = new FileWriter("FinalList.txt");
			        int count = 0;
			        for (Food x : finalListObject) {
			        	myWriter.write(x.getName() + " ~  " + x.getDate() + "\n");
			        	count++;
			        }
			        myWriter.close();
				}
				catch(IOException x) {
			        System.out.println("An error occurred.");
			        x.printStackTrace();
				}
			}
		});
		save.setFont(new Font("Tahoma", Font.PLAIN, 39));
		save.setBounds(217, 131, 177, 49);
		contentPane.add(save);
		load.setBackground(new Color(255, 250, 250));
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					Scanner in = new Scanner(new File("FinalList.txt"));
				int count = 0;
				while(in.hasNextLine())
				{
					
					String a[] = in.nextLine().split("de "); //name and date
					String x[] = a[1].split("~");
					Food y = new Food(x[0].trim(), "1/1/2021");
					finalListObject.add(y);
					finalList.add(count, a[0] + "de " + x[0]);
					count++;
				}
				}
				catch(IOException x) {
			        System.out.println("An error occurred.");
			        x.printStackTrace();
				}
			}
		});
		load.setFont(new Font("Tahoma", Font.PLAIN, 39));
		load.setBounds(414, 131, 141, 49);
		
		contentPane.add(load);
		
		//Remove selected item in finalList (Left side)
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Erased: " + list.getSelectedValue());
				finalListObject.remove(list.getSelectedIndex());
				finalList.removeElement(list.getSelectedValue());
			}
		});
	}
}


