package tools;

import commands.Command;
import exceptions.XmlReadingException;
import exceptions.XmlSaveException;

import java.util.ArrayList;

public class JournalManager {

    public CommandList journal;

    public JournalManager(){journal = new CommandList();}

    public void addCommand(Command command){
        journal.getCommands().add(command);
    }

    public void clearJournal(){
        journal.getCommands().clear();
    }

    public void saveJournal(){
        try {
            XMLWriter xmlWriter = new XMLWriter();
            xmlWriter.journalToXML(journal);
        }catch (XmlSaveException e){
            System.out.println(e.getMessage());
        }

    }

    public void readJournal(){
        try {
            XMLReader xmlReader = new XMLReader();
            journal = xmlReader.readXmlJournal("journal.xml");
        } catch (XmlReadingException e) {
            System.out.println(e.getMessage());
        }
    }

    public CommandList getJournal(){
        return journal;
    }

}
