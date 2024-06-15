package generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class sheetGenerator
{
   public static final String[] NOTES = {"C", "D", "E", "F", "G", "A" , "B", "C", "D", "E", "F", "G", "A"};
   public static final String[] NOTE_LENGTHS = {"quarter note", "half note", "eighth note", "sixteenth note"};
   private ArrayList<String> currentSheet;
   private int beatCount;
   private int measureCount;
   private boolean isTreble;
   
   private Random random;
   
   //TODO add constructor to change beat count
   //TODO I believe there is a way to get information such as beatcount and measurecount from the arraylist rahter than private attributes. look into
   
   public sheetGenerator (boolean isTreble) {
      
      this.isTreble = false;
      this.beatCount = 4;
      this.measureCount = 4;
      
      this.random = new Random();
      currentSheet = new ArrayList<String>();
      setTreble(isTreble);
   }
   
   public sheetGenerator() {
      this(true);
   }
   
   //TODO experiment with different list types
   public String[] createSheet() {
      String[] sheet = new String[getBeat() * this.measureCount];
      
      int thisNote;
      int thisLength;
      //for each beat, select a random note
      for (int i = 0; i < sheet.length; i++) {
    
         thisNote = random.nextInt(13); 
         thisLength = random.nextInt(4);
         
         sheet[i] = NOTE_LENGTHS[thisLength] + " " + NOTES[thisNote]; 
         
      }      
      
      currentSheet = new ArrayList<String>(Arrays.asList(sheet));
      
      return sheet;
   }
   
   /**
    * Returns the number of beats.
    * @return
    */
   public int getBeat() {
      int numBeats = 1;
      if (isValid()) numBeats = this.beatCount;
      return numBeats;
   }
   
   /**
    * Returns a string with the clef the sheet is using and the beatcount.
    * @override
    */
   public String toString() {
      String value = "Invalid sheet.";
      if (isValid()) {
         value = "A sheet of music on the " +  getClef() + " clef, with " + getBeat() + " beat(s).";
      }
      
      return value;
   }
   
   
   
   
   /*_______________________________________________________________-- */
   
   /**
    * 
    * @return
    */
   private boolean isTreble() {
      return this.isTreble;
   }
   
   private boolean isValid() {
      return isTreble || beatCount > 0;
   }
   /**
    * Sets the isTreble value to true when value is true and false when value is false.
    * @param value
    * @return
    */
   private boolean setTreble (boolean value) {
      
      boolean complete = false;
      
      if (!isTreble()) {
         isTreble = value;
         complete = true;
      }

      return complete;
      
   }
   
   /**
    * Returns string with clef of sheet music.
    * @return
    */
   private String getClef() {
      String clef = "treble";
      
      if (!isTreble()) clef = "bass";
      
      return clef;
      
   }

}
