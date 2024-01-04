import Plan.*;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class MainScreen extends JFrame {
    //Customization
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Color myColor = Color.GRAY;

    //Panel 1
    JTextField subFName;
    JTextField subLName;
    JTextField subCity;
    JTextField subPhone;

    //Panel 2
    JTextField model;
    JTextField manufacturer;
    JTextField plateNB;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    //Panel 3
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assisCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();

    //Panel 4
    JRadioButton yearRadio;
    JRadioButton yearRadio2;
    JRadioButton yearRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYear =0;
    SimpleDateFormat df;
    Date currentDate;

    //panel 5
    JTextArea risksTXT;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    //panel 7
    JTextArea policyTXT;
    //Panel8
    JTextArea customerTXT;

    //Panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;
    //panel 10
    JLabel claimingCxNameLBL;
    JLabel claimingStatusLBL2;
    JTextArea claimingCxrisksCoveredAREA;
    JLabel claimingCxValidateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;
    //Panel 11
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;
    //Panel 12
    JTextArea settlementArea2;
    //Constructor
    public MainScreen() {
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }
    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Customer  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);
        p1.setBorder(titledBorder);

        JLabel fNameLBL = new JLabel(" First Name");
        JLabel lNameLBL = new JLabel(" Last Name");
        JLabel CityLBL = new JLabel(" City");
        JLabel phoneLBL = new JLabel(" Phone");

        subFName = new JTextField();   subFName.setOpaque(false);
        subLName = new JTextField();   subLName.setOpaque(false);
        subCity = new JTextField();    subCity.setOpaque(false);
        subPhone = new JTextField();   subPhone.setOpaque(false);

        p1.add(fNameLBL);
        p1.add(subFName);
        p1.add(lNameLBL);
        p1.add(subLName);
        p1.add(CityLBL);
        p1.add(subCity);
        p1.add(phoneLBL);
        p1.add(subPhone);

        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(4,2));

        //Adding Panels to JFRAME
        setLayout(null);
        add(p1);

    }
    private void CustomizePanel2() {
        JPanel p2 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Vehicle  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p2.setBorder(titledBorder);
        //JLabel p2
        JLabel plateNbLBL = new JLabel(" Plate Nb");
        JLabel modelLBL = new JLabel(" Model Year");
        JLabel manufacturerLBL = new JLabel(" Manufacturer");
        JLabel estimatedLBL = new JLabel(" Estimated Value");
        JLabel spaceLBL = new JLabel("  ");
        JLabel damageLBL = new JLabel(" Major Damage");

        plateNB = new JTextField();         plateNB.setOpaque(false);
        model = new JTextField();           model.setOpaque(false);
        manufacturer = new JTextField();    manufacturer.setOpaque(false);
        estimated = new JTextField();       estimated.setOpaque(false);

        //Radio Buttons
        damageRadio1 = new JRadioButton(); damageRadio1.setText(" Motor");
        damageRadio2 = new JRadioButton(); damageRadio2.setText(" Wheels");
        damageRadio3 = new JRadioButton(); damageRadio3.setText(" Body");
        damageRadio4 = new JRadioButton(); damageRadio4.setText(" None");

        G1 = new ButtonGroup();
        G1.add(damageRadio1);
        G1.add(damageRadio2);
        G1.add(damageRadio3);
        G1.add(damageRadio4);

        //Adding component to Panel 2
        p2.add(plateNbLBL); p2.add(plateNB);
        p2.add(modelLBL); p2.add(model);
        p2.add(manufacturerLBL); p2.add(manufacturer);
        p2.add(estimatedLBL); p2.add(estimated);
        p2.add(spaceLBL);
        p2.add(damageLBL);
        p2.add(damageRadio1);
        p2.add(damageRadio2);
        p2.add(damageRadio3);
        p2.add(damageRadio4);

        //Customize panel 2
        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));

        //Adding Panels to JFRAME
        setLayout(null);
        add(p2);

    }
    private void CustomizePanel3() {
        JPanel p3 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Plan  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Please Select your Plan");

        //checkbox
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risk");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        //Get all risks covered by plan
        GetRisksCoveredByPlan();

        //adding component to panel3
        p3.add(packageLBL);
        p3.add(obligatoryCHKBX);
        p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX);
        p3.add(dDamageCHKBX);
        p3.add(assisCHKBX);

        add(p3);
    }
    private void CustomizePanel4() {
        JPanel p4 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Validity Period  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));

        //Radio Buttons
        JLabel spacer2 = new JLabel(" ");
        spacer2.setOpaque(false);
        yearRadio= new JRadioButton(); yearRadio.setText(" 1 Year");
        yearRadio2= new JRadioButton(); yearRadio2.setText(" 2 Years");
        yearRadio3= new JRadioButton(); yearRadio3.setText(" 3 Years");

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear =1;
            }
        });
        yearRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear =2;
            }
        });
        yearRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear =3;
            }
        });

        //Button group
        G2 = new ButtonGroup();
        G2.add(yearRadio);
        G2.add(yearRadio2);
        G2.add(yearRadio3);

        //Time & date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/YYYY");
        currentDate = new Date();
        todayLBL.setText("Today: "+ df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize()+ 0.3f;
        todayLBL.setFont(font.deriveFont(size));

        //adding component to panel4
        p4.add(spacer2);
        p4.add(spacer2);
        p4.add(todayLBL);
        p4.add(spacer2);
        p4.add(yearRadio);
        p4.add(yearRadio2);
        p4.add(yearRadio3);

        add(p4);
    }
    private void CustomizePanel5() {
        JPanel p5 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Actions  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p5.setBorder(titledBorder);
        p5.setBounds(330,520,300,230);
        p5.setLayout(new GridLayout(7,1));

        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        searchTXT = new JTextField("Enter Car Plate Nb");
        searchTXT.setOpaque(false);

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                String str = "";
                for (int i=0; i<coveredRisksList.size(); i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                risksTXT.setText(str);
                try {
                    policyTXT.setText(GetPolicydata().toString());
                    DisplayPayment();

                } catch (ParseException parseException) {
                    throw new RuntimeException(parseException);
                }
            }
        });
        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SaveCxToDisk();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JLabel spacer3 = new JLabel(" ");
        spacer3.setOpaque(false);

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                SearchCXbyMobile();
            }
        });

        JLabel spacer4 = new JLabel(" ");
        spacer4.setOpaque(false);
        JLabel spacer5 = new JLabel(" ");
        spacer5.setOpaque(false);
        JLabel spacer6 = new JLabel(" ");
        spacer6.setOpaque(false);

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                NewCustomer();
            }
        });
        p5.add(spacer6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(spacer5);
        p5.add(searchTXT);
        p5.add(loadBTN);
        add(p5);

    }
    private void CustomizePanel6() {
        JPanel p6 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Covered Risks  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,200);
        p6.setLayout(new GridLayout(7,1));

        risksTXT = new JTextArea(7,1);
        risksTXT.setEditable(false);
        risksTXT.setOpaque(false);
        risksTXT.setLineWrap(true);

        //Font
        Font font = risksTXT.getFont();
        float size = font.getSize()+ 3.0f;
        risksTXT.setFont(font.deriveFont(size));

        p6.add(risksTXT);
        p6.setLayout(new GridLayout(1,1));
        add(p6); //adding p6 to JFame

    }
    private void CustomizePanel7() {
        JPanel p7 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Policy Details  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p7.setBorder(titledBorder);
        p7.setBounds(645,250,300,250);
        p7.setLayout(new GridLayout(6,1));

        policyTXT = new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setOpaque(false);
        policyTXT.setLineWrap(true);

        //Font
        Font font = policyTXT.getFont();
        float size = font.getSize()+ 3.0f;
        policyTXT.setFont(font.deriveFont(size));

        p7.add(policyTXT);
        p7.setLayout(new GridLayout(1,1));
        add(p7); //adding p7 to JFame
    }
    private void CustomizePanel8() {
        JPanel p8 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Customer Details  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p8.setBorder(titledBorder);
        p8.setBounds(645,520,300,230);
        p8.setLayout(new GridLayout(6,1));

        customerTXT= new JTextArea(20,1);
        customerTXT.setEditable(false);
        customerTXT.setOpaque(false);
        customerTXT.setLineWrap(true);

        //Font
        Font font = customerTXT.getFont();
        float size = font.getSize()+ 3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT);
        p8.setLayout(new GridLayout(1,1));
        add(p8); //adding p8 to JFame
    }
    private void CustomizePanel9() {
        JPanel p9 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Claims  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p9.setBorder(titledBorder);
        p9.setBounds(960,15,300,485);


        claimingTXT = new JLabel("Enter Plate Nb. for the Claiming Customer");
        JLabel spacer9 = new JLabel("                                               ");
        claimingTXT2 = new JLabel("Select the type of Damage or Assistance Needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250,30));
        claimingCustomerField.setOpaque(false);

        String[] items = {"Fire", "Robbery", "Third Party Damage", "Vehicle damage", "Driver Damage", "Transport", "Car Replacement"};

        final JList claimList =  new JList(items);

        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setOpaque(false);
        claimList.setPreferredSize(new Dimension(250,150));
        JButton searchClaimer = new JButton("Search Customer");
        List<String> coveredRisksByUserLIST = new ArrayList<>();
        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false; //cx is registered before in our db?
                cond2 = false; //is the cx's policy cover the claimed
                cond3 = false; //is the policy date valid?
                try{
                    coveredRisksByUserLIST.clear();
                    Customer c = ClaimSearchCXbyMobile();
                    claimingCxNameLBL.setText("claiming Customer: "+ c.getFname()+" " + c.getLname());
                    cond1 = true;

                    String str7 ="";
                    for(int i=0; i<c.getPolicy().getCoverageLIST().size(); i++){
                        str7 += c.getPolicy().getCoverageLIST().get(i) + " \n";
                        coveredRisksByUserLIST.add(String.valueOf(c.getPolicy().getCoverageLIST().get(i)));
                    }
                    LocalDate v_validitypolicy =c.getPolicy().getPolicyDate();
                    int v_polValidityYear =c.getPolicy().getValidityYear();
                    v_validitypolicy = v_validitypolicy.plusYears(v_polValidityYear);
                    CheckpolicyValidity(v_validitypolicy);

                    claimingCxrisksCoveredAREA.setText("Covered Risks by Customer plan: \n"+str7);
                    claimingCxValidateLBL.setText("date validity of Policy: "+ v_validitypolicy +" || " +CheckpolicyValidity(v_validitypolicy));

                    if( c.getPolicy().getCoverageLIST().size() >= 5){
                        //if the user has a all-risks plan
                        cond2 = true;
                    }

                }catch (Exception re){
                    claimingCxNameLBL.setText("Claiming Customer: Not Found");
                }

            }
        });

        JButton confirmClaimBTN = new JButton("  Confirm Claim");
        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the index of all the selected items
                int[] selectedIx =claimList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();
                if (claimList.getSelectedIndex() != -1){
                    for (int i=0; i<selectedIx.length; i++){
                        String k = "" + claimList.getModel().getElementAt(selectedIx[i])+ " ";
                        claimed_list.add(""+ claimList.getModel().getElementAt(selectedIx[i]));
                        System.out.print(""+k);
                    }
                }
                //check for included risks
                if(cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
                }
                //check for claim validity to add the to the customer
                ClaimisValid();

                //Display settelements
                Customer c = ClaimSearchCXbyMobile();
                if(ClaimisValid()) {
                    int claims_nb = claimed_list.size();
                    if (claimed_list.contains("Fire")) {
                        settlementArea2.setText("Fire Department: " + c.getPolicy().getVehicle().getEstimatedValue() * 0.25 + "  $");
                    } else if (claimed_list.contains("Robbery")) {
                        settlementArea2.setText("ProSec Company: " + c.getPolicy().getVehicle().getEstimatedValue() * 0.5 + " $" +
                                "Pay for the Customer " + c.getPolicy().getVehicle().getEstimatedValue() * 1 + " $");
                    } else if (claimed_list.contains("Third Party Damage")) {
                        settlementArea2.setText("Driver in other car: " + 2000 + "$");
                    } else if (claimed_list.contains("Vehicle Damage")) {
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 1 + " $");
                    }else if (claimed_list.contains("Driver Damage")) {
                            settlementArea2.setText("Pay for Customer: " +
                                    c.getPolicy().getVehicle().getEstimatedValue() * 10 + " $");
                    } else if (claimed_list.contains("Transport")) {
                        settlementArea2.setText("Transport Company " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.5 + " $");
                    } else if (claimed_list.contains("Car Replacement")) {
                        settlementArea2.setText("Car Rental Company " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.2 + " $");
                    } else if (claims_nb > 2) {
                        settlementArea2.setText("Driver "
                                + c.getPolicy().getVehicle().getEstimatedValue() * 4 + " " +
                                "Hospital " + c.getPolicy().getVehicle().getEstimatedValue() * 4 + " $" +
                                "Car Rental Company " +
                                c.getPolicy().getVehicle().getEstimatedValue() * 0.2 + " $" +
                                "Third Party Driver " + c.getPolicy().getVehicle().getEstimatedValue() * 2);
                    } else {

                    }
                }

            }
        });

        p9.add(claimingTXT);
        p9.add(claimingCustomerField);
        p9.add(searchClaimer);
        p9.add(spacer9);
        p9.add(claimingTXT2);
        p9.add(claimList);
        p9.add(confirmClaimBTN);
        add(p9);
    }
    private void CustomizePanel10() {
        JPanel p10 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Claim Status  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p10.setBorder(titledBorder);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));
        //Jlabels
        claimingCxNameLBL = new JLabel("Claiming Customer: ");
        claimingCxValidateLBL = new JLabel("Date Validity of Policy: ");
        claimingStatusLBL2 = new JLabel("Claiming Status: ");
        //Jtext area
        claimingCxrisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCxrisksCoveredAREA);
        claimingCxrisksCoveredAREA.setOpaque(false);

        p10.add(claimingCxNameLBL);
        p10.add(claimingCxValidateLBL);
        p10.add(pictureScrollPane);
        p10.add(claimingStatusLBL2);

        add(p10);
    }
    private void CustomizePanel11() {
        JPanel p11 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Payments  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p11.setBorder(titledBorder);
        p11.setBounds(1275,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        //FonT
        Font font = settlementArea.getFont();
        float size = font.getSize()+ 4.0f;
        settlementArea.setFont(font.deriveFont(size));

        p11.add(settlementArea);
        add(p11);
    }
    private void CustomizePanel12() {
        JPanel p12 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY,1)
                ,"  Settlements  ", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, myFont,myColor);

        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

        //FonT
        Font font = settlementArea.getFont();
        float size = font.getSize()+ 4.0f;
        settlementArea.setFont(font.deriveFont(size));
        add(p12);
    }

  /*************************Methods***********************/
   public Customer GetCxData() throws ParseException{
       Customer customer = new Customer(
               subFName.getText(),
               subLName.getText(),
               subCity.getText(),
               Integer.parseInt(subPhone.getText()),
               GetPolicydata());
       return customer;
   }
   //vehicle data
    public Vehicle GetVehicleData(){
       Vehicle vehicle = new Vehicle(
               Integer.parseInt(plateNB.getText()),
               Integer.parseInt(model.getText()),
               manufacturer.getText(),
               Integer.parseInt(estimated.getText()),
               GetDamageState());
       return vehicle;
    }


   //policy Data
    public Policy GetPolicydata() throws ParseException{
        currentDate = new Date();
        LocalDate now = LocalDate.now();
        Policy policy = new Policy(
                GetVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageList,
                ceilingRisksList,
                validityYear,
                now
        );
        return policy;
    }
    // get damage data
    public int GetDamageState(){
       if (damageRadio1.isSelected()){
           return 1;
       }else if(damageRadio2.isSelected()){
           return  2;
       }else if (damageRadio3.isSelected()){
           return  3;
       }else return 0;
    }
    public void GetRisksCoveredByPlan() {
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
        allRiskCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dDamageCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                assisCHKBX.setEnabled(false);
                obligatoryCHKBX.setEnabled(false);

                //adding risk details to an array
                for (int i =0 ; i< allRisk.allRisksCovered.length; i++){
                    coveredRisksList.add(allRisk.allRisksCovered[i]);
                }
                premiumRisksList.add(allRisk.getPremium());
                coverageList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
            }
        });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adding risk details to an array
                coveredRisksList.add(obligatoryRisk.obligatoryRisksCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
                coverageList.add(obligatoryRisk.getCoverage());
                ceilingRisksList.add(obligatoryRisk.getCeiling());
            }
        });

        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehiculeRisk vehiculeRisk = new VehiculeRisk();

                //adding risk details to an array
                coveredRisksList.add(vehiculeRisk.vehicleRisksCovered[0]);
                premiumRisksList.add(vehiculeRisk.getPremium());
                coverageList.add(vehiculeRisk.getCoverage());
                ceilingRisksList.add(vehiculeRisk.getCeiling());
            }
        });
       dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();

                //adding risk details to an array
                coveredRisksList.add(driverRisk.getDriverRisksCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageList.add(driverRisk.getCoverage());
                ceilingRisksList.add(driverRisk.getCeiling());
            }
        });
        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();

                //adding risk details to an array
                for (int i =0 ; i< assistanceRisk.assistanceRisksCovered.length; i++){
                    coveredRisksList.add(assistanceRisk.assistanceRisksCovered[i]);
                }
                premiumRisksList.add(assistanceRisk.getPremium());
                coverageList.add(assistanceRisk.getCoverage());
                ceilingRisksList.add(assistanceRisk.getCeiling());
            }
        });
    }
    //reseting field to empty
    private void NewCustomer(){
       coveredRisksList.clear();
       coverageList.clear();
       premiumRisksList.clear();
       ceilingRisksList.clear();
       cond1 =false;
       cond2=false;
       cond3=false;

       //set text fields to empty
        subFName.setText("");
        subLName.setText("");
        subCity.setText("");
        subPhone.setText("");
        plateNB.setText("");
        model.setText("");
        manufacturer.setText("");
        estimated.setText("");

        //set Radio button to none
        G1.clearSelection();
        G2.clearSelection();

        //Reset checkbox
        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        dDamageCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);
        obligatoryCHKBX.setEnabled(true);

    }
    private void SearchCXbyMobile() {
        File file = new File("D:/myfile1.dat");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            Customer c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTXT.setText(c_finded.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private Customer ClaimSearchCXbyMobile() {
        Customer customer = new Customer();
        File file = new File("D:/myfile1.dat");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

           customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
    // save Dat to disk
    public void SaveCxToDisk() throws IOException, ClassNotFoundException, ParseException {
       File file = new File("D:/myfile1.dat");
       int platenum = Integer.parseInt(plateNB.getText());

       if(!file.exists()){
           //Creating new File
           System.out.println("Not Existed!");
           file.createNewFile();
           SaveCxtoNewFile(platenum, file);
       }else{
           //file exists
           TreeMap<Integer,Customer> newMaptoSave = new TreeMap<>();
           InputStream is = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(is);
           TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
           ois.close();
           is.close();
           //get old map
           for (Map.Entry<Integer, Customer> m : mapInFile.entrySet()){
               newMaptoSave.put(m.getKey(), m.getValue());
           }
           //updating the map: adding new cx
           newMaptoSave.put(platenum, GetCxData());

           //save update to file
           OutputStream os = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(os);
           oos.writeObject(newMaptoSave);
           oos.flush();
           oos.close();
       }
    }
    private void SaveCxtoNewFile(int platenum, File file) throws ParseException, IOException {

       TreeMap<Integer,Customer> newMaptoSave = new TreeMap<>();
       //Adding new cx to map
        newMaptoSave.put(platenum,GetCxData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMaptoSave);
        oos.flush();
        oos.close();
    }
    private boolean CheckpolicyValidity(LocalDate v_valpolicy){
       LocalDate now = LocalDate.now();

       if (now.isBefore(v_valpolicy)){
           cond3 =true;
           return true;
       }else{
           cond3 = false;
           return false;
       }
    }
    private boolean ClaimisValid(){
       if (cond1 == true && cond2 == true && cond3 == true){
           claimingStatusLBL2.setText("Claiming Status: You can register the claim");
           return true;
       }else{
           claimingStatusLBL2.setText("Claiming Status: Not able to register the claim");
           return false;
       }
    }
    private void DisplayPayment(){
       for (int i = 0; i<premiumRisksList.size(); i++){
           totalPremium += premiumRisksList.get(i);
           totalCoverage += coverageList.get(i);
           totalCeiling += ceilingRisksList.get(i);
       }

       settlementArea.setText(
               "Total Premium: "+totalPremium*Integer.parseInt(estimated.getText())+ " $ \n"+
                "Risks Coverage: "+totalCoverage*Integer.parseInt(estimated.getText())*10+ " $ \n"+
                "Max Ceiling: "+totalCeiling*Integer.parseInt(estimated.getText())+ 100000+ " $ \n"
       );
    }

    public static void main(String[] args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance company System");
        mainScreen.setBounds(0,0,1920,1080);

    }

}
