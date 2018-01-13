package kata6.main;

import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;
import kata6.model.Mail;
import kata6.model.Histogram;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Person;
import kata6.view.DataBaseList;

public class Kata6 {
    private List<Mail> mailList;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private List<Person> people;
    private HistogramBuilder<Person> builderPerson;
    private Histogram<Character> gender;
    private Histogram<Float> weight;
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Kata6 a = new Kata6();
        a.execute();
    }

    private void execute() throws IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
            
    private void input() throws IOException, ClassNotFoundException, SQLException{
        String filename = "C:\\Users\\fali0\\Documents\\NetBeansProjects\\Kata4\\emailsfile.txt";
        mailList = MailListReader.read(filename);
        builder = new HistogramBuilder<>(mailList);
        people = DataBaseList.read();
        builderPerson = new HistogramBuilder<>(people);
    }
            
    private void process(){
        domains = builder.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        
        letters = builder.build(new Attribute<Mail, Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        
        gender = builderPerson.build(new Attribute<Person, Character>(){
            @Override
            public Character get(Person item){
                return item.getGender();
            }
        });
        
        weight = builderPerson.build(new Attribute<Person, Float>(){
            @Override
            public Float get(Person item){
                return item.getWeight();
            }
        });
    } 
            
    private void output(){
        HistogramDisplay histoDisplay1 = new HistogramDisplay(domains, "Dominios", "Nº de emails");
        histoDisplay1.execute();
        HistogramDisplay histoDisplay2 = new HistogramDisplay(letters, "Primer caracter", "Nº de emails");
        histoDisplay2.execute(); 
        HistogramDisplay histoPerson = new HistogramDisplay(gender, "Género", "Nº de personas");
        histoPerson.execute();
        HistogramDisplay histoWeight = new HistogramDisplay(weight, "Peso", "Nº de personas");
        histoWeight.execute();
    }
            
    
    
}
