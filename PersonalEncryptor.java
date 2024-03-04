public class PersonalEncryptor extends Encryptor {
    private int letterShift;
    private int rowShift;
    private int colShift;


    public PersonalEncryptor(int row, int col, int letterShift, int rowShift, int colShift) {
        super(row, col); // can use fillBlock(), decryptMessage(), and accessor methods (getLetterBlock, getNumRows, getNumCols)
        this.letterShift = letterShift;
        this.rowShift = rowShift;
        this.colShift = colShift;
    }


    // helper methods (private)
    private void letterShift(String[][] array)
    {
        for (int r = 0; r < array.length; r++)
        {
            for (int c = 0; c < array[0].length; c++)
            {
                String current = array[r][c];
                char character = current.charAt(0);
                int newChar = (int) character + letterShift;
                array[r][c] = Character.toString(newChar);
            }
        }
    }

    private void rowShift(String[][] array)
    {
        for (int r = 0; r < array.length; r++)
        {
            String[] current = array[r];
            if (rowShift < 0) // shift left
            {
                int shift = Math.abs(rowShift); // make a positive duplicate, easy for calculations
                String[] temps = new String[shift];
                for (int i = 0; i < shift; i++) // temps, those that would exceed bound when shifting
                {
                    temps[i] = current[i]; // indices are the same
                }
                for (int i = 0; i < current.length - shift; i++) // shift (no need to worry about exceeding indices
                {
                    current[i] = current[i + shift];
                }
                int index = 0; // for array temps
                for (int i = current.length - shift; i < current.length; i++) // putting temps into their positions after the shift
                {
                    current[i] = temps[index];
                    index++;
                }
            }
            else if (rowShift > 0) // shift right
            { // no need to make a positive duplicate since it is already positive
                String[] temps = new String[rowShift];
                int index = 0; // for temp
                for (int i = current.length - rowShift; i < current.length; i++) // temps, those that would exceed bound when shifting
                {
                    temps[index] = current[i];
                    index++;
                }
                for (int i = current.length - 1; i >= rowShift; i--) // shift without worrying "out of bound"
                {
                    current[i] = current[i - rowShift];
                }
                for (int i = 0; i < rowShift; i++) // those that would exceed bound, place them in appropriate positions
                {
                    current[i] = temps[i]; // the indices are the same
                }
            }
        }
    }

    private void columnShift(String[][] array)
    {
        int len = array[0].length; // assuming rectangular; len = length of row OR number of cols
        for (int r = 0; r < array.length; r++)
        {
            String[] newRow = new String[len];
            for (int c = 0; c < len; c++)
            {
                int placementIndex = c;
                placementIndex += colShift;
                while ((placementIndex >= 0 && placementIndex < len) == false) {
                    if (placementIndex < 0) // -1, -2, etc. OR left side exceed
                    {
                        int exceed = Math.abs(placementIndex);
                        placementIndex = len - exceed;
                    } else if (placementIndex >= len) // greatest index is len - 1, this checks if it exceeds on the right side
                    {
                        int exceed = placementIndex - len;
                        placementIndex = exceed;
                    }
                }
                newRow[placementIndex] = array[r][c];
            }
            array[r] = newRow;
        }
    }

    public String encrypt(String message)
    {
        String result = "";
        while (message.equals("") == false)
        {
            if (message.length() > getNumRows() * getNumCols()) // substring still extractable
            {
                fillBlock(message); // same as Encryptor; empty blocks becomes "A"
                String[][] array = getLetterBlock(); // easy name, easy access
                // letter shift
                letterShift(array);
                // row shift (could have been more complex)
                rowShift(array);
                // column shift (same functionality as row shift)
                columnShift(array);
                // add up all element (column major order)
                for (int c = 0; c < getNumCols(); c++) {
                    for (int r = 0; r < getNumRows(); r++) {
                        String current = array[r][c];
                        result += current;
                    }
                }
                // update
                message = message.substring(getNumRows() * getNumCols());
            }
            else // substring not extractable OR last time of being extractable
            {
                fillBlock(message); // same as Encryptor; empty blocks becomes "A"
                String[][] array = getLetterBlock(); // easy name, easy access
                // letter shift
                letterShift(array);
                // row shift (could have been more complex)
                rowShift(array);
                // column shift (same functionality as row shift)
                columnShift(array);
                // add up all element (column major order)
                for (int c = 0; c < getNumCols(); c++) {
                    for (int r = 0; r < getNumRows(); r++) {
                        String current = array[r][c];
                        result += current;
                    }
                }
                // update
                message = "";
            }
        }
        return result;
    }

    public String decrypt(String message)
    {
        String result = "";
        // decryptMessage(), so it can be in the correct order of row-column
        String decrypted = decryptMessage(message);
        // undo shifting
        while (decrypted.equals("") == false)
        {
            if (getNumRows() * getNumCols() < decrypted.length()) // substring still extractable
            {
                fillBlock(decrypted);
                String[][] array = getLetterBlock(); // easy access
                // make the values opposite (temporarily) (remember to change back)
                letterShift = -1 * letterShift;
                rowShift = -1 * rowShift;
                colShift = -1 * colShift;
                // shift
                columnShift(array);
                rowShift(array);
                letterShift(array);
                // reset the values
                letterShift = -1 * letterShift;
                rowShift = -1 * rowShift;
                colShift = -1 * colShift;
                // remove A
                for (int c = array[0].length - 1; c >= 0; c--)
                {
                    for (int r = array.length - 1; r >= 0; r--)
                    {
                        if (array[r][c].equals("A"))
                        {
                            array[r][c] = "";
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                // store result
                for (String[] r : array)
                {
                    for (String c : r)
                    {
                        result += c;
                    }
                }
                // update
                decrypted = decrypted.substring(getNumRows() * getNumCols());
            }
            else // substring not extractable OR last time to be extractable
            {
                fillBlock(decrypted);
                String[][] array = getLetterBlock(); // easy access
                // make the values opposite (temporarily) (remember to change back)
                letterShift = -1 * letterShift;
                rowShift = -1 * rowShift;
                colShift = -1 * colShift;
                // shift
                columnShift(array);
                rowShift(array);
                letterShift(array);
                // reset the values
                letterShift = -1 * letterShift;
                rowShift = -1 * rowShift;
                colShift = -1 * colShift;
                // remove A
                for (int c = array[0].length - 1; c >= 0; c--)
                {
                    for (int r = array.length - 1; r >= 0; r--)
                    {
                        if (array[r][c].equals("A"))
                        {
                            array[r][c] = "";
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                // store result
                for (String[] r : array)
                {
                    for (String c : r)
                    {
                        result += c;
                    }
                }
                // update
                decrypted = "";
            }
        }
        return result;
    }


}
