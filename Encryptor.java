import java.util.ArrayList;

public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        int index = 0;
        for (int r = 0; r < numRows; r++)
        {
            for (int c = 0; c < numCols; c++)
            {
                if (index < str.length())
                {
                    letterBlock[r][c] = str.substring(index, index+1);
                    index++;
                }
                else
                {
                    letterBlock[r][c] = "A";
                }
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String result = "";
        for (int c = 0; c < numCols; c++)
        {
            for (int r = 0; r < numRows; r++)
            {
                String current = letterBlock[r][c];
                result += current;
            }
        }
        return result;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String result = "";
        while (!message.equals(""))
        {
            if (message.length() > numCols * numRows)
            {
                String focus = message.substring(0, numRows * numCols);
                message = message.substring(numRows * numCols); // update
                fillBlock(focus);
                result += encryptBlock();
            }
            else
            {
                fillBlock(message);
                result += encryptBlock();
                message = ""; // final update
            }
        }
        return result;
    }


    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String result = "";

        //
        ArrayList<String[][]> arrays = new ArrayList<String[][]>();
        int divide = numRows * numCols;
        while (encryptedMessage.equals("") == false)
        {
            if (divide <= encryptedMessage.length()) {
                String current = encryptedMessage.substring(0, divide); // one 2D array
                encryptedMessage = encryptedMessage.substring(divide);
                String[][] array = new String[numCols][numRows];
                int rowIndex = 0;
                while (current.equals("") == false) {
                    String row = current.substring(0, numRows);
                    current = current.substring(numRows);
                    for (int i = 0; i < row.length(); i++) {
                        array[rowIndex][i] = row.substring(i, i + 1);
                    }
                    rowIndex++;
                }
                // remove A
                for (int c = array[0].length - 1; c >= 0; c--) {
                    for (int r = array.length - 1; r >= 0; r--) {
                        if (array[r][c].equals("A")) {
                            array[r][c] = "";
                        } else {
                            break;
                        }
                    }
                }
                arrays.add(array);
            }
            else
            {
                String current = encryptedMessage; // one 2D array
                encryptedMessage = "";
                String[][] array = new String[numCols][numRows];
                int rowIndex = 0;
                while (current.equals("") == false) {
                    String row = current.substring(0, numRows);
                    current = current.substring(numRows);
                    for (int i = 0; i < row.length(); i++) {
                        array[rowIndex][i] = row.substring(i, i + 1);
                    }
                    rowIndex++;
                }
                // remove A
                for (int c = array[0].length - 1; c >= 0; c--) {
                    for (int r = array.length - 1; r >= 0; r--) {
                        if (array[r][c] != null) {
                            if (array[r][c].equals("A")) {
                                array[r][c] = "";
                            } else {
                                break;
                            }
                        }
                    }
                }
                arrays.add(array);
            }
        }
        //
        for (String[][] array : arrays)
        {
            for (int c = 0; c < array[0].length; c++)
            {
                for (int r = 0; r < array.length; r++)
                {
                    result += array[r][c];
                }
            }
        }

        return result;
    }

}
