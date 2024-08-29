import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class DurationCalculator{

    JTextField sDay,sMonth,sYear,eDay,eMonth,eYear,result;

    public DurationCalculator(){
        JFrame f = new JFrame("Duration Calculator");
        f.setSize(500, 300);
        f.setLayout(null);
        f.setVisible(true);

        JLabel start = new JLabel("Start Date : ");
        sDay = new JTextField(2);
        sMonth = new JTextField(2);
        sYear = new JTextField(4);
        JLabel end = new JLabel("End date     : ");
        eDay = new JTextField(2);
        eMonth = new JTextField(2);
        eYear = new JTextField(4);
        JButton calculate = new JButton("Calculate");
        JLabel duration = new JLabel("Duration : ");
        result = new JTextField(10);
        result.setText("");
        result.setEditable(false);

        f.add(start);
        f.add(sDay);
        f.add(sMonth);
        f.add(sYear);
        f.add(end);
        f.add(eDay);
        f.add(eMonth);
        f.add(eYear);
        f.add(calculate);
        f.add(duration);
        f.add(result);

        start.setBounds(50,50,100,10);
        sDay.setBounds(120, 45,22,20);
        sMonth.setBounds(150, 45,22,20);
        sYear.setBounds(180, 45,35,20);
        end.setBounds(50, 100, 100, 10);
        eDay.setBounds(120, 95,22,20);
        eMonth.setBounds(150, 95,22,20);
        eYear.setBounds(180, 95,35,20);
        calculate.setBounds(50,150,100,20);
        duration.setBounds(50,200,100,10);
        result.setBounds(120,195,300,20);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                calculateResult();
            }
        });
    }

    void calculateResult(){
        try{
            int sDD,sMM,sYYYY,eDD,eMM,eYYYY;
            sDD = Integer.parseInt(sDay.getText());
            sMM = Integer.parseInt(sMonth.getText());
            sYYYY = Integer.parseInt(sYear.getText());
            eDD = Integer.parseInt(eDay.getText());
            eMM = Integer.parseInt(eMonth.getText());
            eYYYY = Integer.parseInt(eYear.getText());

            LocalDate date1 = LocalDate.of(sYYYY,sMM,sDD);
            LocalDate date2 = LocalDate.of(eYYYY,eMM,eDD);
            Period period = Period.between(date1, date2);

            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();
            result.setText(years+" years, "+months+" months and "+days+" days");
        }
    catch(NumberFormatException nfe){
        result.setText("Invalid date");
    }
    catch(DateTimeException dte){
        result.setText(""+dte);
    }
    }

    public static void main(String[] args) {
        new DurationCalculator();
    }
}