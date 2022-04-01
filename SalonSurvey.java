import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class SalonSurvey extends JFrame implements ActionListener {
  
  private JLabel customerID, firstname, lastname, gender, birthday, yearLabel, serviceLabel, rateLabel, 
                 verypoorLabel, poorImageLabel, averageLabel, goodLabel, excellentLabel, comment;
  private JPanel northPanel, westPanel, westPanel1, southPanel, eastPanel;
  private JTextField cusIDTextField, firstnameTextField, lastnameTextField, yearTextField;
  private JRadioButton male, female, transgender, noAnswer, verypoor, poor, average, good, excellent;
  private JComboBox monthBox, dayBox;
  private JCheckBox wash, cut, color, bleach, highlight, curl, blowdry, treatment, straight, volumn, style;
  private ImageIcon verypoorImage, poorImage, averageImage, goodImage, excellentImage;
  private JButton submit, cancel;
  private ButtonGroup genderGroup, rateGroup;
  private JTextArea commentBox;
  
  public SalonSurvey() {
    super("Hair Salon Survey");
    
    customerID = new JLabel("Customer No.: ");
    cusIDTextField = new JTextField(15);
    firstname = new JLabel("First Name: ");
    firstnameTextField = new JTextField(15);
    lastname = new JLabel("Last Name: ");
    lastnameTextField = new JTextField(15);
    northPanel = new JPanel();
    northPanel.setBackground(Color.PINK);
    JPanel infoPanel = new JPanel();
    infoPanel.add(customerID);
    infoPanel.add(cusIDTextField);
    infoPanel.add(firstname);
    infoPanel.add(firstnameTextField);
    infoPanel.add(lastname);
    infoPanel.add(lastnameTextField);
    infoPanel.setBackground(Color.PINK);
    northPanel.add(infoPanel);
    add(northPanel, BorderLayout.NORTH);
    
    gender = new JLabel("Gender: ");
    male = new JRadioButton("Male");
    female = new JRadioButton("Female");
    transgender = new JRadioButton("Transgender");
    noAnswer = new JRadioButton("Prefer Not To Answer");
    genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
    genderGroup.add(transgender);
    genderGroup.add(noAnswer);
    westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(0,1));
    JPanel genderPanel = new JPanel();
    genderPanel.add(gender);
    genderPanel.add(male);
    genderPanel.add(female);
    genderPanel.add(transgender);
    genderPanel.add(noAnswer);
    westPanel.add(genderPanel);
    
    birthday = new JLabel("Date of Birth");
    String monthList [] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
      "October", "November", "December"};
    monthBox = new JComboBox(monthList);
    String dayList [] = {"1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
      "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    dayBox = new JComboBox(dayList);
    yearTextField = new JTextField(4);
    JPanel birthPanel = new JPanel();
    birthPanel.add(birthday);
    birthPanel.add(monthBox);
    birthPanel.add(dayBox);
    birthPanel.add(yearTextField);
    westPanel.add(birthPanel);
    
    serviceLabel = new JLabel("Which service(s) did you have with us: ");
    wash = new JCheckBox("Hair Wash");
    cut = new JCheckBox("Hair Cut");
    color = new JCheckBox("Coloring");
    bleach = new JCheckBox("Bleaching");
    highlight = new JCheckBox("Highlight");
    curl = new JCheckBox("Curling");
    blowdry = new JCheckBox("Blow-dry");
    treatment = new JCheckBox("Treatment");
    straight = new JCheckBox("Straightening");
    volumn = new JCheckBox("Volumn");
    style = new JCheckBox("Styling");
    westPanel.add(serviceLabel);
    JPanel servicePanel = new JPanel();
    servicePanel.setLayout(new GridLayout(4,3));
    servicePanel.add(wash);
    servicePanel.add(cut);
    servicePanel.add(color);
    servicePanel.add(bleach);
    servicePanel.add(highlight);
    servicePanel.add(curl);
    servicePanel.add(blowdry);
    servicePanel.add(treatment);
    servicePanel.add(straight);
    servicePanel.add(volumn);
    servicePanel.add(style);
    westPanel.add(servicePanel);
    add(westPanel, BorderLayout.WEST);
    
    rateLabel = new JLabel("Rate Our Service: ");
    verypoor = new JRadioButton("");
    poor = new JRadioButton("");
    average = new JRadioButton("");
    good = new JRadioButton("");
    excellent = new JRadioButton("");
    rateGroup = new ButtonGroup();
    rateGroup.add(verypoor);
    rateGroup.add(poor);
    rateGroup.add(average);
    rateGroup.add(good);
    rateGroup.add(excellent);
    verypoorImage = new ImageIcon("/Users/haileytong/Desktop/IT-230/verypoor.gif");
    verypoorLabel = new JLabel(verypoorImage);
    poorImage = new ImageIcon("/Users/haileytong/Desktop/IT-230/poor.gif");
    poorImageLabel = new JLabel(poorImage);
    averageImage = new ImageIcon("/Users/haileytong/Desktop/IT-230/average.gif");
    averageLabel = new JLabel(averageImage);
    goodImage = new ImageIcon("/Users/haileytong/Desktop/IT-230/good.gif");
    goodLabel = new JLabel(goodImage);
    excellentImage = new ImageIcon("/Users/haileytong/Desktop/IT-230/excellent.gif");
    excellentLabel = new JLabel(excellentImage);
    eastPanel = new JPanel();
    eastPanel.setLayout(new GridLayout(4,1));
    JPanel ratePanel = new JPanel();
    ratePanel.add(verypoor);
    ratePanel.add(verypoorLabel);
    ratePanel.add(poor);
    ratePanel.add(poorImageLabel);
    ratePanel.add(average);
    ratePanel.add(averageLabel);
    ratePanel.add(good);
    ratePanel.add(goodLabel);
    ratePanel.add(excellent);
    ratePanel.add(excellentLabel);
    eastPanel.add(rateLabel);
    eastPanel.add(ratePanel);
    
    comment = new JLabel("How Would You Want Us To Improve Our Service: ");
    commentBox = new JTextArea(20,40);
    eastPanel.add(comment);
    eastPanel.add(commentBox);
    add(eastPanel, BorderLayout.EAST);
     
    submit = new JButton("Submit");
    submit.addActionListener(this);
    cancel = new JButton("Cancel");
    cancel.addActionListener(this);
    southPanel = new JPanel();
    southPanel.setBackground(Color.PINK);
    southPanel.add(submit);
    southPanel.add(cancel);
    add(southPanel, BorderLayout.SOUTH);
    
    setSize(1000,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == submit) {
      String cusID = cusIDTextField.getText();
      String firstname = firstnameTextField.getText();
      String lastname = lastnameTextField.getText();
      
      String gender = "";
      if(male.isSelected()) {
        gender = "Male";
      }
      else if(female.isSelected()) {
        gender = "Female";
      }
      else if(transgender.isSelected()) {
        gender = "Transgender";
      }
      else if(noAnswer.isSelected()) {
        gender = "Prefer Not To Answer";
      }
      
      String month = monthBox.getSelectedItem().toString();
      String day = dayBox.getSelectedItem().toString();
      String year = yearTextField.getText();
      
      String hWash = "No";
      if(wash.isSelected()) {
        hWash = "Yes";
      }
      
      String hCut = "No";
      if(cut.isSelected()) {
        hCut = "Yes";
      }
      
      String hColor = "No";
      if(color.isSelected()) {
        hColor = "Yes";
      }
      
      String hBleach = "No";
      if(bleach.isSelected()) {
        hBleach = "Yes";
      }
      
      String hHighlight = "No";
      if(highlight.isSelected()) {
        hHighlight = "Yes";
      }
      
      String hCurl = "No";
      if(curl.isSelected()) {
        hCurl = "Yes";
      }
      
      String hBlowdry = "No";
      if(blowdry.isSelected()) {
        hBlowdry = "Yes";
      }
      
      String hTreatment = "No";
      if(treatment.isSelected()) {
        hTreatment = "Yes";
      }
      
      String hStraight = "No";
      if(straight.isSelected()) {
        hStraight = "Yes";
      }
      
      String hVolumn = "No";
      if(volumn.isSelected()) {
        hVolumn = "Yes";
      }
      
      String hStyle = "No";
      if(style.isSelected()) {
        hStyle = "Yes";
      }
      
      String rateService = "";
      if(verypoor.isSelected()) {
        rateService = "Very Poor";
      }
      else if(poor.isSelected()) {
        rateService = "Poor";
      }
      else if(average.isSelected()) {
        rateService = "Average";
      }
      else if(good.isSelected()) {
        rateService = "Good";
      }
      else if(excellent.isSelected()) {
        rateService = "Excellent";
      }
      
      try {
        if(rateService.equals(""))
          throw new ServiceException();
      }
      catch(ServiceException se) {
        JOptionPane.showMessageDialog(null, se.toString());
      }
      
      String comment = commentBox.getText();
      
      String URL = "jdbc:mysql://localhost/salonsurvey?user=root&password=";
      try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("JDBC connected successfully");
        Connection conn = DriverManager.getConnection(URL);
        System.out.println("Log in to MySQL successfully");
      
        String insert_stmt = "insert into report (customerID, firstname, lastname, gender, birthmonth, birthday, servicerate) values ('" + cusID + "', '" + firstname +"', '" + lastname +"', '" + gender +"', '" + month +"', '" + day +"', '" + rateService +"')";
        Statement stmt = conn.createStatement();
        stmt.execute(insert_stmt);
        System.out.println("Insert successfully");
      }
      catch(ClassNotFoundException e) {
        e.printStackTrace();
      }
      catch(SQLException e) {
        e.printStackTrace();
      }
      
      String output = "Survey Report" +
                      "\nCustomer No.: " + cusID + "\nFirst Name: " + firstname + "; Last Name: " + lastname +
                      "\nGender: " + gender +
                      "\nDate of Birth: " + month + " " + day + ", " + year + 
                      "\nWhich service(s) did you have with us: \nHair Wash: " + hWash + "\nHair Cut: " + hCut +
                      "\nColoring: " + hColor + "\nBleach: " + hBleach + "\nHighlight: " + hHighlight + 
                      "\nCurling: " + hCurl + "\nBlow-dry: " + hBlowdry + "\nTreatment: " + hTreatment + 
                      "\nStraightening: " + hStraight + "\nVolumn: " + hVolumn + "\nStyling: " + hStyle + 
                      "\nRate Our Service: " + rateService +
                      "\nHow Would You Want Us to Improve Our Service: " + comment;
      
      JOptionPane.showMessageDialog(null, output);
      
      File myfile = new File("serviceReport.txt");
      try {
        FileWriter writer = new FileWriter(myfile);
        writer.write(output);
        writer.close();
      }
      catch(IOException e) {
        System.out.println(e.toString());
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
    else if(event.getSource() == cancel) {
      cusIDTextField.setText("");
      firstnameTextField.setText("");
      lastnameTextField.setText("");
      genderGroup.clearSelection();
      monthBox.setSelectedIndex(0);
      dayBox.setSelectedIndex(0);
      yearTextField.setText("");
      wash.setSelected(false);
      cut.setSelected(false);
      color.setSelected(false);
      bleach.setSelected(false);
      highlight.setSelected(false);
      curl.setSelected(false);
      blowdry.setSelected(false);
      treatment.setSelected(false);
      straight.setSelected(false);
      volumn.setSelected(false);
      style.setSelected(false);
      rateGroup.clearSelection();
      commentBox.setText("");
    }
  }
  
  public static void main(String [] args) {
    SalonSurvey ss = new SalonSurvey();
  }
}