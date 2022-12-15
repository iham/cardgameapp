package msc.ddb.international;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static java.time.temporal.ChronoUnit.MILLIS;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.io.IOException;
import java.net.UnknownHostException;

import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDateTime;
import static java.time.Instant.now;
import java.util.UUID;

import static java.util.Locale.*;

/**
 * @see <a href = "spec.html#section">Java Spec</a>
 * 
 */

import msc.ddb.international.actors.Player;
import msc.ddb.international.exceptions.NotEnoughPlayersException;
import msc.ddb.international.exceptions.TooManyPlayersException;


/**
 * <p><b> CardGameApp </b></p>
 * <p><i> written by the specialist Markus Hilbert and his 'international' boygroup (Felix, Eric, Hannes)</i></p>
 * 
 * @author Markus Hilbert
 * @version 4.4
 * 
 */
public class App 
{
    public static Scanner input = new Scanner(System.in);
    
    // Instantiation Input

    private static String actLang = "English"; // Variable = Camelcase
    private static final String FILENAME_ENVIRONMENT = "GI_Environment.txt"; // Filename = Konstante
    private static final String FILENAME_LOGGING = "GI_Logging.xml";
    private static final String FILENAME_GAME = "GI_Game.txt";

    private static final Logger log = Logger.getLogger(App.class.getName());
    public static FileHandler handlerLog; 
    public static Instant start = now();

    public static final String standardLanguage = GERMANY.getDisplayLanguage();
    public static final String standardLanguageEN = GERMANY.getDisplayLanguage(ENGLISH);

    
    /** 
     * @param args (no arguments required)
     */
    public static void main( String[] args )
    {
        startLogging();
        getEnvironment();
        consoleChooseLanguage();

        try {
            BlackJack game = new BlackJack();
            game.addPlayer(new Player("Harald"));
            game.initializeGame();
            game.startGame();                
        } catch (TooManyPlayersException e) {
            e.printStackTrace();
            log.warning("Warning - To many players in the game!");
        } catch (NotEnoughPlayersException e) {
            e.printStackTrace();
            log.warning ("Warning - Not enough players in the game!");
        }

        finishApp();
    
    }

    public static void startLogging()
    {

        // If Loggingfile exists, it will be deleted
        Path path = Paths.get( FILENAME_LOGGING );
  
        try {
            Files.deleteIfExists( path );
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("Error! - Error deleting file (" + FILENAME_LOGGING + ")");
        }

        try {
            handlerLog = new FileHandler( FILENAME_LOGGING );
            log.addHandler(handlerLog);
        } catch (IOException| SecurityException e) {
            log.log(Level.WARNING, "Error while creating the logfile (" + FILENAME_LOGGING + ")", e);
        }
        log.info ("Start Logging with Java Util Logging (" + FILENAME_LOGGING + ")");
    }

    /** 
     * @param contentParam (String content Parameter for Environment)
     */
    public static void writeEnvironmentFile(String contentParam) {
        
        try {
            Files.writeString( Path.of( FILENAME_ENVIRONMENT ), contentParam, StandardOpenOption.APPEND);
        } 
        catch (IOException e) {
            System.err.println("'%s' File (" + FILENAME_ENVIRONMENT + ") cannot be saved '%n'");
            e.printStackTrace();     
            log.severe("Error! - Error writing File (" + FILENAME_ENVIRONMENT + ")");
        }
    }

    
    /** 
     * @param contentParam (String content for Gamefile)
     * @deprecated (not implemented yet)
     */
    public static void writeGameFile(String contentParam) {
        
        try {
            Files.writeString( Path.of( FILENAME_GAME ), contentParam, StandardOpenOption.APPEND);
        } 
        catch (IOException e) {
            System.err.println("'%s' File (" + FILENAME_GAME + ") cannot be saved '%n'");
            e.printStackTrace();     
            log.severe("Error! - Error writing File (" + FILENAME_GAME + ")");
        }
    }

    public static void getEnvironment()
    {
        System.out.println("Get environment\n");

        // Date + Time from local TimeZone
        /* 
         * {@value #localDateTime}
         */
        LocalDateTime localDateTime = LocalDateTime.now();

        // UUID (Universal Unique Identifier)
        String content = "UUID      " + UUID.randomUUID() + "\n" + "Instant   " + start + "\n" + "LDateTime " + localDateTime + "\n";

        // If file exists, it will be deleted

        /**
         * @depreceated Paths.get in future release not support - use Paths.of instead
         */
        Path path = Paths.get( FILENAME_ENVIRONMENT );

        try {
            Files.deleteIfExists( path );
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("Error! - Error deleting file (" + FILENAME_ENVIRONMENT + ")");
        }

        try {
            Files.writeString( Path.of( FILENAME_ENVIRONMENT ), content, StandardOpenOption.CREATE_NEW);
        } 
        catch (IOException e) {
            System.err.println("'%s' File cannot be saved '%n'");
            e.printStackTrace();     
            log.severe("Error! - Error deleting file - Logging with 'JUL' (Java Util Logging)");
        }
        finally {
            System.out.println("File write New (" + FILENAME_ENVIRONMENT + ") block finally");
            log.info("Info - File write new (" + FILENAME_ENVIRONMENT + ") block finally");
        }

        System.out.println("\n===>> Environment <<===");

       
        try {
            String Computer_Name = InetAddress.getLocalHost().getHostName();
            String IP_Address = InetAddress.getLocalHost().getHostAddress();


            writeEnvironmentFile("Hostname  " + Computer_Name + "\n");
            writeEnvironmentFile("IPAddress " + IP_Address + "\n");
        } 
        catch (UnknownHostException e) {
            System.out.println("Error: UnknownHostException!");
            log.severe("Error! - Error unknown host (" + FILENAME_ENVIRONMENT + ")");
        }

         
        String Java_Home = System.getProperty("java.home","/tmp/java");
        String OS = System.getProperty("os.name","Linux");
        String User_Name = System.getProperty("user.name","John Doe");
        String Java_Version = System.getProperty("java.version","19");

        content = "JavaHome  " + Java_Home + "\n";
        writeEnvironmentFile(content);
        content = "OSName    " + OS + "\n";
        writeEnvironmentFile(content);
        content = "UserName  " + User_Name + "\n";
        writeEnvironmentFile(content);
        content = "JavaVers  " + Java_Version + "\n";
        writeEnvironmentFile(content);
        content = "--------------------------------------------------------------------------------------------------------------------";
        writeEnvironmentFile(content);

        log.info ("Write Environments: " + User_Name);
    }

    public static void consoleChooseLanguage()
    {

        System.out.println("\n");
        System.out.println("Standard Language      = " + standardLanguage);
        System.out.println("Standard Language (EN) = " + standardLanguageEN);

        /* 
         * @see #actLang (selected Language)
         */

         String[] validLang = {"German","English","X"};
         String actLang = standardLanguageEN; // Defaultvalue
         boolean selectedLang = false;

        while (!selectedLang) {
            System.out.println("\n--------------------------------------------");
            System.out.println("Choose a language: (German|English [X=Exit])");
            System.out.println("--------------------------------------------\n");

            String inputLang = input.nextLine();

            for ( String s : validLang )
                /* 
                 * Uses {@code equals()} and not {@code ==}
                 */
                if ( s.equals( inputLang ) ) {
                    selectedLang = true;
                    /* 
                     * {@value #actLang}
                     */
                    actLang = inputLang;
                    System.out.println("selected language: " + actLang);
                    log.info ("Selected language (" + actLang + ")");
                    break;
                }            
        }

        if ( actLang.equals( "X" )) {
            actLang = standardLanguageEN;
            System.out.println("Program Exit");
            log.info ("Program Exit: (" + actLang + ")");
            finishApp();
        }
        log.info ("selected language: " + actLang);
        
    }
  
    /* 
     * @see #method(finishApp)
     */
    public static void finishApp() {
        /* 
         * Uses {@code equals()} and not {@code ==}
         */
        if(actLang.equals( "English" ))
            System.out.println("Card game finished." );
        else
            System.out.println("Translation (" + actLang + ") not implemented yet!" );

        System.out.println("\n");
        log.info ( () -> String.format( "Runtime %s ms", start.until( now(), MILLIS))) ;
        
        try {
            handlerLog.close();            
        } 
        catch (NullPointerException e) {
            System.err.println("File (" + FILENAME_LOGGING + ") NULLPointer not defined");
            e.printStackTrace();     
            log.severe("Error! - Error closing Loghandler (" + FILENAME_LOGGING + ")");
        }
        catch (SecurityException e) {
            System.err.println("File (" + FILENAME_LOGGING + ") cannot be closed");
            e.printStackTrace();     
            log.severe("Error! - Error closing Loghandler (" + FILENAME_LOGGING + ") not privileged");
        }
    }
}